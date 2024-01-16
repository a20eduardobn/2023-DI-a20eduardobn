/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jbuttoncolores;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a20eduardobn
 */
public class JButtonColores extends JButton implements Serializable {
    
    private Colores colores;
    
    public JButtonColores() {
    }

    public Colores getColores() {
        return colores;
    }

    public void setColores(Colores colores) {
        this.colores = colores;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (colores != null) {
            super.setBackground(colores.getCorFondo());
            super.setForeground(colores.getCorTexto());
        }
    }
    
}
