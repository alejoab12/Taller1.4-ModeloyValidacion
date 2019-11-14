package com.bank.abc.business.service.imp;

import com.bank.abc.business.service.ConvenioService;
import com.bank.abc.persistence.entity.Convenio;
import com.bank.abc.persistence.entity.ServicioConvenio;
import com.bank.abc.persistence.repository.ConvenioRepository;
import com.bank.abc.persistence.repository.ServicioConvenioRepository;
import com.bank.abc.rest.handler.exception.CustomerException;
import com.bank.abc.rest.model.AgreementModel;
import com.bank.abc.rest.model.AgreementServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvenioServiceImp implements ConvenioService {
    @Autowired
    private ConvenioRepository convenioRepo;
    @Autowired
    private ServicioConvenioRepository servicioConvenioRepository;
    @Override
    public AgreementServiceModel consultarConvenio(String referencia, String operationName) {
        Convenio convenio=null;
        ServicioConvenio servicioConvenio=null;
        if(referencia.trim().isEmpty()||referencia.length()<4){
            throw new CustomerException(400,"Referencia Incorrecta");
        }
        convenio=convenioRepo.findByConvenio(referencia.substring(0,4));
        if(convenio==null){
            throw new CustomerException(404,"Referencia no encontrada");
        }
        servicioConvenio=servicioConvenioRepository.findByConvenioAndOperationName(convenio,operationName);
        if(servicioConvenio==null){
            throw new CustomerException(404,"Operacion no encontrada");
        }
        return new AgreementServiceModel(servicioConvenio);
    }
}
