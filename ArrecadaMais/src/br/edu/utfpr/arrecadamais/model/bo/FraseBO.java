/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Frase;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public class FraseBO implements ControleClasseCRUD<Frase>{

    private DAODinamico<Frase> dao = new DAODinamico<Frase>();

    public FraseBO() {
    }

  
    @Override
    public Frase inserir(Frase objeto) {
        try {
            if(objeto.getId() != 0){
                dao.alterar(objeto);
            }
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public void excluir(Frase objeto) {
        try {
            dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Frase alterar(Frase objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Frase> buscarTotal() {
        List<Frase> listaRetorno = null;
        try {
            listaRetorno = (List<Frase>) dao.buscarListaByWhere(Frase.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Frase buscarByID(int ID) {
        Frase retorno = null;
        try {
            retorno = (Frase) dao.buscarById(Frase.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
}
