/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.mycompany.controller.Controller;
import com.mycompany.model.EmploymentCategory;
import com.mycompany.model.Person;

/**
 *
 * @author a20eduardobn
 */
public class PersonTableModel extends AbstractTableModel {

    private List<Person> personList;
    private String[] columnNames = {"ID", "Name", "Occupation", "Age Category",
        "Employment Category", "US Citizen", "Tax ID", "Gender"};

    public PersonTableModel() {
    }

    public void setData(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int getRowCount() {
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object obj =
        switch (column){
            case 0 -> personList.get(row).getId();
            case 1 -> personList.get(row).getName();
            case 2 -> personList.get(row).getOccupation();
            case 3 -> personList.get(row).getAgeCategory();
            case 4 -> personList.get(row).getEmpCat();
            case 5 -> personList.get(row).isUsCitizen();
            case 6 -> personList.get(row).getTaxId();
            case 7 -> personList.get(row).getGender();
            default -> "";

        };
        return obj;
    }

    @Override
    public String getColumnName(int column) {
        if (column < 0 || column >= getColumnCount()) {
            throw new ArrayIndexOutOfBoundsException(column);
        } else {
            return columnNames[column];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1||columnIndex==4||columnIndex==5;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex==1) {
            personList.get(rowIndex).setName((String) aValue);
        } else if (columnIndex==5){
            personList.get(rowIndex).setUsCitizen((boolean) aValue);
        } else if (columnIndex==4) {
            personList.get(rowIndex).setEmpCat((EmploymentCategory) aValue);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==5){
            return Boolean.class;
        } else if (columnIndex==4) {
            return EmploymentCategory.class;
        }
        return String.class;
    }
}
