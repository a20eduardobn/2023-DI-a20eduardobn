/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

    // Declarar os compoñentes como variables privadas de instancia
    private JButton okButton;
    private JTextField campoName;
    private JTextField campoOccup;
    private JLabel labelName;
    private JLabel labelOccup;
    private JLabel labelIdade;
    private JList listaIdade;
    private DefaultListModel modeloIdade;
    private JScrollPane panelScroll;
    private JLabel employmentLabel;
    private JComboBox employmentBox;
    private JCheckBox usCitizenCheck;
    private JLabel usCitizenLabel;
    private JLabel taxIdLabel;
    private JTextField taxIdField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup btnGrp;


    private FormListener formListener;

    public FormPanel() throws HeadlessException, ParseException {
        // Establecer o Layout
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(250, 300));
        GridBagConstraints gbc = new GridBagConstraints();
        // Inicializar os compoñentes

        JPanel pane = new JPanel();
        JPanel line = new JPanel();

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        line.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        line.setLayout(new GridBagLayout());
        pane.setLayout(new GridBagLayout());

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (formListener != null && !campoName.getText().equals("")) {
                    String valorGender = maleRadioButton.isSelected() ? maleRadioButton.getText() : femaleRadioButton.getText();
                    FormEvent formEvent = new FormEvent(this, campoName.getText(),
                            campoOccup.getText(), ((AgeCategory) listaIdade.getSelectedValue()).getId(),
                            employmentBox.getSelectedItem().toString(), valorGender, taxIdField.getText(), usCitizenCheck.isSelected());
                    formListener.formEmitted(formEvent);
                }
            }
        };

        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                taxIdField.setEnabled(itemEvent.getStateChange() == ItemEvent.SELECTED);
            }
        };

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        line.add(pane, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        add(line, gbc);

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 10);
        labelName = new JLabel("Name:");
        labelName.setAlignmentX(JLabel.RIGHT_ALIGNMENT);

        pane.add(labelName, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        campoName = new JTextField(10);
        pane.add(campoName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 10);
        labelOccup = new JLabel("Occupation:");
        pane.add(labelOccup, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        campoOccup = new JTextField(10);
        pane.add(campoOccup, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(5, 0, 0, 10);
        labelIdade = new JLabel("Idade:");
        labelIdade.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        pane.add(labelIdade, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        panelScroll = new JScrollPane();
        modeloIdade = new DefaultListModel();
        listaIdade = new JList();
        listaIdade.setModel(modeloIdade);
        panelScroll.setViewportView(listaIdade);
        listaIdade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.add(panelScroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 10);
        employmentLabel = new JLabel("Employment:");
        pane.add(employmentLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(5, 0, 0, 0);
        employmentBox = new JComboBox();
        pane.add(employmentBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 0, 0, 10);
        usCitizenLabel = new JLabel("US Citizen:");
        pane.add(usCitizenLabel, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        usCitizenCheck = new JCheckBox();
        usCitizenCheck.addItemListener(il);
        pane.add(usCitizenCheck, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(5, 0, 0, 10);
        taxIdLabel = new JLabel("Tax Id:");
        pane.add(taxIdLabel, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        taxIdField = new JTextField(10);
        taxIdField.setEnabled(false);
        pane.add(taxIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(5, 0, 0, 10);
        taxIdLabel = new JLabel("Gender:");
        pane.add(taxIdLabel, gbc);

        btnGrp = new ButtonGroup();

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        maleRadioButton = new JRadioButton("male");
        btnGrp.add(maleRadioButton);
        maleRadioButton.setSelected(true);
        pane.add(maleRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.insets = new Insets(2, 0, 0, 10);
        femaleRadioButton = new JRadioButton("female");
        btnGrp.add(femaleRadioButton);
        pane.add(femaleRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_START;
        okButton = new JButton("OK");
        okButton.addActionListener(al);
        pane.add(okButton, gbc);

        panelScroll.setPreferredSize(new Dimension(114, 60));
        modeloIdade.addElement(new AgeCategory(0, "Under 18"));
        modeloIdade.addElement(new AgeCategory(1, "18 to 65"));
        modeloIdade.addElement(new AgeCategory(2, "65 or over"));
        listaIdade.setSelectedIndex(1);

        employmentBox.addItem("employed");
        employmentBox.addItem("self-employed");
        employmentBox.addItem("unemployed");
        employmentBox.setEditable(true);
        employmentBox.setPreferredSize(new Dimension(114, 20));

        setVisible(true);

    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}
