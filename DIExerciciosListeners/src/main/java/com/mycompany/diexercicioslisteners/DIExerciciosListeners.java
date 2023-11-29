/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.diexercicioslisteners;

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
