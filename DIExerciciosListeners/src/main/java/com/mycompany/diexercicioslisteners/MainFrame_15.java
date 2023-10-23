package com.mycompany.diexercicioslisteners;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a20eduardobn
 */
public class MainFrame_15 extends JFrame {

    private JButton borrarButton;
    private JTextField campoTexto;
    private JButton engadirButton;
    private JList lista;
    private DefaultListModel modelLista;

    public MainFrame_15() throws HeadlessException, ParseException {
        super("Ola mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        BorderLayout bl = new BorderLayout();
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout());

        borrarButton = new JButton("Borrar");
        jp.add(borrarButton);

        campoTexto = new JTextField();
        jp.add(campoTexto);

        engadirButton = new JButton("Engadir");
        jp.add(engadirButton);

        lista = new JList();
        modelLista = new DefaultListModel();
        lista.setModel(modelLista);

        modelLista.add(0, "Ada");
        modelLista.add(1, "Erea");
        modelLista.add(2, "Navia");
        
        lista.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == engadirButton || ae.getSource() == campoTexto) {
                    modelLista.add(lista.getSelectedIndex() + 1, campoTexto.getText());
                    lista.setSelectedIndex(lista.getSelectedIndex() + 1);
                } else {
                    if (modelLista.getSize() > 1) {
                        int selectedIndex;
                        if (modelLista.size() - 1 == lista.getSelectedIndex()) {
                            selectedIndex = lista.getSelectedIndex();
                            modelLista.removeElementAt(selectedIndex);
                            lista.setSelectedIndex(selectedIndex - 1);
                        } else {
                            selectedIndex = lista.getSelectedIndex();
                            modelLista.removeElementAt(selectedIndex);
                            lista.setSelectedIndex(selectedIndex);
                        }
                    } else {
                        modelLista.removeElementAt(lista.getSelectedIndex());
                    }

                }
                borrarButton.setEnabled(!modelLista.isEmpty());
                campoTexto.setText("");
            }
        };

        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                if (!engadirButton.isEnabled()) {
                    engadirButton.setEnabled(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (de.getDocument().getLength() == 0 && engadirButton.isEnabled()) {
                    engadirButton.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        };

        campoTexto.getDocument().addDocumentListener(dl);
        campoTexto.addActionListener(al);
        engadirButton.addActionListener(al);
        engadirButton.setEnabled(false);
        borrarButton.addActionListener(al);
        
        add(lista, BorderLayout.CENTER);
        add(jp, BorderLayout.PAGE_END);

        setSize(600, 500);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
