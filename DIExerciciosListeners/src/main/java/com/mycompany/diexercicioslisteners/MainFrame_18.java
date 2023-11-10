/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 *
 * @author a20eduardobn
 */
public class MainFrame_18 extends JFrame {

    private JRadioButton sumaButton;
    private JRadioButton restaButton;
    private JRadioButton multiButton;
    private JRadioButton divButton;
    private ButtonGroup group;
    private JFormattedTextField campo1;
    private JFormattedTextField campo2;
    private JFormattedTextField resultadoField;

    public MainFrame_18() {
        super("Ola mundo!");
        // Establecer o Layout

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        NumberFormat numf = NumberFormat.getInstance();
        // Inicializar os compoñentes
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Number numero = numf.parse(campo1.getText());
                    double num1 = numero.doubleValue();
                    numero = numf.parse(campo2.getText());
                    double num2 = numero.doubleValue();

                    switch (ae.getActionCommand()) {
                        case "sum" ->
                            resultadoField.setText((num1 + num2) + "");
                        case "res" ->
                            resultadoField.setText((num1 - num2) + "");
                        case "mul" ->
                            resultadoField.setText((num1 * num2) + "");
                        case "div" ->
                            resultadoField.setText(new BigDecimal(num1).divide(new BigDecimal(num2), 4, RoundingMode.HALF_UP) + "");
                    }
                } catch (ParseException ex) {
                }
            }
        };

        ActionListener al2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!campo1.getText().isEmpty() && !campo2.getText().isEmpty()) {
                    sumaButton.setEnabled(true);
                    restaButton.setEnabled(true);
                    multiButton.setEnabled(true);
                    divButton.setEnabled(true);
                }
            }
        };


        campo1 = new JFormattedTextField(numf);
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 5, 10, 0);
        add(campo1, gbc);

        campo2 = new JFormattedTextField(numf);
        gbc.gridx = 1;
        add(campo2, gbc);
        
        resultadoField = new JFormattedTextField(numf);
        gbc.gridx = 2;
        resultadoField.setEditable(false);
        add(resultadoField, gbc);

        sumaButton = new JRadioButton("Suma");
        sumaButton.setActionCommand("sum");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(sumaButton, gbc);

        restaButton = new JRadioButton("Resta");
        restaButton.setActionCommand("res");
        gbc.gridx = 1;
        add(restaButton, gbc);

        multiButton = new JRadioButton("Multiplicación");
        multiButton.setActionCommand("mul");
        gbc.gridx = 2;
        add(multiButton, gbc);

        divButton = new JRadioButton("División");
        divButton.setActionCommand("div");
        gbc.gridx = 3;
        add(divButton, gbc);

        group = new ButtonGroup();
        group.add(sumaButton);
        group.add(restaButton);
        group.add(multiButton);
        group.add(divButton);

        sumaButton.addActionListener(al);
        restaButton.addActionListener(al);
        multiButton.addActionListener(al);
        divButton.addActionListener(al);

        campo1.addActionListener(al2);
        campo2.addActionListener(al2);

        sumaButton.setEnabled(false);
        restaButton.setEnabled(false);
        multiButton.setEnabled(false);
        divButton.setEnabled(false);
        

        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
