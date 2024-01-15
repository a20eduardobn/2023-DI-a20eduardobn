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
    
    private Color corFondo;
    private Color corTexto;
    
    public JButtonColores() {
    }

    public JButtonColores(Color corFondo, Color corTexto) {
        this.corFondo = corFondo;
        this.corTexto = corTexto;
    }
    
    public Color getCorFondo() {
        return corFondo;
    }
    
    public void setCorFondo(Color corFondo) {
        this.corFondo = corFondo;
        repaint();
    }
    
    public Color getCorTexto() {
        return corTexto;
    }
    
    public void setCorTexto(Color corTexto) {
        this.corTexto = corTexto;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (corFondo != null) {
            super.setBackground(corFondo);
        }
        if (corTexto != null) {
            super.setForeground(corTexto);
        }
    }
    
}
