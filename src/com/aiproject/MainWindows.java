package com.aiproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class MainWindows extends javax.swing.JFrame {

    // TODO stocker les valeurs des poids dans la BDD pour chaque caractère
    // TODO Afficher l'image
    // TODO changer de fenêtre en fonction du menu

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form mainWindow
     */
    public MainWindows() {
        initComponents();
        String windowTitle = "Character recognition";
        this.setTitle(windowTitle);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        JLabel imageContainer = new JLabel();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu file = new JMenu();
        JMenuItem openFile = new JMenuItem();
        JMenuItem settings = new JMenuItem();
        JMenuItem exit = new JMenuItem();
        JMenu add = new JMenu();
        JMenuItem addChar = new JMenuItem();
        JMenu help = new JMenu();
        JMenuItem about = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        file.setText("File");

        openFile.setText("Open file");
        openFile.addActionListener(this::OpenFileActionPerformed);
        file.add(openFile);
        openFile.getAccessibleContext().setAccessibleDescription("");

        settings.setText("Settings");

        // File.add(Settings);

        exit.setText("Exit");
        exit.addActionListener(this::ExitActionPerformed);
        file.add(exit);

        jMenuBar1.add(file);

        add.setText(" Add");

        addChar.setText("Add char to DB");
        addChar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // TODO make action
            }
        });

        add.add(addChar);

        jMenuBar1.add(add);

        help.setText("Help");

        about.setText("About");
        about.addActionListener(this::ShowHelpActionPerformed);

        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addContainerGap()));

        pack();
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

    private void OpenFileActionPerformed(ActionEvent evt) {
        //displayBrowserWindow();
    }

    private void ExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void printFile(File[] fileList) {
        //imageContainer.setIcon();
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindows.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindows().setVisible(true);
            }
        });
    }

}
