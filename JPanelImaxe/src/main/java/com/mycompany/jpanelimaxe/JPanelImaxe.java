/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jpanelimaxe;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author a20eduardobn
 */
public class JPanelImaxe extends JPanel implements Serializable {

    private ImaxeFondo imaxeFondo;

    public JPanelImaxe() {
    }

    public ImaxeFondo getImaxeFondo() {
        return imaxeFondo;
    }

    public void setImaxeFondo(ImaxeFondo imaxeFondo) {
        this.imaxeFondo = imaxeFondo;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Para evitar un NullPointerException antes de iniciar a propiedade
        if (imaxeFondo != null) {
            if (imaxeFondo.getFicheiroImaxe() != null && imaxeFondo.getFicheiroImaxe().exists()) {
                ImageIcon imageIcon = new ImageIcon(imaxeFondo.getFicheiroImaxe().getAbsolutePath());
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                        imaxeFondo.getOpacidade()));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
                // Unha vez cambiada a opacidade, hai que volver a poñela en 1
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
        }
    }

}
