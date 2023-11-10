/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.framepersonalizado;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author a20eduardobn
 */
public class Toolbar extends JPanel {

    private JButton botonHello;
    private JButton botonGbye;
    private StringListener strListener;

    public Toolbar() {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        setLayout(fl);
        botonHello = new JButton("Hello");
        botonGbye = new JButton("Goodbye");
        

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton == botonHello) {
                    if (strListener != null) {
                        StringEvent se = new StringEvent(this, "Hello");
                        strListener.textEmitted(se);
                    }
                } else if (clickedButton == botonGbye) {
                    if (strListener != null) {
                        StringEvent se = new StringEvent(this, "Goodbye");
                        strListener.textEmitted(se);
                    }
                }
            }
        };
        botonHello.addActionListener(al);
        botonGbye.addActionListener(al);
        add(botonHello);
        add(botonGbye);
    }

    public void setStrListener(StringListener strListener) {
        this.strListener = strListener;
    }

}
