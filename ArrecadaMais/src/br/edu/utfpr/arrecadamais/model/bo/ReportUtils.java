package br.edu.utfpr.arrecadamais.model.bo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author torto
 */
public class ReportUtils {

    public static JasperPrint buildReport(String relatorio, List dados) throws JRException {
        InputStream jasper = ReportUtils.class.getClassLoader().getResourceAsStream("br/edu/utfpr/arrecadamais/reports/" + relatorio + ".jasper");
        JRDataSource ds = new JRBeanCollectionDataSource(dados);
        
        JasperPrint print = JasperFillManager.fillReport(jasper, new HashMap(), ds);
        
        return print;
    }

}
