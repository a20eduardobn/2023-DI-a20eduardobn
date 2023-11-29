package com.mycompany.gui;

import com.mycompany.controller.Controller;
import com.mycompany.model.EmploymentCategory;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmploymentCategoryEditor extends AbstractCellEditor implements
        TableCellEditor {
    private JComboBox combo;
    private Controller controller;
    public EmploymentCategoryEditor(Controller controller) {
// inicializar o JComboBox cos valores da clase EmploymentCategory
        this.controller=controller;
        combo = new JComboBox();
        for (EmploymentCategory e: controller.getEmploymentCategories()) {
            combo.addItem(e);
        }
    }
    @Override
    public Object getCellEditorValue() {
        return combo.getSelectedItem();
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
// value é o valor actual da cela a ser renderizada
        combo.setSelectedItem(value);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
// para parar de usar o editor e facer que se mostre o renderer
// e actualizar o valor no TableModel
                fireEditingStopped();
            }
        });
        return combo;
    }
}
