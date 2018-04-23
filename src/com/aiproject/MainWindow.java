package com.aiproject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;

public class MainWindow extends JFrame {

    // TODO stocker les valeurs des poids dans la BDD pour chaque caractère
    // TODO Afficher l'image

    private static final long serialVersionUID = 1L;

    private JMenuItem About;
    private JPanel Add;
    private JButton AddInput;
    private JPanel CharRecognition;
    private JMenuItem Exit;
    private JMenu Help;
    private JTextField InputChar;
    private JButton InputFile;
    private JTextField InputFileName;
    private JPanel InputImage;
    private Canvas CanvasInputImage;
    private JLabel LabelInputChar;
    private JLabel LabelOutputChar;
    private JTextField OutputChar;
    private JButton RecognitionFile;
    private JTextField RecognitionFileName;
    private JPanel RecognitionImage;
    private Canvas CanvasRecognitionImage;
    private JButton RecognizeChar;
    private JMenuItem Settings;
    private JMenu File;
    private JMenuBar jMenuBar1;
    private JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem Reset_DB;
    private javax.swing.JMenu Options;

    /**
     * Creates new form mainWindow
     */
    public MainWindow() {
        this.setTitle("Character recognition");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(true);

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Add = new javax.swing.JPanel();
        InputFile = new javax.swing.JButton();
        InputFileName = new javax.swing.JTextField();
        InputImage = new javax.swing.JPanel();
        CanvasInputImage = new java.awt.Canvas();
        LabelInputChar = new javax.swing.JLabel();
        InputChar = new javax.swing.JTextField();
        AddInput = new javax.swing.JButton();
        CharRecognition = new javax.swing.JPanel();
        RecognitionFile = new javax.swing.JButton();
        RecognitionFileName = new javax.swing.JTextField();
        RecognitionImage = new javax.swing.JPanel();
        LabelOutputChar = new javax.swing.JLabel();
        OutputChar = new javax.swing.JTextField();
        RecognizeChar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Settings = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Options = new javax.swing.JMenu();
        Reset_DB = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InputFile.setText("Select image file");
        InputFile.setToolTipText("");
        InputFile.setPreferredSize(new java.awt.Dimension(120, 23));
        InputFile.setRequestFocusEnabled(false);
        InputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputFileActionPerformed(evt);
            }
        });

        InputFileName.setEditable(true);
        InputFileName.setToolTipText("");
        InputFileName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InputFileName.setFocusable(true);

        InputImage.setBackground(new java.awt.Color(255, 255, 255));
        InputImage.setPreferredSize(new java.awt.Dimension(110, 110));

        javax.swing.GroupLayout InputImageLayout = new javax.swing.GroupLayout(InputImage);
        InputImage.setLayout(InputImageLayout);
        InputImageLayout.setHorizontalGroup(
                InputImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 110, Short.MAX_VALUE)
        );
        InputImageLayout.setVerticalGroup(
                InputImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 110, Short.MAX_VALUE)
        );

        LabelInputChar.setText("Input char");

        AddInput.setText("Add");
        AddInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddLayout = new javax.swing.GroupLayout(Add);
        Add.setLayout(AddLayout);
        AddLayout.setHorizontalGroup(
                AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddLayout.createSequentialGroup()
                                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AddLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(InputFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(AddLayout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(InputFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(InputImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelInputChar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AddLayout.createSequentialGroup()
                                                .addComponent(InputChar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(AddInput)))
                                .addGap(93, 93, 93))
        );
        AddLayout.setVerticalGroup(
                AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AddLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelInputChar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AddInput))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addComponent(InputFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InputFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(InputImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))
        );

        jTabbedPane1.addTab("Add Char", Add);

        RecognitionFile.setText("Select image file");
        RecognitionFile.setToolTipText("");
        RecognitionFile.setPreferredSize(new java.awt.Dimension(120, 23));
        RecognitionFile.setRequestFocusEnabled(false);
        RecognitionFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecognitionFileActionPerformed(evt);
            }
        });

        RecognitionFileName.setEditable(true);
        RecognitionFileName.setToolTipText("");
        RecognitionFileName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RecognitionFileName.setFocusable(true);

        RecognitionImage.setBackground(new java.awt.Color(255, 255, 255));
        RecognitionImage.setPreferredSize(new java.awt.Dimension(110, 110));

        javax.swing.GroupLayout RecognitionImageLayout = new javax.swing.GroupLayout(RecognitionImage);
        RecognitionImage.setLayout(RecognitionImageLayout);
        RecognitionImageLayout.setHorizontalGroup(
                RecognitionImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        RecognitionImageLayout.setVerticalGroup(
                RecognitionImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 110, Short.MAX_VALUE)
        );

        LabelOutputChar.setText("Output char");

        OutputChar.setEditable(false);

        RecognizeChar.setText("Recognize");
        RecognizeChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecognizeCharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CharRecognitionLayout = new javax.swing.GroupLayout(CharRecognition);
        CharRecognition.setLayout(CharRecognitionLayout);
        CharRecognitionLayout.setHorizontalGroup(
                CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CharRecognitionLayout.createSequentialGroup()
                                .addGroup(CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(CharRecognitionLayout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(RecognitionImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(RecognitionFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(309, 309, 309))
                                        .addGroup(CharRecognitionLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(RecognitionFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelOutputChar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(CharRecognitionLayout.createSequentialGroup()
                                                .addComponent(OutputChar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(RecognizeChar)))
                                .addGap(93, 93, 93))
        );
        CharRecognitionLayout.setVerticalGroup(
                CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CharRecognitionLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addComponent(RecognitionFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(CharRecognitionLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(LabelOutputChar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(CharRecognitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(OutputChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(RecognizeChar))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CharRecognitionLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RecognitionFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                .addComponent(RecognitionImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(106, 106, 106))))
        );

        RecognizeChar.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Char Recognition", CharRecognition);

        File.setText("File");

        Settings.setText("Settings");
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });
        File.add(Settings);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Options.setText("Options");

        Reset_DB.setText("Reset DB");
        Reset_DB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reset_DBActionPerformed(evt);
            }
        });
        Options.add(Reset_DB);

        jMenuBar1.add(Options);

        Help.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void InputFileActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        String InFileName;
        InFileName = InputFileName.getText();
        chooser.setCurrentDirectory(new java.io.File(InputFileName.getText()));
        chooser.setDialogTitle("Select image file");
        FileNameExtensionFilter imageExt = new FileNameExtensionFilter("Image", new String[]{"jpg", "png", "jpeg"});
        chooser.addChoosableFileFilter(imageExt);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            InFileName = chooser.getSelectedFile().getAbsolutePath();
            InputFileName.setText(InFileName);
        } else {
            InputFileName.setText(InFileName);
        }

        System.out.println("InputFile: "+InFileName);
        //InputFileName.setText(InFileName);

        try {
            // https://www.developpez.net/forums/d865718/java/interfaces-graphiques-java/debuter/afficher-image-canvas/
            BufferedImage image = ImageIO.read(new File(InFileName));
            //Image image = tk.getImage(InFileName);
            CanvasInputImage.setSize(image.getWidth(),image.getHeight());
            System.out.println(image.getWidth());
            System.out.println(image.getHeight());
            System.out.println(CanvasInputImage.getSize());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void AddInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new AddChar(InputFileName.getText(), InputChar.getText());
    }

    private void RecognitionFileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        String ReconFileName;
        ReconFileName = RecognitionFileName.getText();
        chooser.setCurrentDirectory(new java.io.File(RecognitionFileName.getText()));
        chooser.setDialogTitle("Select image file");
        FileNameExtensionFilter imageExt = new FileNameExtensionFilter("Image", new String[]{"jpg", "png", "jpeg"});
        chooser.addChoosableFileFilter(imageExt);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ReconFileName = chooser.getSelectedFile().getAbsolutePath();
            RecognitionFileName.setText(ReconFileName);
        } else {
            RecognitionFileName.setText(ReconFileName);
        }

        System.out.println("OutFileName: "+ReconFileName);
    }

    private void RecognizeCharActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new Decode(RecognitionFileName.getText());
    }

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Reset_DBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";
        try {
            FileWriter dataFile = new FileWriter(fileName);
            dataFile.write("");
            dataFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        try {
            /*for (LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                System.out.println(info.getName());
            }*/
            for (LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /* Style :
                Metal
                Nimbus
                CDE/Motif
                Windows
                Windows Classic
                 */
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

}
