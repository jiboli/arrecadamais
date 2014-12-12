package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.model.bo.FieisBO;
import br.edu.utfpr.arrecadamais.model.bo.ReportUtils;
import br.edu.utfpr.arrecadamais.model.vo.Fieis;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;

public class ControladorRelatorioClientes {

    public ControladorRelatorioClientes() {
        try {
            FieisBO bo = new FieisBO();

            List<Fieis> lista = bo.buscarTotal();

            JasperPrint relatorio = ReportUtils.buildReport("Devedores", lista);
            ControladorRelatorios controler = new ControladorRelatorios();
            controler.exibeRelatorio("Relatórios fieis", relatorio);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
