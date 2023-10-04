/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame_1 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JButton aceptarButton;
    private JButton aceptarButton2;
    private JButton aceptarButton3;

    public MainFrame_1() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setTitle("Titulo cambiado por " + ae.getActionCommand());
            }
        };
        MouseListener al2 = new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent me) {
                me.getComponent().setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                me.getComponent().setBackground(null);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }
        };
        aceptarButton = new JButton("Cambiador 1");
        aceptarButton2 = new JButton("Cambiador 2");
        aceptarButton3 = new JButton("Cambiador 3");
        aceptarButton.addActionListener(al);
        aceptarButton2.addActionListener(al);
        aceptarButton3.addActionListener(al);
        aceptarButton.addMouseListener(al2);
        aceptarButton2.addMouseListener(al2);
        aceptarButton3.addMouseListener(al2);
        add(aceptarButton);
        add(aceptarButton2);
        add(aceptarButton3);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
