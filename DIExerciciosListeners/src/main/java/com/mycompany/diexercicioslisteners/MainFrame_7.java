/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame_7 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia
    private JTextField txtField;
    private JTextArea txtArea;

    public MainFrame_7() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtArea.setText(txtArea.getText() + txtField.getText() + "\n");
                txtField.selectAll();
            }
        };

        txtField = new JTextField(10);
        txtArea = new JTextArea(5, 20);
        txtArea.setEditable(false);
        txtField.addActionListener(al);

        add(txtField);
        add(txtArea);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
