/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.bo;

import br.edu.utfpr.arrecadamais.controller.ControleClasseCRUD;
import br.edu.utfpr.arrecadamais.model.dao.DAODinamico;
import br.edu.utfpr.arrecadamais.model.vo.Pastor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public class PastorBO  implements ControleClasseCRUD<Pastor>{

    private DAODinamico<Pastor> dao = new DAODinamico<Pastor>();

    public PastorBO() {
    }

  
    @Override
    public Pastor inserir(Pastor objeto) {
        try {
            objeto = dao.inserir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objeto;
    }

    @Override
    public boolean excluir(Pastor objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    @Override
    public Pastor alterar(Pastor objeto) {
        try {
            dao.alterar(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    @Override
    public List<Pastor> buscarTotal() {
        List<Pastor> listaRetorno = null;
        try {
            listaRetorno = (List<Pastor>) dao.buscarListaByWhere(Pastor.class, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listaRetorno;
    }

    @Override
    public Pastor buscarByID(int ID) {
        Pastor retorno = null;
        try {
            retorno = (Pastor) dao.buscarById(Pastor.class, ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
      public List<Pastor> buscarComFiltroGeral(String filtro) {
        List<Pastor> retorno = null;
        StringBuilder where = new StringBuilder();

        where.append("nome like '%");
        where.append(filtro);
        where.append("%' OR sobrenome like '%");
        where.append(filtro);
        where.append("%'");

        try {
            Integer.parseInt(filtro);
            where.append(" OR id = ");
            where.append(filtro);
            where.append(" OR salario = ");
            where.append(filtro);
        } catch (Exception e) {

        }

        try {
            if (filtro.isEmpty()) {
                retorno = (List<Pastor>) dao.buscarListaByWhere(Pastor.class, "");
            } else {
                retorno = (List<Pastor>) dao.buscarListaByWhere(Pastor.class, where.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }
    
}
