/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame_20 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JButton messageButton;
    private JButton confirmButton;
    private JButton inputDialog;
    private JButton optionDialog;

    public MainFrame_20() throws HeadlessException {
        super("Ola mundo!");
        setLayout(new FlowLayout());
        // Establecer o Layout
        // Inicializar os compoñentes
        messageButton = new JButton("showMessageDialog");
        confirmButton = new JButton("showConfirmDialog");
        inputDialog = new JButton("showInputDialog");
        optionDialog = new JButton("showOptionDialog");

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource()==messageButton){
                    JOptionPane.showMessageDialog(MainFrame_20.this, "Mensaxe de proba", "Titulo de exemplo", JOptionPane.INFORMATION_MESSAGE);
                } else if (actionEvent.getSource()==confirmButton){
                    int output = JOptionPane.showConfirmDialog(MainFrame_20.this, "Mensaxe de proba", "Dialogo de conf", JOptionPane.YES_NO_OPTION);
                    if (output==JOptionPane.OK_OPTION){
                        System.out.println("Aceptado");
                    } else {
                        System.out.println("Cancelado");
                    }
                } else if (actionEvent.getSource()==inputDialog){
                    String s = JOptionPane.showInputDialog(MainFrame_20.this, "Mensaxe de proba");
                    System.out.println(s);
                } else {
                    JOptionPane.showOptionDialog(MainFrame_20.this, "Mensaxe de proba","Titulo de exemplo",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null, new Object[]{"Opcion","Outra", "Terceira opc"},"Outra");
                }
            }
        };

        messageButton.addActionListener(al);
        confirmButton.addActionListener(al);
        inputDialog.addActionListener(al);
        optionDialog.addActionListener(al);

        add(messageButton);
        add(confirmButton);
        add(inputDialog);
        add(optionDialog);


        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
