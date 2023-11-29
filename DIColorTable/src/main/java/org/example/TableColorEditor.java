package org.example;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableColorEditor extends AbstractCellEditor implements TableCellEditor {

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        // value é o valor actual da cela a ser renderizada
        return new JLabel();
    }

    @Override
    public Object getCellEditorValue() {
        return JColorChooser.showDialog(null, "Choose a color", Color.red);
    }
}
