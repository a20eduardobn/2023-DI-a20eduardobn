/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.framepersonalizado;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

    // Declarar os compoñentes como variables privadas de instancia
    private JButton funcionButton1;
    private JTextField campoName;
    private JTextField campoOccup;
    private JLabel labelName;
    private JLabel labelIdade;
    private JList listaIdade;
    private DefaultListModel modeloIdade;
    private JScrollPane panelScroll;

    private StringListener strListener;

    public FormPanel() throws HeadlessException, ParseException {
        // Establecer o Layout
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(250, 300));
        GridBagConstraints gbc = new GridBagConstraints();
        // Inicializar os compoñentes

        JPanel pane = new JPanel();
        JPanel line = new JPanel();

        line.setBorder(BorderFactory.createTitledBorder("title"));
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        line.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        line.setLayout(new GridBagLayout());
        pane.setLayout(new GridBagLayout());

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (strListener != null && !campoName.getText().equals("")) {

                    StringEvent strEvt = new StringEvent(this, campoName.getText() + " " + campoOccup.getText() + "\n");
                    strListener.textEmitted(strEvt);
                }
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
        gbc.insets = new Insets(5, 0, 0, 10);
        labelName = new JLabel("Occupation:");
        pane.add(labelName, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        campoOccup = new JTextField(10);
        pane.add(campoOccup, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 10);
        labelIdade = new JLabel("Idade:");
        labelIdade.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        pane.add(labelIdade, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        panelScroll = new JScrollPane();
        modeloIdade = new DefaultListModel();
        listaIdade = new JList();
        listaIdade.setModel(modeloIdade);
        panelScroll.add(listaIdade);
        pane.add(panelScroll, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        funcionButton1 = new JButton("OK");
        funcionButton1.addActionListener(al);
        pane.add(funcionButton1, gbc);
        
        panelScroll.setPreferredSize(new Dimension(110, 50));
        modeloIdade.addElement(new AgeCategory(0, "Under 18"));
        modeloIdade.addElement(new AgeCategory(0, "18 to 65"));
        modeloIdade.addElement(new AgeCategory(0, "85 or over"));

        setVisible(true);

    }

    public void setStrListener(StringListener strListener) {
        this.strListener = strListener;
    }
}
