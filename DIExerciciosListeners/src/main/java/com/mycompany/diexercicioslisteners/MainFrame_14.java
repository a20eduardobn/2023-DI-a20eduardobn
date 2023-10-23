/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class MainFrame_14 extends JFrame {

    // Declarar os compoñentes como variables privadas de instancia
    private JButton funcionButton1;
    private JButton funcionButton2;
    private JTextField campoName;
    private JTextField campoDni;
    private JLabel labelName;
    private JLabel labelDNI;
    private JLabel labelNac;

    public MainFrame_14() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        JPanel panelBotons = new JPanel();
        panelBotons.setLayout(new FlowLayout());

        JPanel panelNacemento = new JPanel();
        panelNacemento.setLayout(new FlowLayout());

        JLabel nome = new JLabel("Nome:");
        JLabel dni = new JLabel("DNI:");
        JLabel dataNac = new JLabel("Data de nacemento:");

        setSize(600, 500);
        setMinimumSize(new Dimension(300, 150));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
