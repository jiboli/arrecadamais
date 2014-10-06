/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author torto
 */
public class DAODinamico<T> {

    ConexaoBD conexao = ConexaoBD.getInstance();

    public DAODinamico() {

    }

    public T inserir(T objeto) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        manager.getTransaction().begin();
        manager.persist(objeto);
        manager.getTransaction().commit();

        return objeto;

    }

    public void alterar(T objeto) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        manager.getTransaction().begin();
        manager.merge(objeto);
        manager.getTransaction().commit();

    }

    public void excluir(T objeto) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        manager.getTransaction().begin();
        manager.remove(objeto);
        manager.getTransaction().commit();

    }

    public T buscarById(Class classe, int id) {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        return (T) manager.find(classe, id);
    }

    public List<T> buscarListaById(Class classe, int id) {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

       Query query = manager.createQuery("select tabela from " + classe.getName() + " tabela where id = " + id);
       
        return (List<T>) query.getResultList();
    }

}
