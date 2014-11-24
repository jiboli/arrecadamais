/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Ceo;
import java.sql.SQLException;
import java.util.List;

public class CeoBO implements ControleClasseCRUD<Ceo> {

    private DAODinamico<Ceo> dao = new DAODinamico<Ceo>();

    @Override
    public Ceo inserir(Ceo objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public boolean excluir(Ceo objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    @Override
    public Ceo alterar(Ceo objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Ceo> buscarTotal() {
        List<Ceo> listaRetorno = null;
        try {
            listaRetorno = (List<Ceo>) dao.buscarListaByWhere(Ceo.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Ceo buscarByID(int ID) {
        Ceo retorno = null;
        try {
            retorno = (Ceo) dao.buscarById(Ceo.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public List<Ceo> buscarComFiltroGeral(String filtro){
         List<Ceo> retorno = null;
        StringBuilder where = new StringBuilder();

        where.append("nomeCliente like '%");
        where.append(filtro);
        where.append("%'");

        try {
            Integer.parseInt(filtro);
            where.append(" OR id = ");
            where.append(filtro);   
            where.append(" OR valor = ");
            where.append(filtro);
        } catch (Exception e) {

        }

        try {
            if (filtro.isEmpty()) {
                retorno = (List<Ceo>) dao.buscarListaByWhere(Ceo.class, "");
            } else {
                retorno = (List<Ceo>) dao.buscarListaByWhere(Ceo.class, where.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

}
