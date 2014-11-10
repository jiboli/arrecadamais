/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaFieis;
import br.edu.utfpr.arrecadamais.model.bo.CidadeBO;
import br.edu.utfpr.arrecadamais.model.bo.EstadoBO;
import br.edu.utfpr.arrecadamais.model.bo.FieisBO;
import br.edu.utfpr.arrecadamais.model.vo.Cidade;
import br.edu.utfpr.arrecadamais.model.vo.Estado;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
import br.edu.utfpr.arrecadamais.model.vo.Pastor;
import br.edu.utfpr.arrecadamais.view.cadastros.CadastroFieis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JoãoHenrique
 */
public class ControladorCadastroFieis implements ControleControler<Fieis> {

    private CadastroFieis telaCadastro;
    private Fieis fiel;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private List itemsEscolaridade;
    private CidadeBO cidadeBo;
    private FieisBO fieisBo;

    public ControladorCadastroFieis(Fieis fiel) {
        //tela cadastro fieles
        this.telaCadastro = new CadastroFieis();
        this.telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.fiel = fiel;
        fieisBo = new FieisBO();
        EstadoBO estadoBo = new EstadoBO();
        cidadeBo = new CidadeBO();
        cidades = cidadeBo.buscaListaById(1);
        estados = estadoBo.buscarTotal();//busca todos os estados

        //verifica se o fiel foi passado como parametro
        //para quando for editar um fiel passar ele para essa tela
        // e apartir dela alteramos
        if (fiel == null) {
            //cria um novo fiel, pq eh de add um
            fiel = new Fieis();
            abrirFiel();
        } else {
            abrirFiel();
            //caso fiel venha como parametro insere na tela os dados
            carregaDadosTela(fiel);
        }

        //evento botao cancelar
        this.telaCadastro.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaGrid();

            }
        });

        //evento salvar fiel
        this.telaCadastro.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar(); // salva um fiel
               abrirTelaGrid();
            }
        });

        //evento que buscas cidades de acordo com o estado selecionado
        this.telaCadastro.getComboEstado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //e.getSource eh o comobobox
                //selectedItem eh o intem selecionado
                //getId - pega o id do estado
                cidades = cidadeBo.buscaListaById(((Estado) ((JComboBox) e.getSource()).getSelectedItem()).getId());
                telaCadastro.getComboCidade().setModel(new DefaultComboBoxModel(cidades.toArray()));// insere as cidade no combobox
            }
        });
        // inseri na tela padrao as cidades e estados
        this.telaCadastro.getComboEstado().setModel(new DefaultComboBoxModel(estados.toArray()));
        this.telaCadastro.getComboCidade().setModel(new DefaultComboBoxModel(cidades.toArray()));

        //exibe a tela
        //this.telaCadastro.setVisible(true);
        //this.telaCadastro.toFront();
        //Criado metodo proprio para tal
        //fim do construtor
    }

    private void abrirTelaGrid() {
        telaCadastro.setVisible(false);
        telaCadastro.dispose();
        ControladorListaFieis lista = new ControladorListaFieis();
        lista.abrirTela();
    }

    public void salvar() {
        //instancia um BO
        FieisBO bo = new FieisBO();

        //gera um objeto a partir da tela
        carregaDadosObjeto();

        //insere o objeto no banco
        bo.inserir(fiel);
        
    }

    public void carregaDadosTela(Fieis objeto) {
        /* this.telaCadastro.getCmbEstado().setModel(new DefaultComboBoxModel(itemsEstado));
         this.telaCadastro.getCmbEstado().getModel().setSelectedItem(this);
         this.telaCadastro.getCmbEscolaridade().setModel(new DefaultComboBoxModel(itemsEscolaridade));
         this.telaCadastro.getCmbEscolaridade().getModel().setSelectedItem(this);*/
        //pega todos os valores do fiel e insere na tela
        this.telaCadastro.getTextNome().setText(objeto.getNome());
        this.telaCadastro.getTextSobrenome().setText(objeto.getSobrenome());
        this.telaCadastro.getTextCpf().setText(objeto.getCpf());
        this.telaCadastro.getTextRenda().setText(objeto.getRenda() + "");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String datestring = dateFormat.format(objeto.getDataNascimento());
        this.telaCadastro.getTextDataNascimento().setText(datestring);
        this.telaCadastro.getComboCidade().getModel().setSelectedItem(objeto.getCidade());
        this.telaCadastro.getTextTelefone().setText(objeto.getTelefone());
        this.telaCadastro.getTextCelular().setText(objeto.getCelular());
        this.telaCadastro.getTextProfissao().setText(objeto.getProfissao());
        this.telaCadastro.getTextCargo().setText(objeto.getCargo());
        this.telaCadastro.getTextEscolaridade().setText(objeto.getEscolaridade());
        this.telaCadastro.getTextEdereco().setText(objeto.getEndereco());

    }

    public Fieis carregaDadosObjeto() {
        //pega todos os inputs da tela e insere no objeto fiel
        if (fiel == null) {
            fiel = new Fieis();
        }
        fiel.setNome(this.telaCadastro.getTextNome().getText());
        fiel.setSobrenome(this.telaCadastro.getTextSobrenome().getText());
        fiel.setCpf(this.telaCadastro.getTextCpf().getText());
        fiel.setRenda(Double.parseDouble(this.telaCadastro.getTextRenda().getText()));
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = null;
        try {
            date = (Date) formatter.parse(this.telaCadastro.getTextDataNascimento().getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        fiel.setDataNascimento(date);
        fiel.setCidade((Cidade) this.telaCadastro.getComboCidade().getModel().getSelectedItem());
        fiel.setTelefone(this.telaCadastro.getTextTelefone().getText());
        fiel.setCelular(this.telaCadastro.getTextCelular().getText());
        fiel.setProfissao(this.telaCadastro.getTextProfissao().getText());
        fiel.setCargo(this.telaCadastro.getTextCargo().getText());
        fiel.setEscolaridade(this.telaCadastro.getTextEscolaridade().getText());
        fiel.setEndereco(this.telaCadastro.getTextEdereco().getText());

        return fiel;
    }

    public void abrirFiel() {
        this.telaCadastro.setVisible(true);
        this.telaCadastro.toFront();
    }

}
