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
                    MainFrame_9 frame = new MainFrame_9();
                } catch (HeadlessException ex) {
                    Logger.getLogger(DIExerciciosListeners.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(DIExerciciosListeners.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
