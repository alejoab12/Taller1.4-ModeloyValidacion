package com.bank.abc.service;

import com.bank.abc.rest.model.CheckPayRespModel;
import com.bank.abc.rest.model.PayAgreementReqModel;
import com.bank.abc.rest.model.PayAgreementRespModel;

public interface CompositionService {
    public CheckPayRespModel checkPayment(String reference);
    public PayAgreementRespModel payAgreement(PayAgreementReqModel pay);
}
