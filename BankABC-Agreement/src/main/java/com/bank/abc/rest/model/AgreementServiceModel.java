package com.bank.abc.rest.model;

import com.bank.abc.persistence.entity.ServicioConvenio;
import lombok.Data;

@Data
public class AgreementServiceModel {
    private int id;
    private String operation;
    private String type;
    private String template;
    private String resultTemplate;
    private String httpMethod;
    private String httpHeader;
    private AgreementModel agreement;

    public AgreementServiceModel() {
    }

    public AgreementServiceModel(ServicioConvenio servicioConvenio) {
        this.id = servicioConvenio.getId();
        this.operation = servicioConvenio.getOperation();
        this.type = servicioConvenio.getType();
        this.template = servicioConvenio.getTemplate();
        this.httpMethod = servicioConvenio.getHttpMethod();
        this.httpHeader = servicioConvenio.getHttpHeader();
        this.agreement = new AgreementModel(servicioConvenio.getConvenio());
        this.resultTemplate=servicioConvenio.getTemplateRespuesta();
    }
}
