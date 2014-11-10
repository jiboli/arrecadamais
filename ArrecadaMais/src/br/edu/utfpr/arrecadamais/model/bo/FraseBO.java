/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
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
    public boolean excluir(Frase objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
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
    
    public List<Frase> buscarComFiltroGeral(String filtro) {
        List<Frase> retorno = null;
        StringBuilder where = new StringBuilder();

        where.append("autor like '%");
        where.append(filtro);
        where.append("%'");

        try {
            where.append(" OR id = ");
            where.append(filtro);
        } catch (Exception e) {

        }

        try {
            if (filtro.isEmpty()) {
                retorno = (List<Frase>) dao.buscarListaByWhere(Frase.class, "");
            } else {
                retorno = (List<Frase>) dao.buscarListaByWhere(Frase.class, where.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }
    
}
