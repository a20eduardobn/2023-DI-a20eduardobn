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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame_3 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JTextField num1Field;
    private JTextField num2Field;
    private JButton sumarButton;
    private JLabel resultadoLabel;

    public MainFrame_3() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                resultadoLabel.setText("El valor es " + (Integer.parseInt(num1Field.getText()) + Integer.parseInt(num2Field.getText())));
            }
        };

        sumarButton = new JButton("Sumar");
        resultadoLabel = new JLabel();
        num1Field = new JTextField(8);
        num2Field = new JTextField(8);
        sumarButton.addActionListener(al);
        add(num1Field);
        add(num2Field);
        add(sumarButton);
        add(resultadoLabel);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
