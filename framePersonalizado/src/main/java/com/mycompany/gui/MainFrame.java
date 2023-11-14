/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.controller.Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;

/**
 *
 * @author a20eduardobn
 */
public class MainFrame extends JFrame {
// Declarar os compoñentes como variables privadas de instancia

    private TextPanel textPanel;
    private Toolbar myToolBar;
    private JButton aceptarButton;
    private FormPanel panelFormulario;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemExport;
    private JMenuItem menuItemImport;
    private JMenuItem menuItemExit;
    private JMenu menuWindow;
    private JMenu menuItemShow;
    private JCheckBoxMenuItem menucheckPerson;
    private Controller controller;

    public MainFrame() throws HeadlessException, ParseException {
        super("Formulario");
// Establecer o Layout
        setLayout(new BorderLayout());
// Inicializar os compoñentes
        controller = new Controller();
        textPanel = new TextPanel();
        myToolBar = new Toolbar();
        panelFormulario = new FormPanel();



        StringListener sl = new StringListener() {
            @Override
            public void textEmitted(StringEvent se) {
                controller.addPerson(se);
                textPanel.appendText(se.getText());
            }
        };

        ActionListener alButtonAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textPanel.appendText("Hola mundo\n");
            }
        };

        ActionListener alSalirMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int opt = JOptionPane.showConfirmDialog(MainFrame.this, "Queres sair do programa?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.OK_OPTION)System.exit(0);
            }
        };

        ActionListener alExportImport = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                fc.addChoosableFileFilter(new PersonFileFilter());
                if (actionEvent.getSource()==menuItemExport){
                    fc.showSaveDialog(MainFrame.this);
                } else {
                    fc.showOpenDialog(MainFrame.this);
                }
            }
        };

        ItemListener ilMenu = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                    panelFormulario.setVisible(false);
                } else {
                    panelFormulario.setVisible(true);
                }
            }
        };

        myToolBar.setStrListener(sl);
        panelFormulario.setStrListener(sl);
        aceptarButton = new JButton("Aceptar");

        // engadir os compoñentes
        aceptarButton.addActionListener(alButtonAceptar);
        add(panelFormulario, BorderLayout.WEST);
        add(myToolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);

        createMenuBar();
        menucheckPerson.addItemListener(ilMenu);
        menuItemExit.addActionListener(alSalirMenu);
        menuItemImport.addActionListener(alExportImport);
        menuItemExport.addActionListener(alExportImport);
        setJMenuBar(menuBar);

        setSize(600, 500);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JMenuBar createMenuBar(){
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuItemExport = new JMenuItem("Export Data...");
        menuItemImport = new JMenuItem("Import Data...");
        menuItemExit = new JMenuItem("Exit");

        menuItemExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItemImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuItemExit.setMnemonic('x');
        menuFile.add(menuItemExport);
        menuFile.add(menuItemImport);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);

        menuWindow = new JMenu("Window");
        menuItemShow = new JMenu("Show");
        menucheckPerson = new JCheckBoxMenuItem("Person Form");
        menuItemShow.add(menucheckPerson);
        menuWindow.add(menuItemShow);

        menuBar.add(menuFile);
        menuBar.add(menuWindow);
        return menuBar;
    }

}
