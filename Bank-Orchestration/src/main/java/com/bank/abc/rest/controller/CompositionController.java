package com.bank.abc.rest.controller;

import com.bank.abc.rest.model.CheckPayRespModel;

import com.bank.abc.rest.model.PayAgreementReqModel;
import com.bank.abc.rest.model.PayAgreementRespModel;
import com.bank.abc.service.CompositionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/bankabc/services")
public class CompositionController {
    @Autowired
    private CompositionService compositionService;
    @GetMapping(value = "/consultpayment",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = MediaType.ALL_VALUE )
    public ResponseEntity<CheckPayRespModel> consultPayment(@RequestParam("reference") String reference){
        return ResponseEntity.ok(compositionService.checkPayment(reference));
    }
    @PostMapping(value = "/payagreement",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = MediaType.ALL_VALUE)
    public ResponseEntity<PayAgreementRespModel> payAgreement(@RequestBody PayAgreementReqModel pay){
        return ResponseEntity.ok(compositionService.payAgreement(pay));
    }
}
