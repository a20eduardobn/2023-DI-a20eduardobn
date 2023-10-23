/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame_12 extends JFrame {

    // Declarar os compoñentes como variables privadas de instancia
    private JButton funcionButton1;
    private JButton funcionButton2;
    private JButton funcionButton3;
    private JButton funcionButton4;
    private JButton funcionButton5;
    private JButton funcionButton6;
    private JButton funcionButton7;
    private JButton funcionButton8;
    private JButton funcionButton9;
    private JButton funcionButton10;
    private JButton funcionButton11;
    private JButton funcionButton12;
    private JButton funcionButton13;
    private JButton funcionButton14;
    private JButton funcionButton15;
    private JButton funcionButton16;
    private JTextField campoCalc;

    public MainFrame_12() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // Inicializar os compoñentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoCalc = new JTextField();
        add(campoCalc, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        funcionButton1 = new JButton("7");
        add(funcionButton1, gbc);

        gbc.gridx = 1;
        funcionButton2 = new JButton("8");
        add(funcionButton2, gbc);

        gbc.gridx = 2;
        funcionButton3 = new JButton("9");
        add(funcionButton3, gbc);

        gbc.gridx = 3;
        funcionButton4 = new JButton("/");
        add(funcionButton4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        funcionButton5 = new JButton("4");
        add(funcionButton5, gbc);

        gbc.gridx = 1;
        funcionButton6 = new JButton("5");
        add(funcionButton6, gbc);

        gbc.gridx = 2;
        funcionButton7 = new JButton("6");
        add(funcionButton7, gbc);

        gbc.gridx = 3;
        funcionButton8 = new JButton("*");
        add(funcionButton8, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        funcionButton9 = new JButton("1");
        add(funcionButton9, gbc);

        gbc.gridx = 1;
        funcionButton10 = new JButton("2");
        add(funcionButton10, gbc);

        gbc.gridx = 2;
        funcionButton11 = new JButton("3");
        add(funcionButton11, gbc);

        gbc.gridx = 3;
        funcionButton12 = new JButton("-");
        add(funcionButton12, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        funcionButton13 = new JButton("0");
        add(funcionButton13, gbc);

        gbc.gridx = 1;
        funcionButton14 = new JButton(".");
        add(funcionButton14, gbc);

        gbc.gridx = 2;
        funcionButton15 = new JButton("=");
        add(funcionButton15, gbc);

        gbc.gridx = 3;
        funcionButton16 = new JButton("+");
        add(funcionButton16, gbc);


        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
