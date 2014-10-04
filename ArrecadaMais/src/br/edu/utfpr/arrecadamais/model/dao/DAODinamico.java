/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.dao;

import br.edu.utfpr.arrecadamais.model.vo.EntidadePrincipal;
import br.edu.utfpr.arrecadamais.model.vo.Templo;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author torto
 */
public class DAODinamico<T extends EntidadePrincipal> {

    ConexaoBD conexao = ConexaoBD.getInstance();

    public DAODinamico() {

    }

    public int inserir(T objeto) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        manager.getTransaction().begin();
        manager.persist(objeto);
        manager.getTransaction().commit();

        return objeto.getId();

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
        manager.remove(objeto.getId());
        manager.getTransaction().commit();

    }

    public T buscarById(T objeto) {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        return (T) manager.find(objeto.getClass(), objeto.getId());
    }

    public List<T> buscarListaById(T objeto) {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

       Query query = manager.createQuery("select tabela from " + objeto.getClass().getName() + " where id = " + objeto.getId());
       
        return (List<T>) query.getResultList();
    }

}
