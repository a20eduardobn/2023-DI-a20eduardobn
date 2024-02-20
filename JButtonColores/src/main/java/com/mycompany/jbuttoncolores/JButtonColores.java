/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jbuttoncolores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a20eduardobn
 */
public class JButtonColores extends JButton implements Serializable {
    
    private Colores colores;
    private Colores coloresHover;
    
    public JButtonColores() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                applyHoverColors();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                applyDefaultColors();
            }
        });
    }

    public Colores getColores() {
        return colores;
    }

    public void setColores(Colores colores) {
        this.colores = colores;
        applyDefaultColors();
    }

    public Colores getColoresHover() {
        return coloresHover;
    }

    public void setColoresHover(Colores coloresHover) {
        this.coloresHover = coloresHover;
    }

    private void applyHoverColors() {
        if (coloresHover != null) {
            setBackground(coloresHover.getCorFondo());
            setForeground(coloresHover.getCorTexto());
            repaint();
        }
    }

    private void applyDefaultColors() {
        if (colores != null) {
            setBackground(colores.getCorFondo());
            setForeground(colores.getCorTexto());
            repaint();
        } else {
            setBackground(new JButton().getBackground());
            setForeground(new JButton().getForeground());
            repaint();
        }
        
    }
    
}
