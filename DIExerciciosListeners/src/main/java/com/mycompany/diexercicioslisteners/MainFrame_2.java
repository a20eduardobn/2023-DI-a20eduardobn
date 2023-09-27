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
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MainFrame_2 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private final JButton aceptarButton;
    private final JButton aceptarButton2;
    private final JLabel etiqueta;

    public MainFrame_2() throws HeadlessException {
        super("Ola mundo!");
        setLayout(new FlowLayout());
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                etiqueta.setText("Boton pulsado: " + ae.getActionCommand());
            }
        };

        MouseListener al2 = new MouseListener() {
            boolean count;

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                count = !count;
                if (count == true) {
                    me.getComponent().setBackground(Color.LIGHT_GRAY);
                } else {
                    me.getComponent().setBackground(null);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }
        };

        getContentPane().addMouseListener(al2);
        aceptarButton = new JButton("Cambiador 1");
        aceptarButton2 = new JButton("Cambiador 2");
        etiqueta = new JLabel("Etiqueta");
        aceptarButton.addActionListener(al);
        aceptarButton2.addActionListener(al);
        add(aceptarButton);
        add(aceptarButton2);
        add(etiqueta);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
