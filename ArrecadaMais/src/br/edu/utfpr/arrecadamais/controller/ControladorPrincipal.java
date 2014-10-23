/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

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
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ControladorCadastroFieis fiel = new ControladorCadastroFieis(null);
        fiel.abrirFiel();
        ControladorCadastroPastores pastor = new ControladorCadastroPastores(null);
        pastor.abrirPastor();
        
        
        
    }
    
}
