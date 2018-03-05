package com.aiproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;

public class FileFinder {

    public FileFinder() {
        JButton button = new JButton("Choisir");
        JTextField field1 = new JTextField("Mon PDF");
        JTextField field2 = new JTextField("C:\\");
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Nom du fichier (.pdf):"));
        panel.add(field1);
        panel.add(new JLabel("Dossier de destination :"));
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                String tmp = field2.getText();
                chooser.setCurrentDirectory(new java.io.File(field2.getText()));
                chooser.setDialogTitle("Select image file");
                //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    field2.setText(chooser.getSelectedFile().getAbsolutePath());
                } else {
                    field2.setText(tmp);
                }
            }
        });
        field2.setColumns(2);
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Dossier de fusion", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(field1.getText() + "\\" + field2.getText());
            //destFile = field2.getText() + "\\" + field1.getText();
            //System.out.println(destFile + ".pdf");
            //try {
            //    MergePdf.Merge(fileList, destFile + ".pdf");
            //    PDFEdit.Edit(destFile);
            //} catch (Exception e1) {
            //    e1.printStackTrace();
            //}
        } else {
            System.out.println("Cancelled");
        }
    }
    public static File[] find (String path) {
        File dir = new File(path);
        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".pdf");
            }
        } );
    }
}