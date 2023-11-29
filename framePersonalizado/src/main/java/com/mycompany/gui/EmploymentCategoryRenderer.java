package com.mycompany.gui;

import com.mycompany.controller.Controller;
import com.mycompany.model.EmploymentCategory;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class EmploymentCategoryRenderer extends JComboBox<EmploymentCategory> implements TableCellRenderer {
    public EmploymentCategoryRenderer(Controller controller) {
// inicializar o JComboBox cos valores da clase EmploymentCategory
        super(controller.getEmploymentCategories());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int col) {
// value é o valor actual da cela a ser renderizada
        this.setSelectedItem(value);
        return this;
    }
}
