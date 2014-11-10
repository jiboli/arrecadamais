package br.edu.utfpr.arrecadamais.controller.lista;

import br.edu.utfpr.arrecadamais.controller.ControladorCadastroTemplos;
import br.edu.utfpr.arrecadamais.model.bo.TemploBO;
import br.edu.utfpr.arrecadamais.model.vo.Templo;
import br.edu.utfpr.arrecadamais.view.views.ViewTemplo;
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

public class ControladorListaTemplo {

    private ViewTemplo telaTemplo;
    private TemploBO temploBO;
    private List<Templo> listaTotal;
    private DefaultTableModel model;

    public ControladorListaTemplo() {
        telaTemplo = new ViewTemplo();
        telaTemplo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        temploBO = new TemploBO();
        model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Capacidade");
        model.addColumn("Cidade");
        model.addColumn("Rua");
        model.addColumn("Número");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaTemplo.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = temploBO.buscarComFiltroGeral(telaTemplo.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaTemplo.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    fecharJanela();
                    ControladorCadastroTemplos cadastro = new ControladorCadastroTemplos(listaTotal.get(row));
                }
            }
        });

        telaTemplo.getBtInserir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaTemplo.setVisible(false); //you can't see me!
                telaTemplo.dispose();
                ControladorCadastroTemplos cadastro = new ControladorCadastroTemplos(null);
            }
        });

        telaTemplo.getBtExcluir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir esse Templo?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
                    if (temploBO.excluir(listaTotal.get(telaTemplo.getTbTabela().getSelectedRow()))) {
                        listaTotal.remove(telaTemplo.getTbTabela().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Templo excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                        inserirDadosTela();
                    }
                }
            }
        });

        telaTemplo.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

    }

    private void fecharJanela() {
        telaTemplo.setVisible(false);
        telaTemplo.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = temploBO.buscarTotal();

    }

    private void inserirDadosTela() {

        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Templo templo = listaTotal.get(i);
            Vector row = new Vector();
            row.add(templo.getId());
            row.add(templo.getNome());
            row.add(templo.getCapacidade());
            row.add(templo.getCidade().getNome());
            row.add(templo.getRua());
            row.add(templo.getNumero());

            model.addRow(row);
        }

        telaTemplo.getTbTabela().setModel(model);
        model.fireTableDataChanged();

    }

    public void abrirTela() {
        this.telaTemplo.setVisible(true);
        this.telaTemplo.toFront();
    }

}
