/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JoãoHenrique
 */
public class ConexaoBD { 

    private static ConexaoBD bd;
    private Connection connection;
    private EntityManagerFactory factory;

    private ConexaoBD() {
        try {
            
            this.factory = Persistence
                    .createEntityManagerFactory("jpa");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static synchronized ConexaoBD getInstance() {
        if (bd == null) {
            bd = new ConexaoBD();
        }

        return bd;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public EntityManager getEntityManager() {
        return this.factory.createEntityManager();
    }

}
