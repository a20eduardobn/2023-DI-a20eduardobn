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
import java.util.prefs.Preferences;
import javax.swing.*;

/**
 * @author a20eduardobn
 */
public class MainFrame extends JFrame {
// Declarar os compoñentes como variables privadas de instancia

    private Toolbar topToolBar;
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
    private TablePanel tablepanel;
    private JSplitPane jspMain;
    private JMenuItem menuItemFilter;
    private JMenuItem menuItemPreferences;
    private PreferencesListener preferencesListener;
    private Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
    public MainFrame() throws HeadlessException, ParseException {
        super("Formulario");
// Establecer o Layout
        setLayout(new BorderLayout());
// Inicializar os compoñentes
        controller = new Controller();
        tablepanel = new TablePanel(controller);
        topToolBar = new Toolbar();
        panelFormulario = new FormPanel();
        tablepanel.setData(controller.getDb().getPeople());

        FormListener sl = new FormListener() {
            @Override
            public void formEmitted(FormEvent se) {
                controller.addPerson(se);
                tablepanel.setData(controller.getDb().getPeople());
                tablepanel.refresh();
            }
        };

        ActionListener alButtonAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        };

        ActionListener alSalirMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int opt = JOptionPane.showConfirmDialog(MainFrame.this, "Queres sair do programa?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.OK_OPTION) System.exit(0);
            }
        };

        ActionListener alExportImport = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                fc.addChoosableFileFilter(new PersonFileFilter());
                if (actionEvent.getSource() == menuItemExport) {
                    if (fc.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                        controller.saveToFile(fc.getSelectedFile());
                } else {
                    if (fc.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                        controller.loadFromFile(fc.getSelectedFile());
                }
                tablepanel.refresh();
            }
        };

        ItemListener ilMenu = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
                    panelFormulario.setVisible(false);
                    jspMain.setOneTouchExpandable(false);
                } else {
                    panelFormulario.setVisible(true);
                    jspMain.setOneTouchExpandable(true);
                    jspMain.resetToPreferredSizes();
                }
            }
        };

        ToolbarListener toolbarListener = new ToolbarListener() {
            @Override
            public void toolbarActionPerformed(ToolbarEvent te) {
                JFileChooser fc = new JFileChooser();
                fc.addChoosableFileFilter(new PersonFileFilter());
                if (te.getActionCommand().equals("Save")) {
                    if (fc.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                        controller.saveToFile(fc.getSelectedFile());
                } else {
                    if (fc.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                        controller.loadFromFile(fc.getSelectedFile());
                }
                tablepanel.refresh();
            }
        };

        PersonTableListener personTableListener = new PersonTableListener() {
            @Override
            public void rowDeleted(int row) {
                controller.removePerson(row);
            }
        };

        ActionListener filterListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String textoBusqueda = JOptionPane.showInputDialog("Escribe el parametro de busqueda");

                tablepanel.getTable().setRowSorter(tablepanel.getSorter());
                RowFilter<PersonTableModel, Object> rf = null;
                //If current expression doesn't parse, don't update.
                try {
                    rf = RowFilter.regexFilter(textoBusqueda, 1);
                } catch (java.util.regex.PatternSyntaxException e) {
                    return;
                }
                tablepanel.getSorter().setRowFilter(rf);
            }
        };

        preferencesListener = new PreferencesListener() {
            @Override
            public void buttonPressed(PreferencesEvent e) {
                prefs.put("userPref", e.getUser());
                prefs.put("passwdPref", e.getPasswd());
                prefs.putInt("portPref", e.getPort());
            }
        };


        ActionListener alMenuPreferences = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PreferencesDialog dialog = new PreferencesDialog(MainFrame.this, "Preferences", false, prefs);
                dialog.setDialogListener(preferencesListener);
            }
        };


        tablepanel.addPersonTableListener(personTableListener);
        topToolBar.setToolbarListener(toolbarListener);
        panelFormulario.setFormListener(sl);
        aceptarButton = new JButton("Aceptar");

        // engadir os compoñentes
        aceptarButton.addActionListener(alButtonAceptar);
        jspMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jspMain.add(panelFormulario);
        jspMain.add(tablepanel);
        jspMain.setOneTouchExpandable(true);
        //add(panelFormulario, BorderLayout.WEST);
        add(topToolBar, BorderLayout.NORTH);
        add(jspMain, BorderLayout.CENTER);
        //add(tablepanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);

        createMenuBar();
        menucheckPerson.addItemListener(ilMenu);
        menuItemExit.addActionListener(alSalirMenu);
        menuItemImport.addActionListener(alExportImport);
        menuItemExport.addActionListener(alExportImport);
        menuItemFilter.addActionListener(filterListener);
        menuItemPreferences.addActionListener(alMenuPreferences);
        setJMenuBar(menuBar);

        setSize(900, 500);
        setMinimumSize(new Dimension(600, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuItemExport = new JMenuItem("Export Data...");
        menuItemImport = new JMenuItem("Import Data...");
        menuItemFilter = new JMenuItem("Filter...");
        menuItemExit = new JMenuItem("Exit");

        menuItemExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItemImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuItemExit.setMnemonic('x');
        menuFile.add(menuItemExport);
        menuFile.add(menuItemImport);
        menuFile.add(menuItemFilter);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);

        menuWindow = new JMenu("Window");
        menuItemShow = new JMenu("Show");
        menuItemPreferences = new JMenuItem("Preferences...");
        menuItemPreferences.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        menucheckPerson = new JCheckBoxMenuItem("Person Form");
        menucheckPerson.setSelected(true);
        menuItemShow.add(menucheckPerson);
        menuWindow.add(menuItemShow);
        menuWindow.add(menuItemPreferences);

        menuBar.add(menuFile);
        menuBar.add(menuWindow);
        return menuBar;
    }

}
