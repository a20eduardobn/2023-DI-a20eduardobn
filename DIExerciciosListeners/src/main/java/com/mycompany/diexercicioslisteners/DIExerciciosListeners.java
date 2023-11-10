/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.diexercicioslisteners;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a20eduardobn
 */
public class DIExerciciosListeners {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainFrame_20();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
