/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Templo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public class TemploBO  implements ControleClasseCRUD<Templo>{

    private DAODinamico<Templo> dao = new DAODinamico<Templo>();

    public TemploBO() {
    }

  
    @Override
    public Templo inserir(Templo objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public void excluir(Templo objeto) {
        try {
            dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Templo alterar(Templo objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Templo> buscarTotal() {
        List<Templo> listaRetorno = null;
        try {
            listaRetorno = (List<Templo>) dao.buscarListaByWhere(Templo.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Templo buscarByID(int ID) {
        Templo retorno = null;
        try {
            retorno = (Templo) dao.buscarById(Templo.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
}
