/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainFrame_6 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JTextArea campoTextArea;
    private JScrollPane campoScroll;

    public MainFrame_6() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());


        campoTextArea = new JTextArea(5, 20);
        campoTextArea.setLineWrap(true);
        campoTextArea.setWrapStyleWord(true);
        campoScroll = new JScrollPane(campoTextArea);
        add(campoScroll);



        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
