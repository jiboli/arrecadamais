/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terrenos")
public class Terreno implements Serializable, VoConstante {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String tipoTerreno;
  
    @Column
    private String tipoDecoracao;
  
    @Column
    private double total;
   
    @Column
    private int parcelas;
  
    @Column
    private double juros;
 
    @Column
    private double largura;
  
    @Column
    private double comprimento;
 
    @Column
    private String numeroCartao;
 
    @Column
    private String nomeCartao;
  
    @Column
    private int numeroSegurancaCartao;
 
    @Column
    private String dataValidade;
 
    @Column
    private boolean presente;

    public Terreno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public String getTipoDecoracao() {
        return tipoDecoracao;
    }

    public void setTipoDecoracao(String tipoDecoracao) {
        this.tipoDecoracao = tipoDecoracao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
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

    public int getNumeroSegurancaCartao() {
        return numeroSegurancaCartao;
    }

    public void setNumeroSegurancaCartao(int numeroSegurancaCartao) {
        this.numeroSegurancaCartao = numeroSegurancaCartao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    @Override
    public int getIdConstante() {
        return getId();
    }

}
