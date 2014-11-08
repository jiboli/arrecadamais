/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFieis;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFrase;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaPastor;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaTemplo;
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
//        ControladorListaFieis lista = new ControladorListaFieis();
//        lista.abrirListaFiel();
        
//        ControladorListaPastor lista = new ControladorListaPastor();
//        lista.abrirListaFiel();
        
//        ControladorListaTemplo lista = new ControladorListaTemplo();
//        lista.abrirListaFiel();
        
        ControladorListaFrase lista = new ControladorListaFrase();
        lista.abrirListaFiel();
        
    }
    
}
