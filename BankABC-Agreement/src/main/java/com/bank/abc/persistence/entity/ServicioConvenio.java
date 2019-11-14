package com.bank.abc.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="servicio_convenio")
@Table(name="servicio_convenio")
public class ServicioConvenio {
    @Id
    private int id;
    @ManyToOne(targetEntity = Convenio.class)
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;
    private String operation;
    @JoinColumn(name = "operation_name")
    private String operationName;
    private String type;
    private String template;
    @Column(name="template_respuesta")
    private String templateRespuesta;
    @Column(name="http_method")
    private String httpMethod;
    @Column(name="http_header")
    private String httpHeader;
}
