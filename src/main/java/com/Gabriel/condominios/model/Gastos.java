/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Gabriel.condominios.model;

import java.util.Date;

/**
 *
 * @author Gabriel_PC
 */
public class Gastos {
    private Double valorDaConta ;
    private Double valorDoGasto;
    private Date  dataDodebito;
    private String descricao;

    public Double getValorDaConta() {
        return valorDaConta;
    }

    public void setValorDaConta(Double valorDaConta) {
        this.valorDaConta = valorDaConta;
    }

    public Double getValorDoGasto() {
        return valorDoGasto;
    }

    public void setValorDoGasto(Double valorDoGasto) {
        this.valorDoGasto = valorDoGasto;
    }

    public Date getDataDodebito() {
        return dataDodebito;
    }

    public void setDataDodebito(Date dataDodebito) {
        this.dataDodebito = dataDodebito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
