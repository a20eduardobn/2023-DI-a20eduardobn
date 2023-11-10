/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author a20eduardobn
 */
public class MainFrame_17 extends JFrame {

    private JLabel normasLabel;
    private JCheckBox selection1;
    private JButton continuarButton;
    private Boolean buttonEnabled;

    public MainFrame_17() {
        super("Ola mundo!");
        // Establecer o Layout

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Inicializar os compoñentes
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonEnabled = !buttonEnabled;
                continuarButton.setEnabled(buttonEnabled);
            }
        };

        normasLabel = new JLabel("Estas de acordo coas normas do servicio?");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(normasLabel, gbc);

        selection1 = new JCheckBox("Acepto");
        selection1.addActionListener(al);
        gbc.gridy = 1;
        add(selection1, gbc);

        continuarButton = new JButton("Continuar");
        buttonEnabled = false;
        continuarButton.setEnabled(buttonEnabled);
        gbc.gridy = 2;
        add(continuarButton, gbc);

        setSize(350, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
