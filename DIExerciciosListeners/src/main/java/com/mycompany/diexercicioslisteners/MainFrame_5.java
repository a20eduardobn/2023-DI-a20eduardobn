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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame_5 extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JPasswordField pwdField;
    private JButton sumarButton;
    private int contador = 0;

    public MainFrame_5() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                char[] pwd = pwdField.getPassword();
                String pwdS = "";

                for (int i = 0; i < pwd.length; i++) {
                    pwdS = pwdS + pwd[i] + "";
                }

                if (pwdS.equals("abc123.")) {
                    getContentPane().setBackground(Color.GREEN);
                } else {
                    getContentPane().setBackground(Color.RED);
                }
            }
        };

        sumarButton = new JButton("Comprobar");
        pwdField = new JPasswordField(8);
        pwdField.addActionListener(al);
        sumarButton.addActionListener(al);
        add(pwdField);
        add(sumarButton);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
