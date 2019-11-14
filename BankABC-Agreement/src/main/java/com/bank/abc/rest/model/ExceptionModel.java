package com.bank.abc.rest.model;

import lombok.Data;

@Data
public class ExceptionModel {
    private String message;
    public ExceptionModel(String message){
        this.message=message;
    }
}
