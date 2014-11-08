package br.edu.utfpr.arrecadamais.controller.lista;

import br.edu.utfpr.arrecadamais.controller.ControladorCadastroFrase;
import br.edu.utfpr.arrecadamais.model.bo.FraseBO;
import br.edu.utfpr.arrecadamais.model.vo.Frase;
import br.edu.utfpr.arrecadamais.view.views.ViewFrase;
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

public class ControladorListaFrase {

    private ViewFrase telaFrase;
    private FraseBO fraseBO;
    private List<Frase> listaTotal;
    private DefaultTableModel model;

    public ControladorListaFrase() {
        telaFrase = new ViewFrase();
        telaFrase.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fraseBO = new FraseBO();
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Autor");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaFrase.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = fraseBO.buscarComFiltroGeral(telaFrase.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaFrase.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                int row = table.getSelectedRow();
                if (me.getClickCount() == 1) {
                    telaFrase.getTaFrase().setText(listaTotal.get(row).getFrase());
                } else if (me.getClickCount() == 2) {
                    fecharJanela();
                    ControladorCadastroFrase cadastro = new ControladorCadastroFrase(listaTotal.get(row));
                }
            }
        });

        telaFrase.getBtInserir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaFrase.setVisible(false); //you can't see me!
                telaFrase.dispose();
                ControladorCadastroFrase cadastro = new ControladorCadastroFrase(null);
            }
        });

        telaFrase.getBtExcluir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir essa frase?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
                    if (fraseBO.excluir(listaTotal.get(telaFrase.getTbTabela().getSelectedRow()))) {
                        listaTotal.remove(telaFrase.getTbTabela().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Frase excluida com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                        inserirDadosTela();
                    }
                }
            }
        });

        telaFrase.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

    }

    private void fecharJanela() {
        telaFrase.setVisible(false);
        telaFrase.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = fraseBO.buscarTotal();

    }

    private void inserirDadosTela() {
        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Frase frase = listaTotal.get(i);

            Vector row = new Vector();
            row.add(frase.getId()+"");
            row.add(frase.getAutor());

            model.addRow(row);
        }

        telaFrase.getTbTabela().setModel(model);
//        model.fireTableDataChanged();

    }

    public void abrirListaFiel() {
        this.telaFrase.setVisible(true);
        this.telaFrase.toFront();
    }

}
