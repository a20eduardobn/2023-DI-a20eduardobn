
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpanelimaxe;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author a20eduardobn
 */
public class ImaxeFondo implements Serializable {

    private File ficheiroImaxe;
    private float opacidade;

    public ImaxeFondo() {
    }

    public ImaxeFondo(File ficheiroImaxe, float opacidade) {
        this.ficheiroImaxe = ficheiroImaxe;
        this.opacidade = opacidade;
    }

    public File getFicheiroImaxe() {
        return ficheiroImaxe;
    }

    public void setFicheiroImaxe(File ficheiroImaxe) {
        this.ficheiroImaxe = ficheiroImaxe;
    }

    public float getOpacidade() {
        return opacidade;
    }

    public void setOpacidade(float opacidade) {
        this.opacidade = opacidade;
    }

}
