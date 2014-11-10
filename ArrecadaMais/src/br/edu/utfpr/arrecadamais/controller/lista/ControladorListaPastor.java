package br.edu.utfpr.arrecadamais.controller.lista;

import br.edu.utfpr.arrecadamais.controller.ControladorCadastroPastores;
import br.edu.utfpr.arrecadamais.model.bo.PastorBO;
import br.edu.utfpr.arrecadamais.model.vo.Pastor;
import br.edu.utfpr.arrecadamais.view.views.ViewPastores;
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

public class ControladorListaPastor {

    private ViewPastores telaPastor;
    private PastorBO pastorBO;
    private List<Pastor> listaTotal;
    private DefaultTableModel model;

    public ControladorListaPastor() {
        telaPastor = new ViewPastores();
        telaPastor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pastorBO = new PastorBO();
        model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Sobrenome");
        model.addColumn("Salário");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaPastor.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = pastorBO.buscarComFiltroGeral(telaPastor.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaPastor.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    fecharJanela();
                    ControladorCadastroPastores cadastro = new ControladorCadastroPastores(listaTotal.get(row));
                }
            }
        });

        telaPastor.getBtInserir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaPastor.setVisible(false); //you can't see me!
                telaPastor.dispose();
                ControladorCadastroPastores cadastro = new ControladorCadastroPastores(null);
            }
        });

        telaPastor.getBtExcluir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir esse pastor?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
                    if (pastorBO.excluir(listaTotal.get(telaPastor.getTbTabela().getSelectedRow()))) {
                        listaTotal.remove(telaPastor.getTbTabela().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Pastor excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                        inserirDadosTela();
                    }
                }
            }
        });

        telaPastor.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

    }

    private void fecharJanela() {
        telaPastor.setVisible(false);
        telaPastor.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = pastorBO.buscarTotal();

    }

    private void inserirDadosTela() {

        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Pastor pastor = listaTotal.get(i);
            Vector row = new Vector();
            row.add(pastor.getId());
            row.add(pastor.getNome());
            row.add(pastor.getSobrenome());
            row.add(pastor.getSalario());

            model.addRow(row);
        }

        telaPastor.getTbTabela().setModel(model);
        model.fireTableDataChanged();

    }

    public void abrirTela() {
        this.telaPastor.setVisible(true);
        this.telaPastor.toFront();
    }

}
