/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.model.bo.FraseBO;
import br.edu.utfpr.arrecadamais.model.vo.Frase;
import br.edu.utfpr.arrecadamais.view.cadastros.CadastroFrase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import oracle.jrockit.jfr.JFR;

/**
 *
 * @author JoãoHenrique
 */
public class ControladorCadastroFrase implements ControleControler<Frase> {

    private CadastroFrase telaFrase;
    private Frase frase;

    public ControladorCadastroFrase(Frase frase) {
        this.frase = frase;
        
        if(frase == null){
            frase = new Frase();
        } else {
            carregaDadosTela(frase);;
        }
        
        this.telaFrase = new CadastroFrase();
        this.telaFrase.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.telaFrase.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        this.telaFrase.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
    }

    public void cancelar() {
       this.telaFrase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.telaFrase.dispose(); // fecha a janela
    }

    public void salvar() {
        FraseBO bo = new FraseBO();

        frase = carregaDadosObjeto();

        bo.inserir(frase);
    }

    @Override
    public Frase carregaDadosObjeto() {
        frase.setAutor(this.telaFrase.getTextAutor().getText());
        frase.setFrase(this.telaFrase.getTextFrase().getText());
        return frase;
    }

    @Override
    public void carregaDadosTela(Frase objeto) {
        this.telaFrase.getTextAutor().setText(objeto.getAutor());
        this.telaFrase.getTextFrase().setText(objeto.getFrase());
    }

}
