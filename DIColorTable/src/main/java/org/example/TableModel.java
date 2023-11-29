package org.example;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TableModel extends AbstractTableModel {


    private JLabel label1;
    private JLabel label2;

    public TableModel(JLabel label1, JLabel label2) {
        this.label1 = label1;
        this.label2 = label2;
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0) {
            return "Select color " + row;
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex==1){
            if (rowIndex==1){
                label1.setBackground((Color)aValue);
            }else {
                label2.setBackground((Color)aValue);
            }
        }
    }
}
