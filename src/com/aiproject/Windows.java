package com.aiproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Windows extends javax.swing.JFrame {

    // TODO stocker les valeurs des poids dans la BDD pour chaque caractère
    // TODO Afficher l'image

    private static final long serialVersionUID = 1L;
    private String windowTitle = "Character recognition";
    private static String chooserDialogTitle = "Select file";
    private String noFileSelectedMessage = "No input file selected";

    private static File[] fileList;
    private String absolutePath;
    private String destFile;

    private JMenu Help;
    private JMenu Add;
    private JMenuItem Exit;
    private JMenuItem AddChar;
    private JMenuItem AddText;
    private JMenuItem OpenFile;
    private JMenuItem About;
    private JMenu File;
    private JMenuItem Settings;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane1;
    private JLabel imageContainer;

    /**
     * Creates new form mainWindow
     */
    public Windows() {
        initComponents();
        this.setTitle(windowTitle);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        imageContainer = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        OpenFile = new javax.swing.JMenuItem();
        Settings = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Add = new javax.swing.JMenu();
        AddChar = new javax.swing.JMenuItem();
        AddText = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        imageContainer.setSize(50,50);
        imageContainer.setText("Select file");
        imageContainer.setFocusable(false);
        // imageContainer.setMargin(new java.awt.Insets(0, 0, 0, 0));

        File.setText("File");

        OpenFile.setText("Open file");
        OpenFile.addActionListener(this::OpenFileActionPerformed);
        File.add(OpenFile);
        OpenFile.getAccessibleContext().setAccessibleDescription("");

        Settings.setText("Settings");

        // File.add(Settings);

        Exit.setText("Exit");
        Exit.addActionListener(this::ExitActionPerformed);
        File.add(Exit);

        jMenuBar1.add(File);

        Add.setText(" Add");

        AddChar.setText("Add char to DB");
        AddChar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // TODO make action
            }
        });

        AddText.setText("Ajouter du texte");
        AddText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });

        Add.add(AddChar);

        // Add.add(AddText);

        jMenuBar1.add(Add);

        Help.setText("Help");

        About.setText("About");
        About.addActionListener(this::ShowHelpActionPerformed);

        Help.add(About);

        jMenuBar1.add(Help);

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
            java.util.logging.Logger.getLogger(Windows.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Windows().setVisible(true);
            }
        });
    }

}
