/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller.transacoes;

import br.edu.utfpr.arrecadamais.controller.*;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaDizimo;

import br.edu.utfpr.arrecadamais.model.bo.DizimoBO;
import br.edu.utfpr.arrecadamais.model.vo.Dizimo;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
import br.edu.utfpr.arrecadamais.view.transacoes.TDizimo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author JoãoHenrique
 */
public class ControladorCadastroDizimo {

    private TDizimo telaCadastro;
    private Dizimo dizimo;
    private DizimoBO dizimoBO;
    private Fieis fiel;

    public ControladorCadastroDizimo(Dizimo dizimo, Fieis fiel) {
        //tela cadastro fieles
        this.telaCadastro = new TDizimo();
        if (fiel != null) {
            this.fiel = fiel;
        } else {
            this.fiel = dizimo.getFiel();
        }
        this.telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dizimo = dizimo;
        dizimoBO = new DizimoBO();
        
        telaCadastro.getEdNomeCliente().setEnabled(false);

        if (dizimo == null) {
            //cria um novo fiel, pq eh de add um
            dizimo = new Dizimo();
            abrirDizimo();
        } else {
            abrirDizimo();
            //caso fiel venha como parametro insere na tela os dados
            carregaDadosTela(dizimo);
        }

        //evento botao cancelar
//        this.telaCadastro.getBtnCancelar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirTelaGrid();
//
//            }
//        });
        //evento salvar fiel
        this.telaCadastro.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar(); // salva um fiel
                abrirTelaGrid();
            }
        });

    }

    private void abrirTelaGrid() {
        telaCadastro.setVisible(false);
        telaCadastro.dispose();
        ControladorListaDizimo lista = new ControladorListaDizimo();
        lista.abrirTela();
    }

    public void salvar() {
        //instancia um BO
        DizimoBO bo = new DizimoBO();

        //gera um objeto a partir da tela
        carregaDadosObjeto();

        //insere o objeto no banco
        bo.inserir(dizimo);

    }

    public void carregaDadosTela(Dizimo objeto) {

        this.telaCadastro.getEtNomeCartao().setText(objeto.getNomeCartao());
        this.telaCadastro.getEtNumeroCartao().setText(objeto.getNumeroCartao());
        this.telaCadastro.getEdCodigoSeguraca().setText(objeto.getCodSeguranca() + "");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String datestring = dateFormat.format(objeto.getDataValidade());
        this.telaCadastro.getEdDataValidade().setText(datestring);
        this.telaCadastro.getjTextField1().setText(objeto.getValorAdicionar() + "");
        this.telaCadastro.getjTextField2().setText(objeto.getValorMin() + "");
        this.telaCadastro.getEdNomeCliente().setText(objeto.getFiel().getNome());

    }

    public Dizimo carregaDadosObjeto() {
        //pega todos os inputs da tela e insere no objeto fiel
        if (dizimo == null) {
            dizimo = new Dizimo();
        }

        DateFormat formatter = new SimpleDateFormat("MM/YY");
        Date date = null;
        try {
            date = (Date) formatter.parse(this.telaCadastro.getEdDataValidade().getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        dizimo.setDataValidade(date);
        dizimo.setCodSeguranca(Integer.parseInt(this.telaCadastro.getEdCodigoSeguraca().getText()));
        dizimo.setNomeCartao(this.telaCadastro.getEtNomeCartao().getText());
        dizimo.setNumeroCartao(this.telaCadastro.getEtNumeroCartao().getText());
        dizimo.setValorAdicionar(Double.parseDouble(this.telaCadastro.getjTextField1().getText()));
        dizimo.setValorMin(Double.parseDouble(this.telaCadastro.getjTextField2().getText()));
        dizimo.setFiel(fiel);

        return dizimo;
    }

    public void abrirDizimo() {
        this.telaCadastro.setVisible(true);
        this.telaCadastro.toFront();
    }

}
