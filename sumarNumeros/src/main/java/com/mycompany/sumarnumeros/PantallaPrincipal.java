/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sumarnumeros;

/**
 *
 * @author a20eduardobn
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
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

        number1Label1 = new javax.swing.JLabel();
        pnlSuma = new javax.swing.JPanel();
        lblPrimeiroNumero = new javax.swing.JLabel();
        lblSegundoNumero = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        txtPrimeiroNumero = new javax.swing.JTextField();
        txtSegundoNumero = new javax.swing.JTextField();
        txtResultado = new javax.swing.JTextField();
        btnSumar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        number1Label1.setText("Primeiro número");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSuma.setBorder(javax.swing.BorderFactory.createTitledBorder("Suma"));

        lblPrimeiroNumero.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPrimeiroNumero.setText("Primeiro número:");
        lblPrimeiroNumero.setToolTipText("");

        lblSegundoNumero.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSegundoNumero.setText("Segundo número:");

        lblResultado.setText("Resultado:");

        txtResultado.setEditable(false);

        btnSumar.setText("Sumar");
        btnSumar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSumaLayout = new javax.swing.GroupLayout(pnlSuma);
        pnlSuma.setLayout(pnlSumaLayout);
        pnlSumaLayout.setHorizontalGroup(
            pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSumaLayout.createSequentialGroup()
                        .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblResultado)
                            .addComponent(lblSegundoNumero)
                            .addComponent(lblPrimeiroNumero))
                        .addGap(35, 35, 35)
                        .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrimeiroNumero)
                            .addComponent(txtSegundoNumero)
                            .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSumaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSumar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlSumaLayout.setVerticalGroup(
            pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrimeiroNumero)
                    .addComponent(txtPrimeiroNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundoNumero)
                    .addComponent(txtSegundoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultado)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSumar)
                    .addComponent(btnBorrar))
                .addContainerGap())
        );

        btnSair.setText("Saír");
        btnSair.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSair)
                    .addComponent(pnlSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtPrimeiroNumero.setText("");
        txtSegundoNumero.setText("");
        txtResultado.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed
        float numero1, numero2, resultado;
        numero1 = Float.parseFloat(txtPrimeiroNumero.getText());
        numero2 = Float.parseFloat(txtSegundoNumero.getText());
        resultado = numero1 + numero2;
        txtResultado.setText(String.valueOf(resultado));
    }//GEN-LAST:event_btnSumarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSumar;
    private javax.swing.JLabel lblPrimeiroNumero;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblSegundoNumero;
    private javax.swing.JLabel number1Label1;
    private javax.swing.JPanel pnlSuma;
    private javax.swing.JTextField txtPrimeiroNumero;
    private javax.swing.JTextField txtResultado;
    private javax.swing.JTextField txtSegundoNumero;
    // End of variables declaration//GEN-END:variables
}
