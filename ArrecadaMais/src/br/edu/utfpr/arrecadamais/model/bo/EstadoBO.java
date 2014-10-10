/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Estado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public class EstadoBO  implements ControleClasseCRUD<Estado>{

    private DAODinamico<Estado> dao = new DAODinamico<Estado>();

    public EstadoBO() {
    }

  
    @Override
    public Estado inserir(Estado objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public void excluir(Estado objeto) {
        try {
            dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Estado alterar(Estado objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Estado> buscarTotal() {
        List<Estado> listaRetorno = null;
        try {
            listaRetorno = (List<Estado>) dao.buscarListaByWhere(Estado.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Estado buscarByID(int ID) {
        Estado retorno = null;
        try {
            retorno = (Estado) dao.buscarById(Estado.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
}
