/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author a20eduardobn
 */
public class MainFrame_16 extends JFrame {

    private JLabel selectedLabel;
    private JCheckBox selection1;
    private JCheckBox selection2;
    private JCheckBox selection3;
    private JPanel pane;
    private JPanel internalpane;

    public MainFrame_16() {
        super("Ola mundo!");
        // Establecer o Layout

        setLayout(new FlowLayout());
        pane = new JPanel();
        internalpane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

        // Inicializar os compoñentes
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = "Estos son los checkbox seleccionados: ";

                if (selection1.isSelected()) {
                    s = s + selection1.getText() + " ";
                }

                if (selection2.isSelected()) {
                    s = s + selection2.getText() + " ";
                }

                if (selection3.isSelected()) {
                    s = s + selection3.getText() + " ";
                }
                
                selectedLabel.setText(s);
            }
        };

        selectedLabel = new JLabel("Selecciona un checkbox");
        selectedLabel.setAlignmentX(CENTER_ALIGNMENT);

        selection1 = new JCheckBox("Checkbox 1");
        selection2 = new JCheckBox("Checkbox 2");
        selection3 = new JCheckBox("Checkbox 3");
        selection1.addActionListener(al);
        selection2.addActionListener(al);
        selection3.addActionListener(al);

        add(pane, BorderLayout.CENTER);
        pane.add(selectedLabel);
        internalpane.add(selection1);
        internalpane.add(selection2);
        internalpane.add(selection3);
        pane.add(internalpane);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
