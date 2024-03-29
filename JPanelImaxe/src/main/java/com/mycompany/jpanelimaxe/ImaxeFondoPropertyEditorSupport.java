/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpanelimaxe;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author a20eduardobn
 */
public class ImaxeFondoPropertyEditorSupport extends PropertyEditorSupport {

    private ImaxeFondoPanel imaxeFondoPanel = new ImaxeFondoPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return imaxeFondoPanel;
    }

    @Override
    public String getJavaInitializationString() {
        ImaxeFondo imaxeFondo = imaxeFondoPanel.getSelectedValue();
        return "new com.mycompany.jpanelimaxe.ImaxeFondo(" + "new java.io.File(\""
                + imaxeFondo.getFicheiroImaxe().getAbsolutePath() + "\"), " + imaxeFondo.getOpacidade()
                + "f)";
    }

    @Override
    public Object getValue() {
        return imaxeFondoPanel.getSelectedValue();
    }
}
