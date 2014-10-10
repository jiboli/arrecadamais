/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.model.bo.FieisBO;
import br.edu.utfpr.arrecadamais.model.vo.Cidade;
import br.edu.utfpr.arrecadamais.model.vo.Estado;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
import br.edu.utfpr.arrecadamais.view.CadastroFieis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JoãoHenrique
 */
public class ControladorCadastroFieis implements ControleClasseCRUD<Fieis>{
    private CadastroFieis telaCadastro;
    private int retorno;
    private List<Estado> itemsEstado;
    private List<Cidade> itemsCidade;
    private List itemsEscolaridade;

    public ControladorCadastroFieis(JFrame parent) {
        this.telaCadastro = new CadastroFieis(parent, true);
        this.telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.telaCadastro.setCmbEstado(null);
        
        this.telaCadastro.getBtnCancelar()
                .addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        
        this.telaCadastro.getBtnCadastrar()
                .addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
    }
    
    

    @Override
    public Fieis inserir(Fieis objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fieis excluir(Fieis objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fieis alterar(Fieis objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fieis> buscarTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fieis buscarByID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void cancelar(){
        this.telaCadastro.dispose();
        
        this.retorno =  JOptionPane.CANCEL_OPTION;
    }
    private void salvar(){
        try {
            
        
            this.carregaDadosObjeto();
        
            bo.inserirOuAlterarSenha(this.senha);
            
            JOptionPane.showMessageDialog(this.telaCadastro, 
                    "Senha cadastrada com sucesso.");
            
            this.telaCadastro.dispose();
            
            this.retorno =  JOptionPane.OK_OPTION;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.telaCadastro, 
                    ex.getMessage());
        }
    }
private void carregaDadosTela(){
       /* this.telaCadastro.getCmbEstado().setModel(new DefaultComboBoxModel(itemsEstado));
        this.telaCadastro.getCmbEstado().getModel().setSelectedItem(this);
        this.telaCadastro.getCmbEscolaridade().setModel(new DefaultComboBoxModel(itemsEscolaridade));
        this.telaCadastro.getCmbEscolaridade().getModel().setSelectedItem(this);*/
    }
private Fieis carregaDadosObjeto(){
        Fieis fieis = new Fieis();
    }
}
