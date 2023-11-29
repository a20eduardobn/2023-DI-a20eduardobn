package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableColorRenderer extends DefaultTableCellRenderer {

    private JLabel label1;
    private JLabel label2;

    public TableColorRenderer(JLabel label1, JLabel label2) {
        this.label1 = label1;
        this.label2 = label2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int col) {
        if (col == 1) {
            if (row == 0) {
                return label1;
            }
            return label2;
        } else {
            return new JLabel((String) value);
        }
    }
}
