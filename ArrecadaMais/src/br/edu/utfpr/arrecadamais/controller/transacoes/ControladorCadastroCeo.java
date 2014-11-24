/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller.transacoes;

import br.edu.utfpr.arrecadamais.controller.*;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaCeo;

import br.edu.utfpr.arrecadamais.model.bo.CeoBO;
import br.edu.utfpr.arrecadamais.model.vo.Ceo;
import br.edu.utfpr.arrecadamais.view.transacoes.TCEO;
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
public class ControladorCadastroCeo {

    private TCEO telaCadastro;
    private Ceo dizimo;
    private CeoBO dizimoBO;

    public ControladorCadastroCeo(Ceo dizimo) {
        //tela cadastro fieles
        this.telaCadastro = new TCEO();
        this.telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dizimo = dizimo;
        dizimoBO = new CeoBO();
    
        if (dizimo == null) {
            //cria um novo fiel, pq eh de add um
            dizimo = new Ceo();
            abrirCeo();
        } else {
            abrirCeo();
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
        ControladorListaCeo lista = new ControladorListaCeo();
        lista.abrirTela();
    }

    public void salvar() {
        //instancia um BO
        CeoBO bo = new CeoBO();

        //gera um objeto a partir da tela
        carregaDadosObjeto();

        //insere o objeto no banco
        bo.inserir(dizimo);
        
    }

    public void carregaDadosTela(Ceo objeto) {
    
        this.telaCadastro.getEtNomeCartao().setText(objeto.getNomeCartao());
        this.telaCadastro.getEtNumeroCartao().setText(objeto.getNumeroCartao());
        this.telaCadastro.getEdCodigoSeguraca().setText(objeto.getCodSeguranca()+"");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String datestring = dateFormat.format(objeto.getDataValidade());
        this.telaCadastro.getEdDataValidade().setText(datestring);
        this.telaCadastro.getjTextField1().setText(objeto.getValor()+"");
//        this.telaCadastro.getEdNomeCliente().setText(objeto.getNomeCliente());


    }

    public Ceo carregaDadosObjeto() {
        //pega todos os inputs da tela e insere no objeto fiel
        if (dizimo == null) {
            dizimo = new Ceo();
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
        dizimo.setValor(Double.parseDouble(this.telaCadastro.getjTextField1().getText()));
//        dizimo.setNomeCliente(this.telaCadastro.getEdNomeCliente().getText());

        return dizimo;
    }

    public void abrirCeo() {
        this.telaCadastro.setVisible(true);
        this.telaCadastro.toFront();
    }

}
