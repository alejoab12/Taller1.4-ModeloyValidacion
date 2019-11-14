package com.bank.abc.rest.controller;

import com.bank.abc.business.service.ConvenioService;


import com.bank.abc.rest.model.AgreementServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreement")
public class RoutingController {
    @Autowired
    private ConvenioService convenioService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgreementServiceModel> consultarConvenio(@RequestParam("reference") String referencia, @RequestParam("operationName")String operationName){
        return ResponseEntity.ok(convenioService.consultarConvenio(referencia,operationName));
    }

}
