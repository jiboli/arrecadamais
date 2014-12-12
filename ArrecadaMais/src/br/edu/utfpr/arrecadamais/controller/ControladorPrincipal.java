/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaCeo;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaDizimo;
import br.edu.utfpr.arrecadamais.view.TelaPrincipal;
 
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFieis;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFrase;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaPastor;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaTemplo;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaTerrenos;
import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCadastroDizimo;
import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCompraTerreno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author JoãoHenrique
 */
public class ControladorPrincipal {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new ControladorTelaPrincipal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
//        new TelaPrincipal().setVisible(true);
//        ControladorListaFieis lista = new ControladorListaFieis();
//        lista.abrirTela();

        
//        ControladorListaPastor lista = new ControladorListaPastor();
//        lista.abrirTela();
        

//        ControladorListaTemplo lista = new ControladorListaTemplo();
//        lista.abrirTela();


        
//        ControladorListaFrase lista = new ControladorListaFrase();
//        lista.abrirTela();
        
//        ControladorCompraTerreno cadastro = new ControladorCompraTerreno(null);
//        cadastro.abrirTela();
        
//        ControladorListaTerrenos lista = new ControladorListaTerrenos();
//        lista.abrirTela();
        
//        ControladorCadastroDizimo cadastro = new ControladorCadastroDizimo(null);
//        cadastro.abrirDizimo();
        
//        ControladorListaDizimo lista = new ControladorListaDizimo();
//        lista.abrirTela();
        
//        ControladorListaCeo lista = new ControladorListaCeo();
//        lista.abrirTela();
    }
    
}
