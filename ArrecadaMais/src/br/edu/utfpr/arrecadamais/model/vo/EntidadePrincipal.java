/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author torto
 */
@Entity
public class EntidadePrincipal {
    
    @Id
    @GeneratedValue
    private int id;

    public EntidadePrincipal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
