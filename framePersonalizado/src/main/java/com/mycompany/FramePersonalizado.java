/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.gui.MainFrame;

import java.awt.HeadlessException;
import java.text.ParseException;

/**
 *
 * @author a20eduardobn
 */
public class FramePersonalizado {
    public static void main(String[] args) throws HeadlessException{
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainFrame();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
