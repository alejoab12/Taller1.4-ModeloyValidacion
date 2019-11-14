package com.bank.abc.rest.model;

import com.bank.abc.persistence.entity.Convenio;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AgreementModel {
    private int id;
    private String agreement;
    private String url;
    public AgreementModel() {
    }

    public AgreementModel(Convenio convenio) {
        this.id = convenio.getId();
        this.agreement = convenio.getConvenio();
        this.url = convenio.getUrl();
    }
}
