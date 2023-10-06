/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainFrame_10 extends JFrame {

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
    private JLabel etiquetaLabel1;
    private JTextArea campoTextArea;
    private JLabel etiquetaLabel2;

    public MainFrame_10() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        // Inicializar os compoñentes

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        add(myPanel, BorderLayout.LINE_START);


        JPanel myPanel2 = new JPanel();
        myPanel2.setLayout(new BoxLayout(myPanel2, BoxLayout.Y_AXIS));
        add(myPanel2, BorderLayout.LINE_END);

        funcionButton1 = new JButton("Jbutton1");
        myPanel.add(funcionButton1);
        funcionButton1.setSize(new Dimension(40, 40));

        funcionButton2 = new JButton("Jbutton2");
        myPanel.add(funcionButton2);
        funcionButton1.setSize(40, 40);

        funcionButton3 = new JButton("Jbutton3");
        myPanel.add(funcionButton3);
        funcionButton1.setSize(40, 40);

        funcionButton4 = new JButton("Jbutton4");
        myPanel.add(funcionButton4);
        funcionButton1.setSize(40, 40);

        funcionButton5 = new JButton("Jbutton5");
        myPanel.add(funcionButton5);
        funcionButton1.setSize(40, 40);

        funcionButton6 = new JButton("Jbutton6");
        myPanel2.add(funcionButton6);
        funcionButton1.setSize(40, 40);

        funcionButton7 = new JButton("Jbutton7");
        myPanel2.add(funcionButton7);
        funcionButton1.setSize(40, 40);

        funcionButton8 = new JButton("Jbutton8");
        myPanel2.add(funcionButton8);
        funcionButton1.setSize(40, 40);

        funcionButton9 = new JButton("Jbutton9");
        myPanel2.add(funcionButton9);
        funcionButton1.setSize(40, 40);

        funcionButton10 = new JButton("Jbutton10");
        myPanel2.add(funcionButton10);
        funcionButton1.setSize(40, 40);

        etiquetaLabel1 = new JLabel("Titulo de proba");
        add(etiquetaLabel1, BorderLayout.NORTH);
        funcionButton1.setSize(40, 40);

        etiquetaLabel2 = new JLabel("eduardobn");
        add(etiquetaLabel1, BorderLayout.SOUTH);
        funcionButton1.setSize(90, 40);

        campoTextArea = new JTextArea(5, 20);
        add(campoTextArea, BorderLayout.CENTER);
        funcionButton1.setSize(20, 40);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
