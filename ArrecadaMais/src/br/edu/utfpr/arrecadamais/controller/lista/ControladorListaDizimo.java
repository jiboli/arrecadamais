package br.edu.utfpr.arrecadamais.controller.lista;

import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCadastroDizimo;
import br.edu.utfpr.arrecadamais.model.bo.DizimoBO;
import br.edu.utfpr.arrecadamais.model.vo.Dizimo;
import br.edu.utfpr.arrecadamais.view.views.ViewDizimo;
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

public class ControladorListaDizimo {

    private ViewDizimo telaDizimo;
    private DizimoBO dizimoBO;
    private List<Dizimo> listaTotal;
    private DefaultTableModel model;

    public ControladorListaDizimo() {
        telaDizimo = new ViewDizimo();
        telaDizimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dizimoBO = new DizimoBO();
        model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nome Cliente");
        model.addColumn("Valor Pago");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaDizimo.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = dizimoBO.buscarComFiltroGeral(telaDizimo.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaDizimo.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    fecharJanela();
                    ControladorCadastroDizimo cadastro = new ControladorCadastroDizimo(listaTotal.get(row), null);
                }
            }
        });


//        telaDizimo.getBtExcluir().addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir esse Dizimo?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
//                    if (dizimoBO.excluir(listaTotal.get(telaDizimo.getTbTabela().getSelectedRow()))) {
//                        listaTotal.remove(telaDizimo.getTbTabela().getSelectedRow());
//                        JOptionPane.showMessageDialog(null, "Dizimo excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
//                        inserirDadosTela();
//                    }
//                }
//            }
//        });

        telaDizimo.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

    }

    private void fecharJanela() {
        telaDizimo.setVisible(false);
        telaDizimo.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = dizimoBO.buscarTotal();

    }

    private void inserirDadosTela() {

        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Dizimo dizimo = listaTotal.get(i);
            Vector row = new Vector();
            row.add(dizimo.getId());
            row.add(dizimo.getNomeCliente());
            row.add(dizimo.getValorMin()+dizimo.getValorAdicionar());
            

            model.addRow(row);
        }

        telaDizimo.getTbTabela().setModel(model);
        model.fireTableDataChanged();

    }

    public void abrirTela() {
        this.telaDizimo.setVisible(true);
        this.telaDizimo.toFront();
    }

}
