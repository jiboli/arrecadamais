/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author torto
 */
public class ControladorRelatorios {
    
    public void exibeRelatorio(String titulo, JasperPrint relatorio){
        
        JFrame frame = new JFrame(titulo);
        JRViewer view = new JRViewer(relatorio);
        
        frame.add(view, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.setVisible(true);
    }
    
}
