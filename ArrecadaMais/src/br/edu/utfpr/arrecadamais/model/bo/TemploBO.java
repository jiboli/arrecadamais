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
    public boolean excluir(Templo objeto) {
        boolean retorno = false;
        try {
            retorno = dao.excluir(objeto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
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
    
      public List<Templo> buscarComFiltroGeral(String filtro) {
        List<Templo> retorno = null;
        StringBuilder where = new StringBuilder();

        where.append("nome like '%");
        where.append(filtro);
        where.append("%'");
        where.append(" OR rua like '%");
        where.append(filtro);
        where.append("%'");
        where.append(" OR cidade.nome like '%");
        where.append(filtro);
        where.append("%'");

        try {
            Integer.parseInt(filtro);
            where.append(" OR id = ");
            where.append(filtro);
            where.append(" OR numero = ");
            where.append(filtro);
            where.append(" OR capacidade = ");
            where.append(filtro);
        } catch (Exception e) {

        }

        try {
            if (filtro.isEmpty()) {
                retorno = (List<Templo>) dao.buscarListaByWhere(Templo.class, "");
            } else {
                retorno = (List<Templo>) dao.buscarListaByWhere(Templo.class, where.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }
    
}
