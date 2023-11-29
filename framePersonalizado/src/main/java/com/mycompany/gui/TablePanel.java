package com.mycompany.gui;

import com.mycompany.controller.Controller;
import com.mycompany.model.EmploymentCategory;
import com.mycompany.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel personTableModel;
    private JPopupMenu eliminarMenu;
    private JMenuItem eliminarItem;
    private PersonTableListener personTableListener;
    private Controller controller;
    public TablePanel(Controller controller) {

        this.controller=controller;
        eliminarMenu = new JPopupMenu();
        eliminarItem = new JMenuItem("Eliminar fila");
        eliminarMenu.add(eliminarItem);
        eliminarItem.addActionListener(actionEvent -> {
            int row = table.getSelectedRow();

            if (personTableListener != null) {
                personTableListener.rowDeleted(row);
                personTableModel.fireTableRowsDeleted(row, row);
            }
        });

        personTableModel = new PersonTableModel();
        table = new JTable(personTableModel);
        table.setFillsViewportHeight(true);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton()==MouseEvent.BUTTON3) {
                    int r = table.rowAtPoint(mouseEvent.getPoint());
                    table.setRowSelectionInterval(r, r);
                    eliminarMenu.show(table, mouseEvent.getX(), mouseEvent.getY());
                }
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });

        table.setDefaultRenderer(EmploymentCategory.class, new EmploymentCategoryRenderer(controller));
        table.setDefaultEditor(EmploymentCategory.class, new EmploymentCategoryEditor(controller));
        table.setRowHeight(25);

        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);

    }
    public void setData(List<Person> personList) {
        personTableModel.setData(personList);
    }
    // para notificar á vista de que o modelo de datos cambiou
    public void refresh() {
        personTableModel.fireTableDataChanged();
    }

    public void addPersonTableListener(PersonTableListener personTableListener) {
        this.personTableListener = personTableListener;
    }
}
