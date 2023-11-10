package com.mycompany.diexercicioslisteners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainFrame_19 extends JFrame{
    private int countHab;
    private int countGar;
    private int countTra;
    private JMenuItem hab1;
    private JMenuItem garaxeItem;
    private JMenuItem trasteiroItem;
    private JTextArea textArea;
    private JRadioButtonMenuItem radioBan;
    private JRadioButtonMenuItem radioCoci;
    private JCheckBoxMenuItem checkSalon;
    public MainFrame_19() throws HeadlessException, MalformedURLException {
        super("Ola mundo!");
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea,BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        ButtonGroup btnGrp = new ButtonGroup();
        countHab=0;
        countGar=0;
        countTra=0;
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object src = actionEvent.getSource();
                actionEvent.getActionCommand();
                if (src==hab1){
                    countHab++;
                    textArea.append("Pulsaches na habitación 1 "+countHab+" veces.\n");
                } else if (src==garaxeItem){
                    countGar++;
                    textArea.append("Pulsaches no garaxe "+countGar+" veces.\n");
                } else if (src==trasteiroItem){
                    countTra++;
                    textArea.append("Pulsaches no trasteiro "+countTra+" veces.\n");
                }
            }
        };

        ItemListener ilCheck = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange()==ItemEvent.SELECTED){
                    textArea.append(((JMenuItem)itemEvent.getSource()).getText()+". Estado activado.\n");
                } else {
                    textArea.append(((JMenuItem)itemEvent.getSource()).getText()+". Estado desactivado.\n");
                }
            }
        };

        JMenu menuCasa = new JMenu("Casa");
        URL url = getClass().getResource("/casa.png");
        Icon icon = new ImageIcon(url);
        menuCasa.setIcon(icon);
        JMenu menuHabi = new JMenu("Habitacións");
        checkSalon = new JCheckBoxMenuItem("Salón");
        checkSalon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        checkSalon.addItemListener(ilCheck);

        radioCoci = new JRadioButtonMenuItem("Cociña");
        radioCoci.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        radioCoci.setSelected(true);
        radioCoci.addItemListener(ilCheck);

        radioBan = new JRadioButtonMenuItem("Baño");
        radioBan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        radioBan.addItemListener(ilCheck);

        hab1 = new JMenuItem("Habitación 1");
        hab1.addActionListener(al);
        JMenuItem hab2 = new JMenuItem("Habitación 2");
        hab1.setToolTipText("Selecciona a habitación 1");
        hab2.setEnabled(false);

        btnGrp.add(radioCoci);
        btnGrp.add(radioBan);

        menuHabi.add(hab1);
        menuHabi.add(hab2);

        menuCasa.add(menuHabi);
        menuCasa.add(checkSalon);
        menuCasa.addSeparator();
        menuCasa.add(radioCoci);
        menuCasa.add(radioBan);

        JMenu menuExtras = new JMenu("Extras");

        garaxeItem = new JMenuItem("Garaxe");
        garaxeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.ALT_MASK));
        garaxeItem.addActionListener(al);

        trasteiroItem = new JMenuItem("Trasteiro");
        trasteiroItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
        trasteiroItem.addActionListener(al);

        menuExtras.add(garaxeItem);
        menuExtras.add(trasteiroItem);

        menuBar.add(menuCasa);
        menuBar.add(menuExtras);

        setJMenuBar(menuBar);

        setSize(600, 500);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
