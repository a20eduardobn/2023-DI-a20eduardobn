/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jbuttoncolores;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author a20eduardobn
 */
public class ButtonColoresPropertyEditorSupport extends PropertyEditorSupport {

    private ButtonColoresPanel buttonColoresPanel = new ButtonColoresPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return buttonColoresPanel;
    }

    @Override
    public String getJavaInitializationString() {
        Colores colores = buttonColoresPanel.getSelectedValue();
        Color corFondo = colores.getCorFondo();
        Color corTexto = colores.getCorTexto();
        return "new com.mycompany.jbuttoncolores.Colores(" + " new java.awt.Color("
                + corFondo.getRed() + "," + corFondo.getGreen() + "," + corFondo.getBlue()
                + ")" + ", new java.awt.Color("
                + corTexto.getRed() + "," + corTexto.getGreen() + "," + corTexto.getBlue() + "))";
    }

    @Override
    public Object getValue() {
        return buttonColoresPanel.getSelectedValue();
    }

}
