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
public class ButtonColoresHoverPropertyEditorSupport extends PropertyEditorSupport {

    private ButtonColoresHoverPanel buttonColoresPanel = new ButtonColoresHoverPanel();

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
                + corFondo.getRGB() + ")" + ", new java.awt.Color("
                + corTexto.getRGB() + "))";
    }

    @Override
    public Object getValue() {
        return buttonColoresPanel.getSelectedValue();
    }

}
