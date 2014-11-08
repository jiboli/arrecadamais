/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

/**
 *
 * @author JoãoHenrique
 */
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaPastor;
import br.edu.utfpr.arrecadamais.controller.lista.ControladorListaTemplo;
import br.edu.utfpr.arrecadamais.model.bo.CidadeBO;
import br.edu.utfpr.arrecadamais.model.bo.EstadoBO;
import br.edu.utfpr.arrecadamais.model.bo.TemploBO;
import br.edu.utfpr.arrecadamais.model.vo.Cidade;
import br.edu.utfpr.arrecadamais.model.vo.Estado;
import br.edu.utfpr.arrecadamais.model.vo.Templo;
import br.edu.utfpr.arrecadamais.view.cadastros.CadastroPastores;
import br.edu.utfpr.arrecadamais.view.cadastros.CadastroTemplos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ControladorCadastroTemplos implements ControleControler<Templo>{
    
    private CadastroTemplos telaTemplo;
    private Templo templo;
    private List<Cidade> cidades;
    private List<Estado> estados;
    private CidadeBO cidadeBo;

    public ControladorCadastroTemplos(Templo templo) {
        this.templo = templo;

        telaTemplo = new CadastroTemplos();
        telaTemplo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        cidadeBo = new CidadeBO();
        EstadoBO estadoBo = new EstadoBO();
        
        cidades = cidadeBo.buscaListaById(1);
        estados = estadoBo.buscarTotal();
        
        //verifica se o templo foi passado como parametro
        //para quando for editar um templo passar ele para essa tela
        // e apartir dela alteramos
        if (templo == null) {
            
            //cria um novo templo, pq eh de add um
            templo = new Templo(); 
        } else {
            abrirTemplo();
            //caso templo venha como parametro insere na tela os dados
            carregaDadosTela(templo);
        }
        
        //evento botao cancelar
        this.telaTemplo.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();//fecha a tela
                abrirTelaGrid();
            }
        });

        //evento salvar templo
        this.telaTemplo.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar(); // salva um templo
                abrirTelaGrid();
            }
        });
        
        //evento que buscas cidades de acordo com o estado selecionado
        this.telaTemplo.getComboEstado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //e.getSource eh o comobobox
                //selectedItem eh o intem selecionado
                //getId - pega o id do estado
               cidades = cidadeBo.buscaListaById(((Estado)((JComboBox) e.getSource()).getSelectedItem()).getId()); 
               telaTemplo.getComboCidade().setModel(new DefaultComboBoxModel(cidades.toArray()));// insere as cidade no combobox
            }
        });

        // inseri na tela padrao as cidades e estados
        this.telaTemplo.getComboEstado().setModel(new DefaultComboBoxModel(estados.toArray()));
        this.telaTemplo.getComboCidade().setModel(new DefaultComboBoxModel(cidades.toArray()));

       abrirTemplo();
    }
    
     public void abrirTelaGrid() {
        telaTemplo.setVisible(false);
        telaTemplo.dispose();
         ControladorListaTemplo lista = new ControladorListaTemplo();
        lista.abrirListaFiel();
    }
     
      void abrirTemplo() {
        //exibe a tela
        this.telaTemplo.setVisible(true);
        this.telaTemplo.toFront();
    }
    
    public void cancelar() {
        this.telaTemplo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.telaTemplo.dispose(); // fecha a janela
    }
    
     public void salvar() {
        //instancia um BO
        TemploBO bo = new TemploBO();
        
        //gera um objeto a partir da tela
        templo = carregaDadosObjeto();

        //insere o objeto no banco
        bo.inserir(templo);
    }
    
    

    @Override
    public Templo carregaDadosObjeto() {
        if(templo == null){
            templo = new Templo();
        }
        templo.setNome(this.telaTemplo.getTextNome().getText());
        templo.setCapacidade(parseInt(this.telaTemplo.getTextCapacidade().getText()));
        templo.setRua(this.telaTemplo.getTextRua().getText());
        templo.setNumero(parseInt(this.telaTemplo.getTextNumero().getText()));   
        templo.setCidade((Cidade) this.telaTemplo.getComboCidade().getModel().getSelectedItem());

        return templo;
    }

    @Override
    public void carregaDadosTela(Templo objeto) {
        this.telaTemplo.getTextNome().setText(objeto.getNome());
        this.telaTemplo.getTextCapacidade().setText(String.valueOf(objeto.getCapacidade()));
        this.telaTemplo.getTextRua().setText(objeto.getRua());
        this.telaTemplo.getTextNumero().setText(String.valueOf(objeto.getNumero()));
        this.telaTemplo.getComboCidade().getModel().setSelectedItem(objeto.getCidade());
    }
    
}