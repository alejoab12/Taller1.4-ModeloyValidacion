package com.bank.abc.rest.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PayAgreementReqModel {
    private String reference;
    private BigDecimal totalPay;
}
