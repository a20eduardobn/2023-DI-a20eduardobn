package com.mycompany.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.prefs.Preferences;

public class PreferencesDialog extends JDialog {
    JLabel userLabel;
    JLabel passwdLabel;
    JLabel portLabel;
    JTextField userField;
    JPasswordField passwdField;
    JSpinner portField;
    JButton buttonCancel;
    JButton buttonOk;
    PreferencesListener preferencesListener;

    public PreferencesDialog(Frame owner, String title, boolean modal, Preferences prefs){
        super(owner,title,modal);
        setLayout(new BorderLayout());

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridBagLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        userLabel = new JLabel("User:");
        passwdLabel = new JLabel("Password:");
        portLabel = new JLabel("Port:");
        userField = new JTextField(10);
        passwdField = new JPasswordField(10);
        passwdField.setEchoChar('*');
        SpinnerNumberModel snm = new SpinnerNumberModel(3306, 0, 9999,1);
        portField = new JSpinner(snm);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.LINE_END;

        Border innerBorder = BorderFactory.createTitledBorder("Database preferences");
        Border outerBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        fieldsPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        gbc.insets=new Insets(10,10,10,0);
        gbc.weightx=0.1;
        fieldsPanel.add(userLabel,gbc);

        gbc.gridx=1;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0.2;
        gbc.insets=new Insets(10,20,10,20);
        fieldsPanel.add(userField,gbc);

        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx=0.1;
        gbc.insets=new Insets(10,10,10,0);
        gbc.fill=GridBagConstraints.NONE;
        fieldsPanel.add(passwdLabel,gbc);

        gbc.gridx=1;
        gbc.weightx=0.2;
        gbc.insets=new Insets(10,20,10,20);
        gbc.fill=GridBagConstraints.BOTH;
        fieldsPanel.add(passwdField,gbc);

        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx=0.1;
        gbc.insets=new Insets(10,10,10,0);
        gbc.fill=GridBagConstraints.NONE;
        fieldsPanel.add(portLabel,gbc);

        gbc.gridx=1;
        gbc.weightx=0.2;
        gbc.insets=new Insets(10,20,10,20);
        gbc.fill=GridBagConstraints.BOTH;
        fieldsPanel.add(portField,gbc);

        buttonOk = new JButton("OK");
        buttonOk.setPreferredSize(new Dimension(80,25));
        buttonPanel.add(buttonOk);
        buttonCancel = new JButton("Cancel");
        buttonPanel.add(buttonCancel);

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (preferencesListener !=null){
                    StringBuilder sb = new StringBuilder();
                    for (char caracter:
                         passwdField.getPassword()) {
                        sb.append(caracter);
                    }
                    String passwd=sb.toString();
                    preferencesListener.buttonPressed(new PreferencesEvent(PreferencesDialog.this,
                            userField.getText(), passwd, (int)portField.getValue()));
                }
                dispose();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        userField.setText(prefs.get("userPref", ""));
        passwdField.setText(prefs.get("passwdPref", ""));
        portField.setValue(prefs.getInt("portPref", 3306));


        add(fieldsPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.PAGE_END);
        setMinimumSize(new Dimension(300,240));
        setResizable(false);
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    public void setDialogListener(PreferencesListener preferencesListener) {
        this.preferencesListener = preferencesListener;
    }
}
