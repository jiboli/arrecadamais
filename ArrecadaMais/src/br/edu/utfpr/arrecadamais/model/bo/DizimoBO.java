/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Dizimo;
import br.edu.utfpr.arrecadamais.model.vo.Dizimo;
import java.sql.SQLException;
import java.util.List;

public class DizimoBO implements ControleClasseCRUD<Dizimo> {

    private DAODinamico<Dizimo> dao = new DAODinamico<Dizimo>();

    @Override
    public Dizimo inserir(Dizimo objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public boolean excluir(Dizimo objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    @Override
    public Dizimo alterar(Dizimo objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Dizimo> buscarTotal() {
        List<Dizimo> listaRetorno = null;
        try {
            listaRetorno = (List<Dizimo>) dao.buscarListaByWhere(Dizimo.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Dizimo buscarByID(int ID) {
        Dizimo retorno = null;
        try {
            retorno = (Dizimo) dao.buscarById(Dizimo.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public List<Dizimo> buscarComFiltroGeral(String filtro){
         List<Dizimo> retorno = null;
        StringBuilder where = new StringBuilder();

        where.append("tipoDizimo like '%");
        where.append(filtro);
        where.append("%' OR tipoDecoracao like '%");
        where.append(filtro);
        where.append("%'");

        try {
            Integer.parseInt(filtro);
            where.append(" OR id = ");
            where.append(filtro);
            where.append(" OR total = ");
            where.append(filtro);
            
            where.append(" OR (largura * comprimento) = ");
            where.append(filtro);
        } catch (Exception e) {

        }

        try {
            if (filtro.isEmpty()) {
                retorno = (List<Dizimo>) dao.buscarListaByWhere(Dizimo.class, "");
            } else {
                retorno = (List<Dizimo>) dao.buscarListaByWhere(Dizimo.class, where.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

}
