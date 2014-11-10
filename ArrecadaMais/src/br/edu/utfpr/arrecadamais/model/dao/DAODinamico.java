/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.dao;

import br.edu.utfpr.arrecadamais.model.vo.VoConstante;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author torto
 */
public class DAODinamico<T extends VoConstante> {

    ConexaoBD conexao = ConexaoBD.getInstance();

    public DAODinamico() {

    }

    public T inserir(T objeto) throws SQLException {
        if (objeto.getIdConstante() == 0) {
            EntityManager manager = ConexaoBD.getInstance()
                    .getEntityManager();

            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
        } else {
            alterar(objeto);
        }

        return objeto;

    }

    public void alterar(T objeto) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();

        manager.getTransaction().begin();
        manager.merge(objeto);
        manager.getTransaction().commit();

    }

    public boolean excluir(T objeto) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(manager.getReference(objeto.getClass(), objeto.getIdConstante()));
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
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

    public List<T> buscarListaByWhere(Class classe, String where) {
        EntityManager manager = ConexaoBD.getInstance().getEntityManager();

        Query query = null;
        if (where.isEmpty()) {
            query = manager.createQuery("select tabela from " + classe.getName() + " tabela");
        } else {
            query = manager.createQuery("select tabela from " + classe.getName() + " tabela where " + where);
        }

        return (List<T>) query.getResultList();
    }
}
