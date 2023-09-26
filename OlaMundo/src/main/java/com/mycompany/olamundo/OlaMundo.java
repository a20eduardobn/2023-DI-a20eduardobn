package com.mycompany.olamundo;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Locale;

public class OlaMundo {

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        for (Font font : allFonts) {
            System.out.println(font.getFontName(Locale.US));
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
            }
        });
    }
}
