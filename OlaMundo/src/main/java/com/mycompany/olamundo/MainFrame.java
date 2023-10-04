/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olamundo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author a20eduardobn
 */
public class MainFrame extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private final JTextArea textArea;
    private final JButton aceptarButton;
    private final JLabel etiquetaLabel;

    public MainFrame() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        // Inicializar os compoñentes
        textArea = new JTextArea();
        aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Boton pulsado");
            }
        });
        etiquetaLabel = new JLabel("EduardoBN");
        etiquetaLabel.setFont(new Font("Arial", Font.ITALIC, 24));
        etiquetaLabel.setHorizontalAlignment(JLabel.CENTER);
        // engadir os compoñentes
        add(textArea, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        add(etiquetaLabel, BorderLayout.PAGE_START);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
