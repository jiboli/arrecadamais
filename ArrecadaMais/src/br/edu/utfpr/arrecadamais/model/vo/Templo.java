/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JoãoHenrique
 */
@Entity
@Table(name = "Templos")
public class Templo {
    
    @Id
    @GeneratedValue
    private int TemploId;
    private String NomeTemplo;
    private Cidade cidade;
    private Estado estado;
    private String rua;
    private int numero;
    private int capacidade;
    
    public Templo(){
        this.setTemploId(0);
        this.setNomeTemplo("");
        this.setCidade(new Cidade());
        this.setEstado(new Estado());
        this.setRua("");
        this.setNumero(0);
        this.setCapacidade(0);
        
    }

    public void setTemploId(int TemploId) {
        this.TemploId = TemploId;
    }
    

    public int getTemploId() {
        return this.TemploId;
    }

    public String getNomeTemplo() {
        return NomeTemplo;
    }

    public void setNomeTemplo(String NomeTemplo) {
        this.NomeTemplo = NomeTemplo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    
    
}
