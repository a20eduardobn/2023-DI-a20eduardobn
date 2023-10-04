/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

public class MainFrame_9 extends JFrame {

    // Declarar os compoñentes como variables privadas de instancia
    private JFormattedTextField txtFieldNums;
    private JLabel labelDates;

    public MainFrame_9() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                labelDates.setText(txtFieldNums.getText());
            }
        };

        MaskFormatter mkf = new MaskFormatter("#####");

        txtFieldNums = new JFormattedTextField(mkf);
        txtFieldNums.setColumns(10);
        txtFieldNums.setText("54005");
        txtFieldNums.addActionListener(al);
        labelDates = new JLabel("Codigo Postal");

        add(labelDates);
        add(txtFieldNums);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
