/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author a20eduardobn
 */
public class Toolbar extends JToolBar {

    private JButton botonImport;
    private JButton botonSave;
    private ToolbarListener toolbarListener;

    public Toolbar() {
        botonImport = new JButton();
        botonImport.setIcon(getIcon("/general/Import16.gif"));
        botonImport.setToolTipText("Import a save file");

        botonSave = new JButton();
        botonSave.setIcon(getIcon("/general/Save16.gif"));
        botonSave.setToolTipText("Save data to file");
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                ToolbarEvent te = new ToolbarEvent(Toolbar.this);
                if (toolbarListener!=null) {
                    if (clickedButton == botonImport) {
                        te.setActionCommand("Import");
                    } else if (clickedButton == botonSave) {
                        te.setActionCommand("Save");
                    }
                    toolbarListener.toolbarActionPerformed(te);
                }
            }
        };
        botonImport.addActionListener(al);
        botonSave.addActionListener(al);
        add(botonImport);
        add(botonSave);
    }

    public void setToolbarListener(ToolbarListener toolbarListener) {
        this.toolbarListener = toolbarListener;
    }

    public Icon getIcon(String path){
        URL url = getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }

}
