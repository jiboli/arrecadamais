/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dizimo")
public class Dizimo implements Serializable, VoConstante{
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private double valorMin;
    
    @Column
    private double valorAdicionar;
    
    @Column
    private String nomeCliente;
        
    @Column
    private String numeroCartao;
    
    @Column
    private String nomeCartao;
    
    @Column
    private int codSeguranca;
    
    @ManyToOne
    @JoinColumn(name = "fieis_id", insertable = true, updatable = false)
    private Fieis fiel;
    
     @Column(name = "data_validade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    public Dizimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorMin() {
        return valorMin;
    }

    public void setValorMin(double valorMin) {
        this.valorMin = valorMin;
    }

    public double getValorAdicionar() {
        return valorAdicionar;
    }

    public void setValorAdicionar(double valorAdicionar) {
        this.valorAdicionar = valorAdicionar;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public int getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }   

    @Override
    public int getIdConstante() {
        return getId();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Fieis getFiel() {
        return fiel;
    }

    public void setFiel(Fieis fiel) {
        this.fiel = fiel;
    }
    
}
