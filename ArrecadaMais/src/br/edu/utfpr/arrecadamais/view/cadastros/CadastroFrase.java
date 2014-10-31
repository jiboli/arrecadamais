/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.view.cadastros;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author JoãoHenrique
 */
public class CadastroFrase extends javax.swing.JFrame {

    /**
     * Creates new form ViewCadastroFrase
     */
    public CadastroFrase() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textFrase = new javax.swing.JTextPane();
        textAutor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/arrecadamais/view/MEDIA/ViewFrase.png"))); // NOI18N
        jLabel1.setText("Cadastrar");
        jPanel4.add(jLabel1);

        jPanel1.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 25));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        btnCadastrar.setText("Cadastrar");
        jPanel8.add(btnCadastrar);

        btnCancelar.setText("Cancelar");
        jPanel8.add(btnCancelar);

        jPanel1.add(jPanel8, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setText("Insira a Frase bíblica: ");
        jPanel2.add(jLabel2);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(380, 180));
        jScrollPane1.setViewportView(textFrase);

        jPanel2.add(jScrollPane1);

        textAutor.setText("Autor:");
        jPanel2.add(textAutor);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textAutor;
    private javax.swing.JTextPane textFrase;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCadastrar() {
        return this.btnCadastrar;
    }

    public void setBtnCadastrar(JButton btnCadastrar) {
        this.btnCadastrar = btnCadastrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getTextAutor() {
        return textAutor;
    }

    public void setTextAutor(JTextField textAutor) {
        this.textAutor = textAutor;
    }

    public JTextPane getTextFrase() {
        return textFrase;
    }

    public void setTextFrase(JTextPane textFrase) {
        this.textFrase = textFrase;
    }

}