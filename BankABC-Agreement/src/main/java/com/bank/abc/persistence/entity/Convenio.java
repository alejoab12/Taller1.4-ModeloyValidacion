package com.bank.abc.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "convenio")
@Table(name="convenio")
public class Convenio {
    @Id
    private int id;
    private String convenio;
    private String url;
}
