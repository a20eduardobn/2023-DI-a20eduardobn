/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame_4 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JTextField num1Field;
    private JButton sumarButton;
    private JButton reiniciarButton;
    private int contador = 0;

    public MainFrame_4() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contador = ae.getSource().equals(reiniciarButton) ? 0 : contador + 1;
                num1Field.setText(contador + "");
            }
        };

        sumarButton = new JButton("Presioname");
        reiniciarButton = new JButton("Reiniciar");
        num1Field = new JTextField(8);
        num1Field.setText(contador + "");
        sumarButton.addActionListener(al);
        reiniciarButton.addActionListener(al);
        add(num1Field);
        add(sumarButton);
        add(reiniciarButton);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
