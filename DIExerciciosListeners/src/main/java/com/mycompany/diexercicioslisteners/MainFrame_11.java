/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainFrame_11 extends JFrame {

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
    private JLabel etiquetaLabel2;

    public MainFrame_11() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        // Inicializar os compoñentes

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(5, 1));
        add(myPanel, BorderLayout.LINE_START);

        JPanel myPanel2 = new JPanel();
        myPanel2.setLayout(new GridLayout(5, 1));
        add(myPanel2, BorderLayout.LINE_END);

        funcionButton1 = new JButton("Siguiente");
        myPanel.add(funcionButton1);

        funcionButton2 = new JButton("Primera");
        myPanel.add(funcionButton2);

        funcionButton3 = new JButton("Segunda");
        myPanel.add(funcionButton3);

        funcionButton4 = new JButton("Tercera");
        myPanel.add(funcionButton4);

        funcionButton5 = new JButton("Anterior");
        myPanel.add(funcionButton5);

        funcionButton6 = new JButton("Jbutton6");
        myPanel2.add(funcionButton6);

        funcionButton7 = new JButton("Jbutton7");
        myPanel2.add(funcionButton7);

        funcionButton8 = new JButton("Jbutton8");
        myPanel2.add(funcionButton8);

        funcionButton9 = new JButton("Jbutton9");
        myPanel2.add(funcionButton9);

        funcionButton10 = new JButton("Jbutton10");
        myPanel2.add(funcionButton10);

        etiquetaLabel1 = new JLabel("Titulo de proba");
        add(etiquetaLabel1, BorderLayout.NORTH);

        etiquetaLabel2 = new JLabel("eduardobn");
        add(etiquetaLabel2, BorderLayout.SOUTH);

        JPanel cards = new JPanel();
        CardLayout cl = new CardLayout();
        cards.setLayout(cl);
        add(cards, BorderLayout.CENTER);

        JPanel card1 = new JPanel();
        card1.setBackground(Color.red);
        JPanel card2 = new JPanel();
        card2.setBackground(Color.green);
        JPanel card3 = new JPanel();
        card3.setBackground(Color.cyan);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource().equals(funcionButton1)) {
                    cl.next(cards);
                }
                if (ae.getSource().equals(funcionButton2)) {
                    cl.first(cards);
                }
                if (ae.getSource().equals(funcionButton3)) {
                    cl.first(cards);
                    cl.next(cards);
                }
                if (ae.getSource().equals(funcionButton4)) {
                    cl.last(cards);
                }
                if (ae.getSource().equals(funcionButton5)) {
                    cl.previous(cards);
                }
            }
        };

        funcionButton1.addActionListener(al);
        funcionButton2.addActionListener(al);
        funcionButton3.addActionListener(al);
        funcionButton4.addActionListener(al);
        funcionButton5.addActionListener(al);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
