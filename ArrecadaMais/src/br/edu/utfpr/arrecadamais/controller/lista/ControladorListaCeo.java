package br.edu.utfpr.arrecadamais.controller.lista;

import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCadastroCeo;
import br.edu.utfpr.arrecadamais.model.bo.CeoBO;
import br.edu.utfpr.arrecadamais.model.vo.Ceo;
import br.edu.utfpr.arrecadamais.view.views.ViewCEO;
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

public class ControladorListaCeo {

    private ViewCEO telaCeo;
    private CeoBO ceoBO;
    private List<Ceo> listaTotal;
    private DefaultTableModel model;

    public ControladorListaCeo() {
        telaCeo = new ViewCEO();
        telaCeo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ceoBO = new CeoBO();
        model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nome Cliente");
        model.addColumn("Valor Pago");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaCeo.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = ceoBO.buscarComFiltroGeral(telaCeo.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaCeo.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    fecharJanela();
                    ControladorCadastroCeo cadastro = new ControladorCadastroCeo(listaTotal.get(row));
                }
            }
        });

        telaCeo.getBtInserir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaCeo.setVisible(false); //you can't see me!
                telaCeo.dispose();
                ControladorCadastroCeo cadastro = new ControladorCadastroCeo(null);
            }
        });

//        telaCeo.getBtExcluir().addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir esse Ceo?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
//                    if (dizimoBO.excluir(listaTotal.get(telaCeo.getTbTabela().getSelectedRow()))) {
//                        listaTotal.remove(telaCeo.getTbTabela().getSelectedRow());
//                        JOptionPane.showMessageDialog(null, "Ceo excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
//                        inserirDadosTela();
//                    }
//                }
//            }
//        });

        telaCeo.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

    }

    private void fecharJanela() {
        telaCeo.setVisible(false);
        telaCeo.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = ceoBO.buscarTotal();

    }

    private void inserirDadosTela() {

        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Ceo dizimo = listaTotal.get(i);
            Vector row = new Vector();
            row.add(dizimo.getId());
            row.add(dizimo.getNomeCliente());
            row.add(dizimo.getValor());
            

            model.addRow(row);
        }

        telaCeo.getTbTabela().setModel(model);
        model.fireTableDataChanged();

    }

    public void abrirTela() {
        this.telaCeo.setVisible(true);
        this.telaCeo.toFront();
    }

}
