/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Terreno;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author torto
 */
public class TerrenoBO implements ControleClasseCRUD<Terreno> {

    private DAODinamico<Terreno> dao = new DAODinamico<Terreno>();

    @Override
    public Terreno inserir(Terreno objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public boolean excluir(Terreno objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    @Override
    public Terreno alterar(Terreno objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Terreno> buscarTotal() {
        List<Terreno> listaRetorno = null;
        try {
            listaRetorno = (List<Terreno>) dao.buscarListaByWhere(Terreno.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Terreno buscarByID(int ID) {
        Terreno retorno = null;
        try {
            retorno = (Terreno) dao.buscarById(Terreno.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public List<Terreno> buscarComFiltroGeral(String filtro){
         List<Terreno> retorno = null;
        StringBuilder where = new StringBuilder();

        where.append("tipoTerreno like '%");
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
                retorno = (List<Terreno>) dao.buscarListaByWhere(Terreno.class, "");
            } else {
                retorno = (List<Terreno>) dao.buscarListaByWhere(Terreno.class, where.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

}
