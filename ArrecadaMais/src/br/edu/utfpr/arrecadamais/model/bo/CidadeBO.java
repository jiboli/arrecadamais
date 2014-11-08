/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Cidade;
import br.edu.utfpr.arrecadamais.model.vo.Cidade;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public class CidadeBO  implements ControleClasseCRUD<Cidade>{

    private DAODinamico<Cidade> dao = new DAODinamico<Cidade>();

    public CidadeBO() {
    }

  
    @Override
    public Cidade inserir(Cidade objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public boolean excluir(Cidade objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    @Override
    public Cidade alterar(Cidade objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Cidade> buscarTotal() {
        List<Cidade> listaRetorno = null;
        try {
            listaRetorno = (List<Cidade>) dao.buscarListaByWhere(Cidade.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Cidade buscarByID(int ID) {
        Cidade retorno = null;
        try {
            retorno = (Cidade) dao.buscarById(Cidade.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public List<Cidade> buscaListaById(int id){
        
        return dao.buscarListaByWhere(Cidade.class, "estado = "+id);
        
    }
}
