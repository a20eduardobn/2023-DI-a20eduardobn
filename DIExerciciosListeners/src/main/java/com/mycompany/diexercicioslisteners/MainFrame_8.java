/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diexercicioslisteners;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MainFrame_8 extends JFrame {

    // Declarar os compoñentes como variables privadas de instancia
    private JFormattedTextField txtFieldNums;
    private JFormattedTextField txtFieldDates;
    private JButton printButton;
    private JLabel labelNums;
    private JLabel labelDates;

    public MainFrame_8() throws HeadlessException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new FlowLayout());
        // Inicializar os compoñentes

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Numero: " + txtFieldNums.getText());
                System.out.println("Fecha: " + txtFieldDates.getText());
            }
        };

        NumberFormat formatNums = NumberFormat.getInstance();
        DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate local = LocalDate.now();

        txtFieldNums = new JFormattedTextField(formatNums);
        txtFieldNums.setColumns(20);
        txtFieldNums.setText("5400");
        txtFieldDates = new JFormattedTextField(formatDate);
        txtFieldDates.setColumns(20);
        txtFieldDates.setText(local.getDayOfMonth() + "/" + local.getMonthValue() + "/" + local.getYear());
        labelNums = new JLabel("Numeros");
        labelDates = new JLabel("Dates");
        printButton = new JButton("Imprimir");

        printButton.addActionListener(al);

        add(labelNums);
        add(txtFieldNums);
        add(labelDates);
        add(txtFieldDates);
        add(printButton);

        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
