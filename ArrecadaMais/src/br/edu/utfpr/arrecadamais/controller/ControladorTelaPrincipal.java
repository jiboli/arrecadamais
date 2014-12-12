/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaCeo;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaDizimo;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFieis;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFrase;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaPastor;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaTemplo;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaTerrenos;
import br.edu.utfpr.arrecadamais.view.TelaPrincipal;
import br.edu.utfpr.arrecadamais.view.views.ViewCEO;
import br.edu.utfpr.arrecadamais.view.views.ViewDizimo;
import br.edu.utfpr.arrecadamais.view.views.ViewFiel;
import br.edu.utfpr.arrecadamais.view.views.ViewFrase;
import br.edu.utfpr.arrecadamais.view.views.ViewPastores;
import br.edu.utfpr.arrecadamais.view.views.ViewTemplo;
import br.edu.utfpr.arrecadamais.view.views.ViewTerrenos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author JoãoHenrique
 */
public class ControladorTelaPrincipal {
    private TelaPrincipal telaP = new TelaPrincipal();

    public ControladorTelaPrincipal() {
       
        this.telaP.getMnTerreno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cancelar();//fecha a tela
                ControladorListaTerrenos terrenos = new ControladorListaTerrenos();
                terrenos.abrirTela();
            }
        });
        this.telaP.getBtnTerreno().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaTerrenos terrenos = new ControladorListaTerrenos();
                terrenos.abrirTela();
            }           
            
        });
        
        this.telaP.getMnTemplo().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaTemplo templo = new ControladorListaTemplo();
                templo.abrirTela();
            }
            
        });
        this.telaP.getBtnTemplo().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaTemplo templo = new ControladorListaTemplo();
                templo.abrirTela();
            }
            
        });
        
        this.telaP.getMnSair().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                telaP.dispose();
            }
            
        });
        
        this.telaP.getMnPastor().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaPastor pastor = new ControladorListaPastor();
                pastor.abrirTela();
                
            }
            
        });
        
        this.telaP.getBtnPastor().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaPastor pastor = new ControladorListaPastor();
                pastor.abrirTela();
                
            }
            
        });
        
        this.telaP.getMnFrase().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaFrase frase = new ControladorListaFrase();
                frase.abrirTela();
                
            }
        
        });
        this.telaP.getBtnFrase().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaFrase frase = new ControladorListaFrase();
                frase.abrirTela();
                
            }
        
        });
        
        this.telaP.getMnFiel().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaFieis fiel = new ControladorListaFieis();
                fiel.abrirTela();
            }
            
        });
        this.telaP.getBtnFiel().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaFieis fiel = new ControladorListaFieis();
                fiel.abrirTela();
            }
            
        });
        
        this.telaP.getMnDizimo().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaDizimo dizimo = new ControladorListaDizimo();
                dizimo.abrirTela();
            }
            
        });
        this.telaP.getBtnDizimo().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaDizimo dizimo = new ControladorListaDizimo();
                dizimo.abrirTela();
            }
            
        });
        
        this.telaP.getMnCEO().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaCeo ceo = new ControladorListaCeo();
                ceo.abrirTela();
            }
            
        });
        this.telaP.getBtnCEO().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorListaCeo ceo = new ControladorListaCeo();
                ceo.abrirTela();
                
            }
            
        });
        
        this.telaP.getMenuClientesRelatorios().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               ControladorRelatorioClientes fieis = new ControladorRelatorioClientes();
            }
        });
        
        telaP.setVisible(true);
        
        }
        
    }
    
    

