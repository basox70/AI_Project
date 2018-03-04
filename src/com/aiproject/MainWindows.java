package com.aiproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class MainWindows extends JFrame {

    // TODO stocker les valeurs des poids dans la BDD pour chaque caractère
    // TODO Afficher l'image
    // TODO changer de fenêtre en fonction du menu

    private static final long serialVersionUID = 1L;

    private JPanel container = new JPanel();
    private JPanel panneau1 = new JPanel();
    private JPanel panneau2 = new JPanel();
    private JPanel panneau3 = new JPanel();
    private JPanel panneau4 = new JPanel();

    /**
     * Creates new form mainWindow
     */
    public MainWindows() {
        this.setTitle("Character recognition");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(true);

        // Menu Bar
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu file = new JMenu();
        JMenuItem openFile = new JMenuItem();
        JMenuItem settings = new JMenuItem();
        JMenuItem exit = new JMenuItem();
        JMenu help = new JMenu();
        JMenuItem about = new JMenuItem();

        // Tabbed Menu
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        jTabbedPane1.addTab("Add", null, null,null);
        jTabbedPane1.addTab("Recognition", null, null,null);
        
        file.setText("File");

        openFile.setText("Open file");
        file.add(openFile);
        openFile.getAccessibleContext().setAccessibleDescription("");

        settings.setText("Settings");

        // File.add(Settings);

        exit.setText("Exit");
        exit.addActionListener(this::ExitActionPerformed);
        file.add(exit);

        jMenuBar1.add(file);

        help.setText("Help");

        about.setText("About");
        about.addActionListener(this::ShowHelpActionPerformed);

        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);
        setContentPane(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap()));
        
        pack();
        // ------------------------
    }

    private void ShowHelpActionPerformed(ActionEvent evt) {

        JTextArea field1 = new JTextArea("This app is used for character recognition.\n"
                + "It was developed by :"
                + "\n\t- Amaury DEFRANCE\n\t- Basile DUBRUQUE\n\t- Louis MICHAUX");
        field1.setEditable(false);
        field1.setRows(5);
        field1.setColumns(20);
        field1.setTabSize(4);
        field1.setFocusable(false);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(field1);
        @SuppressWarnings("unused")
        int result = JOptionPane.showConfirmDialog(null, panel, "About", JOptionPane.CLOSED_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }

    private void ExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Theme windows
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindows().setVisible(true);
            }
        });
        //MainWindows fenetre = new MainWindows();

    }

}
