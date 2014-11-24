/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller.transacoes;

import br.edu.utfpr.arrecadamais.controller.CControleGeral;
import br.edu.utfpr.arrecadamais.model.bo.TerrenoBO;
import br.edu.utfpr.arrecadamais.model.vo.Terreno;
import br.edu.utfpr.arrecadamais.view.transacoes.CompraTerrenos;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author torto
 */
public class ControladorCompraTerreno {

    private CompraTerrenos telaTerreno;
    private TerrenoBO terrenoBO;
    private Terreno terreno;
    private double juros = 0.0;
    private List<String> listTipoTerreno = ECompraTerreno.TIPOTERRENO.getListaTipoDescricao();
    private List<String> listTipoDecoracao = ECompraTerreno.TIPODECORACAO.getListaTipoDescricao();
    private List<String> listNumeroParcela = ECompraTerreno.PARCELAS.getListaTipoDescricao();

    public ControladorCompraTerreno(Terreno terreno) {
        telaTerreno = new CompraTerrenos();
        telaTerreno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        terrenoBO = new TerrenoBO();

        if (terreno != null) {
            this.terreno = terreno;
            carregarDadosTela(terreno);
        } else {
            this.terreno = new Terreno();
            
        }

        addComboBoxValues();

        telaTerreno.getSlComprimento().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (telaTerreno.getSlComprimento().getValue() < 58) {
                    telaTerreno.getSlComprimento().setValue(58);
                }
                telaTerreno.getEdComprimento().setText(telaTerreno.getSlComprimento().getValue() + "");
                mudarTamanhoPanel();

            }
        });

        telaTerreno.getSlLargura().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (telaTerreno.getSlLargura().getValue() < 46) {
                    telaTerreno.getSlLargura().setValue(46);
                }
                telaTerreno.getEdLargura().setText(telaTerreno.getSlLargura().getValue() + "");
                mudarTamanhoPanel();
            }
        });

        telaTerreno.getjButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               inserirTerrenoParaMim();
            }
        });
        
        telaTerreno.getjButton2().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                inserirTerrenoParaPresente();
                telaTerreno.dispose();
            }
        });
        
    }

    public void addComboBoxValues() {

        for (int i = 0; i < listTipoTerreno.size(); i++) {
            telaTerreno.getCbTipoTerreno().addItem(listTipoTerreno.get(i));

        }

        for (int i = 0; i < listTipoDecoracao.size(); i++) {
            telaTerreno.getCbTipoDecoracao().addItem(listTipoDecoracao.get(i));
        }

        for (int i = 0; i < listNumeroParcela.size(); i++) {
            telaTerreno.getCbNumeroParcela().addItem(listNumeroParcela.get(i));
        }

    }
    
    public void mudarTamanhoPanel() {
        telaTerreno.remove(telaTerreno.getjPanel9());
        telaTerreno.getjPanel9().getPreferredSize().setSize((171 * telaTerreno.getSlLargura().getValue()) / 1000, (216 * telaTerreno.getSlComprimento().getValue()) / 1000);
        telaTerreno.getjPanel9().setSize((216 * telaTerreno.getSlLargura().getValue()) / 1000, (171 * telaTerreno.getSlComprimento().getValue()) / 1000);
        telaTerreno.getjPanel7().add(telaTerreno.getjPanel9());
        telaTerreno.pack();
        calcularTotal();
    }

    public void carregarDadosObjeto(Terreno objeto) {

        terreno.setComprimento(telaTerreno.getSlComprimento().getValue());
        terreno.setLargura(telaTerreno.getSlLargura().getValue());
        terreno.setDataValidade(telaTerreno.getEdDataValidade().getText());
        terreno.setNomeCartao(telaTerreno.getEtNomeCartao().getText());
        terreno.setNumeroCartao(telaTerreno.getEtNumeroCartao().getText());
        terreno.setNumeroSegurancaCartao(Integer.parseInt(telaTerreno.getEdCodigoSeguraca().getText()));
        terreno.setParcelas(Integer.parseInt((String)telaTerreno.getCbNumeroParcela().getModel().getSelectedItem()));
        terreno.setTipoDecoracao("" + telaTerreno.getCbTipoDecoracao().getModel().getSelectedItem());
        terreno.setTipoTerreno("" + telaTerreno.getCbTipoTerreno().getModel().getSelectedItem());
        terreno.setTotal(calcularTotal());
//        terreno.setJuros(juros);

    }

    private double calcularTotal() {
        double retorno = 0.0;

        retorno = (telaTerreno.getSlComprimento().getValue() * telaTerreno.getSlLargura().getValue()) * 2000;
        telaTerreno.getjLabel11().setText("R$ " + CControleGeral.formatarNumeroDouble(retorno));
        

        calcularJuros(retorno);
        return retorno;
    }

    private void calcularJuros(double valorTotal) {
        double retorno = 0.0;

//        BigDecimal aa = new BigDecimal(valorTotal);
//        aa.compareTo(aa)
        if (valorTotal > new BigDecimal(10000000.0).doubleValue()) {
            retorno = 20.0;
        } else if (valorTotal < new BigDecimal(10000000.0).doubleValue() && valorTotal > new BigDecimal(5000000.0).doubleValue()) {
            retorno = 10.0;
        } else if (valorTotal <= new BigDecimal(1999999999.0).doubleValue()) {
            retorno = 200.0;
        }

        telaTerreno.getLbJuros().setText(retorno + "% mês.");

        terreno.setJuros(retorno);

    }

    public void carregarDadosTela(Terreno objeto) {

        telaTerreno.getEdCodigoSeguraca().setText(objeto.getNumeroSegurancaCartao() + "");
        telaTerreno.getEdComprimento().setText(objeto.getComprimento() + "");
        telaTerreno.getEdLargura().setText(objeto.getLargura() + "");
        telaTerreno.getEdDataValidade().setText(objeto.getDataValidade());
        telaTerreno.getCbNumeroParcela().getModel().setSelectedItem(objeto.getParcelas());
        telaTerreno.getCbTipoDecoracao().getModel().setSelectedItem(objeto.getTipoDecoracao());
        telaTerreno.getCbTipoTerreno().getModel().setSelectedItem(objeto.getTipoTerreno());
        telaTerreno.getEtNomeCartao().setText(objeto.getNomeCartao());
        telaTerreno.getEtNumeroCartao().setText(objeto.getNomeCartao());
        telaTerreno.getSlComprimento().setValue((int) objeto.getComprimento());
        telaTerreno.getSlLargura().setValue((int) objeto.getLargura());

    }

    public Terreno inserirTerrenoParaMim() {
        carregarDadosObjeto(terreno);
        terreno.setPresente(false);

        return terrenoBO.inserir(terreno);
    }
    public Terreno inserirTerrenoParaPresente() {
        carregarDadosObjeto(terreno);
        terreno.setPresente(true);

        return terrenoBO.inserir(terreno);
    }

    public void abrirTela() {
        this.telaTerreno.setVisible(true);
        this.telaTerreno.toFront();
    }
}
