/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jbuttoncolores;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author a20eduardobn
 */
public class Colores implements Serializable {

    private Color corFondo;
    private Color corTexto;

    public Colores() {
    }

    public Colores(Color corFondo, Color corTexto) {
        this.corFondo = corFondo;
        this.corTexto = corTexto;
    }

    public Color getCorFondo() {
        return corFondo;
    }

    public void setCorFondo(Color corFondo) {
        this.corFondo = corFondo;
    }

    public Color getCorTexto() {
        return corTexto;
    }

    public void setCorTexto(Color corTexto) {
        this.corTexto = corTexto;
    }
}
