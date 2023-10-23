/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class MainFrame_13 extends JFrame {

    // Declarar os compoñentes como variables privadas de instancia
    private JButton funcionButton1;
    private JTextField campoName;
    private JTextField campoOccup;
    private JLabel labelName;

    public MainFrame_13() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // Inicializar os compoñentes

        JPanel pane = new JPanel();
        JPanel line = new JPanel();

        line.setBorder(BorderFactory.createTitledBorder("title"));
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        line.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        line.setLayout(new GridBagLayout());
        pane.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        line.add(pane, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        add(line, gbc);

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 10);
        labelName = new JLabel("Name:");
        labelName.setAlignmentX(JLabel.RIGHT_ALIGNMENT);

        pane.add(labelName, gbc);

        gbc.gridx = 1;
        campoName = new JTextField(12);
        pane.add(campoName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        labelName = new JLabel("Occupation:");
        pane.add(labelName, gbc);

        gbc.gridx = 1;
        campoOccup = new JTextField(12);
        pane.add(campoOccup, gbc);

        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        funcionButton1 = new JButton("OK");
        pane.add(funcionButton1, gbc);

        setSize(600, 500);
        setMinimumSize(new Dimension(300, 150));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
