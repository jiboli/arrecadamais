/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaPastor;
import br.edu.utfpr.arrecadamais.model.bo.CidadeBO;
import br.edu.utfpr.arrecadamais.model.bo.EstadoBO;
import br.edu.utfpr.arrecadamais.model.bo.PastorBO;
import br.edu.utfpr.arrecadamais.model.vo.Cidade;
import br.edu.utfpr.arrecadamais.model.vo.Estado;
import br.edu.utfpr.arrecadamais.model.vo.Pastor;
import br.edu.utfpr.arrecadamais.view.cadastros.CadastroPastores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ControladorCadastroPastores implements ControleControler<Pastor> {

    private CadastroPastores telaPastor;
    private Pastor pastor;
    private List<Cidade> cidades;
    private List<Estado> estados;
    private CidadeBO cidadeBo;

    public ControladorCadastroPastores(Pastor pastor) {
        this.pastor = pastor;
        //tela cadastro pastores
        this.telaPastor = new CadastroPastores();
        this.telaPastor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cidadeBo = new CidadeBO();//dentro do actionliestener só funciona se tiver private la em cima
        EstadoBO estadoBo = new EstadoBO();

        //cidades vao aparecer de acordo com o estado selecionado
        //como fica o esta 1 como padrao no comobox
        //faco uma busca por cidades com estado_id = 1
        cidades = cidadeBo.buscaListaById(1);
        estados = estadoBo.buscarTotal();//busca todos os estados

        // inseri na tela padrao as cidades e estados
        this.telaPastor.getComboEstado().setModel(new DefaultComboBoxModel(estados.toArray()));
        this.telaPastor.getComboCidade().setModel(new DefaultComboBoxModel(cidades.toArray()));

        //verifica se o pastor foi passado como parametro
        //para quando for editar um pastor passar ele para essa tela
        // e apartir dela alteramos
        if (pastor == null) {
            //cria um novo pastor, pq eh de add um
            pastor = new Pastor();
        } else {
            abrirPastor();
            //caso pastor venha como parametro insere na tela os dados
            carregaDadosTela(pastor);;
        }

        //evento botao cancelar
        this.telaPastor.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaGrid();
            }
        });

        //evento salvar pastor
        this.telaPastor.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar(); // salva um pastor
                abrirTelaGrid();
            }
        });

        //evento que buscas cidades de acordo com o estado selecionado
        this.telaPastor.getComboEstado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //e.getSource eh o comobobox
                //selectedItem eh o intem selecionado
                //getId - pega o id do estado
                cidades = cidadeBo.buscaListaById(((Estado) ((JComboBox) e.getSource()).getSelectedItem()).getId());
                telaPastor.getComboCidade().setModel(new DefaultComboBoxModel(cidades.toArray()));// insere as cidade no combobox
            }
        });

        //exibe a tela
        this.telaPastor.setVisible(true);
        this.telaPastor.toFront();
    }

    public void abrirTelaGrid() {
        telaPastor.setVisible(false);
        telaPastor.dispose();
        ControladorListaPastor lista = new ControladorListaPastor();
        lista.abrirTela();
    }

    public void salvar() {
        //instancia um BO
        PastorBO bo = new PastorBO();
        //gera um objeto a partir da tela
        carregaDadosObjeto();

        //insere o objeto no banco
        bo.inserir(pastor);
    }

    @Override
    public Pastor carregaDadosObjeto() {
        //pega todos os inputs da tela e insere no objeto pastor
        if (pastor == null) {
            pastor = new Pastor();
        }
        pastor.setNome(this.telaPastor.getTextNome().getText());
        pastor.setSobrenome(this.telaPastor.getTextSobrenome().getText());
        pastor.setCpf(this.telaPastor.getTextCpf().getText());
        pastor.setSalario(Double.parseDouble(this.telaPastor.getTextSalario().getText()));
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(this.telaPastor.getTextDataNascimento().getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        pastor.setDataNascimento(date);
        pastor.setCidade((Cidade) this.telaPastor.getComboCidade().getModel().getSelectedItem());

        return pastor;
    }

    @Override
    public void carregaDadosTela(Pastor objeto) {
        //pega todos os valores do Pastor e insere na tela
        this.telaPastor.getTextNome().setText(objeto.getNome());
        this.telaPastor.getTextSobrenome().setText(objeto.getSobrenome());
        this.telaPastor.getTextCpf().setText(objeto.getCpf());
        this.telaPastor.getTextSalario().setText(objeto.getSalario() + "");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String datestring = dateFormat.format(objeto.getDataNascimento());
        this.telaPastor.getTextDataNascimento().setText(datestring);
        this.telaPastor.getComboCidade().getModel().setSelectedItem(objeto.getCidade());
    }

    void abrirPastor() {
        //exibe a tela
        this.telaPastor.setVisible(true);
        this.telaPastor.toFront();
    }

}
