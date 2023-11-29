package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("Color Table");
        setLayout(new BorderLayout());
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JTable table = new JTable(new TableModel(label1,label2));
        table.setFillsViewportHeight(true);
        add(table, BorderLayout.CENTER);
        table.setDefaultRenderer(Object.class, new TableColorRenderer(label1,label2));
        table.setDefaultEditor(Object.class, new TableColorEditor());

        setSize(new Dimension(600,400));
        setMinimumSize(new Dimension(400,300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
