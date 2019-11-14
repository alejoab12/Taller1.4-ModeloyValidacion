package com.bank.abc.BankABCTransform.business.service;

import javax.xml.transform.TransformerException;

import com.bank.abc.BankABCTransform.rest.model.TransformModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface TransformService {
    public String transform(TransformModel transformModel) throws JsonMappingException, JsonProcessingException, TransformerException ;
}
