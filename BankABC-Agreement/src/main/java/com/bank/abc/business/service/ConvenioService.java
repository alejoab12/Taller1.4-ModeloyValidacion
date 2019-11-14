package com.bank.abc.business.service;

import com.bank.abc.rest.model.AgreementModel;
import com.bank.abc.rest.model.AgreementServiceModel;


public interface ConvenioService {
    public AgreementServiceModel consultarConvenio(String convenio, String referencia);

}
