package br.edu.utfpr.arrecadamais.controller.lista;


import br.edu.utfpr.arrecadamais.controller.transacoes.ControladorCompraTerreno;
import br.edu.utfpr.arrecadamais.model.bo.TerrenoBO;
import br.edu.utfpr.arrecadamais.model.vo.Terreno;
import br.edu.utfpr.arrecadamais.view.views.ViewTerrenos;
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

public class ControladorListaTerrenos {

    private ViewTerrenos telaTerreno;
    private TerrenoBO terrenoBO;
    private List<Terreno> listaTotal;
    private DefaultTableModel model;

    public ControladorListaTerrenos() {
        telaTerreno = new ViewTerrenos();
        telaTerreno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        terrenoBO = new TerrenoBO();
        model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Área Total");
        model.addColumn("Valor Total");
        model.addColumn("Tipo Terreno");
        model.addColumn("Decoração");
        model.setRowCount(0);

        executarBuscaDados();
        inserirDadosTela();

        telaTerreno.getBtBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listaTotal = terrenoBO.buscarComFiltroGeral(telaTerreno.getEdtBuscar().getText());
                inserirDadosTela();
            }
        });

        telaTerreno.getTbTabela().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                if (me.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    ControladorCompraTerreno cadastro = new ControladorCompraTerreno(listaTotal.get(row));
                    cadastro.abrirTela();
                    fecharJanela();
                }
            }
        });

        telaTerreno.getBtInserir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                ControladorCompraTerreno cadastro = new ControladorCompraTerreno(null);
                cadastro.abrirTela();
                fecharJanela();
            }
        });

//        telaTerreno.getBtExcluir().addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir esse Terreo?", "Exclusão", JOptionPane.INFORMATION_MESSAGE) == 0) {
//                    if (terrenoBO.excluir(listaTotal.get(telaTerreno.getTbTabela().getSelectedRow()))) {
//                        listaTotal.remove(telaTerreno.getTbTabela().getSelectedRow());
//                        JOptionPane.showMessageDialog(null, "Terreno excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
//                        inserirDadosTela();
//                    }
//                }
//            }
//        });

        telaTerreno.getBtFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

    }
    
    private void fecharJanela(){
        telaTerreno.setVisible(false);
                telaTerreno.dispose();
    }

    private void executarBuscaDados() {
        listaTotal = terrenoBO.buscarTotal();

    }

    private void inserirDadosTela() {

        model.setRowCount(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            Terreno terreno = listaTotal.get(i);
            
            Vector row = new Vector();
            row.add(terreno.getId());
            row.add(terreno.getMetrosQuadrados());
            row.add(terreno.getTotal());
            row.add(terreno.getTipoTerreno());
            row.add(terreno.getTipoDecoracao());

            model.addRow(row);
        }

        telaTerreno.getTbTabela().setModel(model);
        model.fireTableDataChanged();

    }

    public void abrirTela() {
        this.telaTerreno.setVisible(true);
        this.telaTerreno.toFront();
    }

}
