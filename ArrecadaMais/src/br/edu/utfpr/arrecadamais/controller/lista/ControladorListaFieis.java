package br.edu.utfpr.arrecadamais.controller.lista;

import br.edu.utfpr.arrecadamais.controller.ControladorCadastroFieis;
import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCadastroCeo;
import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCadastroDizimo;
import br.edu.utfpr.arrecadamais.model.bo.FieisBO;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
import br.edu.utfpr.arrecadamais.view.views.ViewFiel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorListaFieis {

    private ViewFiel telaFiel;
    private FieisBO fielBO;
    private List<Fieis> listaTotal;
    private DefaultTableModel model;

    public ControladorListaFieis() {
        telaFiel = new ViewFiel();
        telaFiel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fielBO = new FieisBO();
        model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Sobrenome");
        model.addColumn("Telefone");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaFiel.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = fielBO.buscarComFiltroGeral(telaFiel.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaFiel.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    ControladorCadastroFieis cadastro = new ControladorCadastroFieis(listaTotal.get(row));
                    fecharJanela();
                }
            }
        });

        telaFiel.getBtInserir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                ControladorCadastroFieis cadastro = new ControladorCadastroFieis(null);
                fecharJanela();
            }
        });

        telaFiel.getBtExcluir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir esse fiel?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
                    if (fielBO.excluir(listaTotal.get(telaFiel.getTbTabela().getSelectedRow()))) {
                        listaTotal.remove(telaFiel.getTbTabela().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Fiel excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                        inserirDadosTela();
                    }
                }
            }
        });

        telaFiel.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });
        
        telaFiel.getBtnCEO().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroCeo cad_ceo = new ControladorCadastroCeo(null, listaTotal.get(telaFiel.getTbTabela().getSelectedRow()));
            }
        });
        
        telaFiel.getBtnDizimo().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroDizimo cad_diz = new ControladorCadastroDizimo(null, listaTotal.get(telaFiel.getTbTabela().getSelectedRow()));
            }
        });

        
        
    }
    
    private void fecharJanela(){
        telaFiel.setVisible(false);
                telaFiel.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = fielBO.buscarTotal();

    }

    private void inserirDadosTela() {

        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Fieis fieis = listaTotal.get(i);
            
            Vector row = new Vector();
            row.add(fieis.getId());
            row.add(fieis.getNome());
            row.add(fieis.getSobrenome());
            row.add(fieis.getTelefone());

            model.addRow(row);
        }

        telaFiel.getTbTabela().setModel(model);
        model.fireTableDataChanged();

    }

    public void abrirTela() {
        this.telaFiel.setVisible(true);
        this.telaFiel.toFront();
    }

}
