package com.aiproject;

import java.awt.*;
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

        // Menu Bar
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu file = new JMenu();
        JMenuItem openFile = new JMenuItem();
        JMenuItem settings = new JMenuItem();
        JMenuItem exit = new JMenuItem();
        JMenu add = new JMenu();
        JMenuItem addChar = new JMenuItem();
        JMenu help = new JMenu();
        JMenuItem about = new JMenuItem();

        // Tabbed Menu
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        jTabbedPane1.addTab("Add", null, getTabAdd(),null);
        jTabbedPane1.addTab("Recognition", null, getTabRecognition(),null);
        
        // Menu Item components ----
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
        setContentPane(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap()));
        
        pack();
        // -------------------------

        // Tab components------------
        JPanel pnPanel0;
        JTabbedPane tbpTabbedPane0;

        JPanel pnAdd;

        JPanel pnPanel13;
        JButton btSelectFile;
        JLabel lbImage;
        JLabel lbInput;
        JTextField tfInputText;
        JButton btInputAdd;

        JPanel pnCharRecongnitionTab;

        pnPanel0 = new JPanel();
        pnPanel0.setBackground( new Color( 255,255,255 ) );
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout( gbPanel0 );

        tbpTabbedPane0 = new JTabbedPane( );

        pnAdd = new JPanel();
        pnAdd.setBackground( new Color( 255,255,255 ) );
        GridBagLayout gbAdd = new GridBagLayout();
        GridBagConstraints gbcAdd = new GridBagConstraints();
        pnAdd.setLayout( gbAdd );

        pnPanel13 = new JPanel();
        GridBagLayout gbPanel13 = new GridBagLayout();
        GridBagConstraints gbcPanel13 = new GridBagConstraints();
        pnPanel13.setLayout( gbPanel13 );

        btSelectFile = new JButton( "Select File"  );
        gbcPanel13.gridx = 2;
        gbcPanel13.gridy = 2;
        gbcPanel13.gridwidth = 1;
        gbcPanel13.gridheight = 1;
        gbcPanel13.fill = GridBagConstraints.BOTH;
        gbcPanel13.weightx = 1;
        gbcPanel13.weighty = 0;
        gbcPanel13.anchor = GridBagConstraints.NORTH;
        gbPanel13.setConstraints( btSelectFile, gbcPanel13 );
        pnPanel13.add( btSelectFile );

        lbImage = new JLabel( ""  );
        gbcPanel13.gridx = 2;
        gbcPanel13.gridy = 3;
        gbcPanel13.gridwidth = 1;
        gbcPanel13.gridheight = 3;
        gbcPanel13.fill = GridBagConstraints.BOTH;
        gbcPanel13.weightx = 1;
        gbcPanel13.weighty = 1;
        gbcPanel13.anchor = GridBagConstraints.NORTH;
        gbPanel13.setConstraints( lbImage, gbcPanel13 );
        pnPanel13.add( lbImage );

        lbInput = new JLabel( "Charatcter to add"  );
        gbcPanel13.gridx = 7;
        gbcPanel13.gridy = 4;
        gbcPanel13.gridwidth = 2;
        gbcPanel13.gridheight = 1;
        gbcPanel13.fill = GridBagConstraints.VERTICAL;
        gbcPanel13.weightx = 1;
        gbcPanel13.weighty = 1;
        gbcPanel13.anchor = GridBagConstraints.NORTH;
        gbPanel13.setConstraints( lbInput, gbcPanel13 );
        pnPanel13.add( lbInput );

        tfInputText = new JTextField( );
        gbcPanel13.gridx = 7;
        gbcPanel13.gridy = 5;
        gbcPanel13.gridwidth = 1;
        gbcPanel13.gridheight = 1;
        gbcPanel13.fill = GridBagConstraints.BOTH;
        gbcPanel13.weightx = 1;
        gbcPanel13.weighty = 0;
        gbcPanel13.anchor = GridBagConstraints.NORTH;
        gbPanel13.setConstraints( tfInputText, gbcPanel13 );
        pnPanel13.add( tfInputText );

        btInputAdd = new JButton( "Add"  );
        gbcPanel13.gridx = 8;
        gbcPanel13.gridy = 5;
        gbcPanel13.gridwidth = 1;
        gbcPanel13.gridheight = 1;
        gbcPanel13.fill = GridBagConstraints.BOTH;
        gbcPanel13.weightx = 1;
        gbcPanel13.weighty = 0;
        gbcPanel13.anchor = GridBagConstraints.NORTH;
        gbPanel13.setConstraints( btInputAdd, gbcPanel13 );
        pnPanel13.add( btInputAdd );
        gbcAdd.gridx = 0;
        gbcAdd.gridy = 0;
        gbcAdd.gridwidth = 28;
        gbcAdd.gridheight = 13;
        gbcAdd.fill = GridBagConstraints.BOTH;
        gbcAdd.weightx = 1;
        gbcAdd.weighty = 0;
        gbcAdd.anchor = GridBagConstraints.NORTH;
        gbAdd.setConstraints( pnPanel13, gbcAdd );
        pnAdd.add( pnPanel13 );
        tbpTabbedPane0.addTab("Add",pnAdd);

        pnCharRecongnitionTab = new JPanel();
        GridBagLayout gbCharRecongnitionTab = new GridBagLayout();
        GridBagConstraints gbcCharRecongnitionTab = new GridBagConstraints();
        pnCharRecongnitionTab.setLayout( gbCharRecongnitionTab );
        tbpTabbedPane0.addTab("Char recognition",pnCharRecongnitionTab);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( tbpTabbedPane0, gbcPanel0 );
        pnPanel0.add( tbpTabbedPane0 );
        // --------------------------
    }

    private Component getTabRecognition() {
        return null;
    }

    private Component getTabAdd() {
        return null;
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
