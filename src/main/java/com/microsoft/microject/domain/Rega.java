package com.microsoft.microject.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Rega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double umidade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public Rega() {
        this.dataHora = new Date();
    }

    public Rega(Double umidade) {
        this.umidade = umidade;
        this.dataHora = new Date();
    }

    public Long getId() {
        return id;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public Date getDataHora() {
        return dataHora;
    }

}
