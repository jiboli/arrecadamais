/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public class FieisBO implements ControleClasseCRUD<Fieis>{

    private DAODinamico<Fieis> dao = new DAODinamico<Fieis>();

    public FieisBO() {
    }

    @Override
    public Fieis inserir(Fieis objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public void excluir(Fieis objeto) {
        try {
            dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Fieis alterar(Fieis objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Fieis> buscarTotal() {
        List<Fieis> listaRetorno = null;
        try {
            listaRetorno = (List<Fieis>) dao.buscarListaByWhere(Fieis.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Fieis buscarByID(int ID) {
        Fieis retorno = null;
        try {
            retorno = (Fieis) dao.buscarById(Fieis.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
}
