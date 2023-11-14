package com.mycompany.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()){
            return true;
        }
        String extension = Utils.getExtension(file);
        if (extension.equals("per")){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Ficheiro de persoas (*.per)";
    }
}
