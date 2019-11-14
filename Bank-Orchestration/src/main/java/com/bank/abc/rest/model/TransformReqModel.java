package com.bank.abc.rest.model;

import lombok.Data;

@Data
public class TransformReqModel {
    private String message;
    private String template;
    private String type;
    public TransformReqModel(){}
    public TransformReqModel(String message,String template,String type){
        this.message=message;
        this.template=template;
        this.type=type;
    }

}