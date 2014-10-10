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
import javax.persistence.OneToMany;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author JoãoHenrique
 */
@Entity
@Table(name = "templos")
public class Templo implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Cidade cidade;
    
    @Column
    private String rua;
    
    @Column
    private int numero;
    
    @Column
    private int capacidade;
    
    public Templo(){
        this.setId(0);
        this.setNome("");
        this.setCidade(new Cidade());
        this.setRua("");
        this.setNumero(0);
        this.setCapacidade(0);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
