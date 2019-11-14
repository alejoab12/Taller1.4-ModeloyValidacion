package com.bank.abc.rest.model;

import lombok.Data;

@Data
public class AgreementServiceModel {
    private String operation;
    private String type;
    private String template;
    private String resultTemplate;
    private String httpMethod;
    private String httpHeader;
    private AgreementModel agreement;
}
