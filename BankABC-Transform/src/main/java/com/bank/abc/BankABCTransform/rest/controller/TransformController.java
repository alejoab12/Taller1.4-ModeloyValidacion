package com.bank.abc.BankABCTransform.rest.controller;

import com.bank.abc.BankABCTransform.business.service.TransformService;
import com.bank.abc.BankABCTransform.rest.model.TransformModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transform")
public class TransformController {
    @Autowired
    @Qualifier("TransformServiceProxy")
    private TransformService transformService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
    public ResponseEntity<String> transform(@RequestBody TransformModel transform) throws JsonMappingException, JsonProcessingException, TransformerException{
        return ResponseEntity.ok(transformService.transform(transform));
    }
}
