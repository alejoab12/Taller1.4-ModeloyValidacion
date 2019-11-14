package com.bank.abc.service.imp;

import com.bank.abc.rest.model.*;
import com.bank.abc.service.CompositionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CompositionServiceImp implements CompositionService {
    @Autowired
    private Environment env;

    @Override
    public CheckPayRespModel checkPayment(String reference) {

        String urlServiceTransform = env.getProperty("url.service.transform");
        String tagReference = env.getProperty("tag.reference");
        String urlServiceAgreement = null;
        String requestMessage = null;
        String result = null;
        CheckPayRespModel checkRespModel = null;
        try {
            AgreementServiceModel agreementServiceModel = getAgreementServiceModel(reference,"query");
            if (agreementServiceModel.getHttpMethod().equals("get") && agreementServiceModel.getType().equals("rest")) {
                urlServiceAgreement = agreementServiceModel.getAgreement().getUrl().concat(agreementServiceModel.getOperation()).replace(tagReference, reference);
                result = (String) getCall(urlServiceAgreement, String.class).getBody();
            } else {
                urlServiceAgreement = agreementServiceModel.getAgreement().getUrl().concat(agreementServiceModel.getOperation());
                requestMessage = agreementServiceModel.getTemplate().replace(tagReference, reference);
                result = (String) postCall(urlServiceAgreement, requestMessage, String.class, agreementServiceModel.getHttpHeader()).getBody();
            }
            checkRespModel = (CheckPayRespModel) postCall(urlServiceTransform,
                    new TransformReqModel(result, agreementServiceModel.getResultTemplate(),
                            agreementServiceModel.getType()), CheckPayRespModel.class, "{\"Content-Type\":\"application/json\"}").getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return checkRespModel;
    }

    @Override
    public PayAgreementRespModel payAgreement(PayAgreementReqModel pay) {
        String urlServiceTransform = env.getProperty("url.service.transform");
        String tagReference = env.getProperty("tag.reference");
        String tagTotalPay = env.getProperty("tag.total.pay");
        String requestMessage = null;
        String result = null;
        PayAgreementRespModel payResp=null;
        try {
            AgreementServiceModel agreementServiceModel = getAgreementServiceModel(pay.getReference(),"pay");
            String urlServiceAgreement = agreementServiceModel.getAgreement().getUrl().concat(agreementServiceModel.getOperation()).replace(tagReference,pay.getReference());
            requestMessage = agreementServiceModel.getTemplate().replace(tagReference, pay.getReference()).replace(tagTotalPay, pay.getTotalPay().toString());
            result = (String) postCall(urlServiceAgreement, requestMessage, String.class, agreementServiceModel.getHttpHeader()).getBody();
            payResp = (PayAgreementRespModel) postCall(urlServiceTransform,
                    new TransformReqModel(result, agreementServiceModel.getResultTemplate(),
                            agreementServiceModel.getType()), PayAgreementRespModel.class, "{\"Content-Type\":\"application/json\"}").getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return payResp;
    }

    private AgreementServiceModel getAgreementServiceModel(String reference,String operation) {
        String urlServiceAgreement
                = env.getProperty("url.service.agreement").concat(reference).concat("&operationName=").concat(operation);
        ResponseEntity<AgreementServiceModel> response
                = getCall(urlServiceAgreement, AgreementServiceModel.class);
        return response.getBody();
    }

    private <T> ResponseEntity<T> getCall(String url, Class<?> typeClass) {
        RestTemplate restTemplate = new RestTemplate();
        return (ResponseEntity<T>) restTemplate.getForEntity(url, typeClass);
    }

    private <T> ResponseEntity<T> postCall(String url, Object req, Class<?> typeClass, String jsonHeaders) throws JsonProcessingException {
        Map<String, String> headersMap = null;
        HttpEntity<Object> reqBody = null;
        if (jsonHeaders != null&&!jsonHeaders.trim().isEmpty()) {
            headersMap = StringHeaderToMap(jsonHeaders);
            HttpHeaders headers = new HttpHeaders();
            headers.setAll(headersMap);
            reqBody = new HttpEntity<>(req, headers);
        } else {
            reqBody = new HttpEntity<>(req);
        }
        RestTemplate restTemplate = new RestTemplate();
        return (ResponseEntity<T>) restTemplate.postForEntity(url, reqBody, typeClass);
    }

    private Map<String, String> StringHeaderToMap(String headers) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode headersNode = mapper.readTree(headers);
        return mapper.convertValue(headersNode, new TypeReference<Map<String, String>>() {
        });
    }
}
