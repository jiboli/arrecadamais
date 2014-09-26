/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.model.dao;

import br.edu.utfpr.arrecadamais.model.vo.Templo;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JoãoHenrique
 */
public class TemploDAO {
    public int inserir(Templo templo) throws SQLException{
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();
        
        manager.getTransaction().begin();
        manager.persist(templo);
        manager.getTransaction().commit();
        
        return templo.getTemploId();
        
    }
    
    public void alterar(Templo templo) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();
        
        manager.getTransaction().begin();
        manager.merge(templo);
        manager.getTransaction().commit();
        
    }
    
    public void excluir(Templo templo) throws SQLException {
        EntityManager manager = ConexaoBD.getInstance()
                .getEntityManager();
        
        manager.getTransaction().begin();
        manager.remove(manager.getReference(Templo.class, 
                templo.getTemploId()));
        manager.getTransaction().commit();
        
        
    }
    
   
    
   
    
}
