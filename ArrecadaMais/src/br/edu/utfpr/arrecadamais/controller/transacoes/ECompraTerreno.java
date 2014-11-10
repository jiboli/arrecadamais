/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller.transacoes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author torto
 */
public enum ECompraTerreno {
    
    TIPOTERRENO {

        @Override
        List<String> getListaTipoDescricao() {
            List<String> retorno = new ArrayList<>();
            retorno.add("Direita do Pai");
            retorno.add("Esquerda do Pai");
            retorno.add("Frente do Pai (Vizinho do Judas)");
            retorno.add("Atrás do Pai (A frente do anjo de luz)");
            
            return retorno;
        }
    }, TIPODECORACAO {

        @Override
        List<String> getListaTipoDescricao() {
             List<String> retorno = new ArrayList<>();
            retorno.add("");
            
            return retorno;
        }
    };
    
    
    abstract List<String> getListaTipoDescricao();
    
}
