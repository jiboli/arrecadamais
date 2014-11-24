/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller.transacoes;

import java.util.ArrayList;
import java.util.List;

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
            retorno.add("Coberta de ouro");
            retorno.add("Com a pomba branca do espirito santo");
            retorno.add("Com uma cruz para simular a morte de cristo");
                 
            
            return retorno;
        }
    }, PARCELAS {

        @Override
        List<String> getListaTipoDescricao() {
            List<String> retorno = new ArrayList<>();
            retorno.add("1");
            retorno.add("2");
            retorno.add("3");
            retorno.add("4");
            retorno.add("5");
            
            
            return retorno;
        }
    };
    
    
    abstract List<String> getListaTipoDescricao();
    
}
