/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.framepersonalizado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author a20eduardobn
 */
public class MainFrame extends JFrame {
// Declarar os compoñentes como variables privadas de instancia

    private TextPanel textPanel;
    private Toolbar myToolBar;
    private JButton aceptarButton;
    private FormPanel panelFormulario;

    public MainFrame() throws HeadlessException, ParseException {
        super("Ola Mundo!");
// Establecer o Layout
        setLayout(new BorderLayout());
// Inicializar os compoñentes
        textPanel = new TextPanel();
        myToolBar = new Toolbar();
        panelFormulario = new FormPanel();
        StringListener sl = new StringListener() {
            @Override
            public void textEmitted(StringEvent se) {
                textPanel.appendText(se.getText());
            }
        };
        myToolBar.setStrListener(sl);
        panelFormulario.setStrListener(sl);
        aceptarButton = new JButton("Aceptar");

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textPanel.appendText("Hola mundo\n");
            }
        }; // engadir os compoñentes
        aceptarButton.addActionListener(al);
        add(panelFormulario, BorderLayout.WEST);
        add(myToolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        setSize(600, 500);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
