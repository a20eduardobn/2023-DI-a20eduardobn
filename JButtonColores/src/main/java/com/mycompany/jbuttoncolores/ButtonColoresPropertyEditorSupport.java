/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jbuttoncolores;

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
        return "new com.mycompany.JButtonColores(" + colores.getCorFondo() + ", " + colores.getCorTexto() + ")";
    }

    @Override
    public Object getValue() {
        return buttonColoresPanel.getSelectedValue();
    }

}
