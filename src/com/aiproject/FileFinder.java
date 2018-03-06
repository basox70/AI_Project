package com.aiproject;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;

public class FileFinder {

    public String FileFinder(){
        return FileFinder("c:\\");

    }

    public String FileFinder(String path) {
        JButton button = new JButton("Choose");
        JTextField field2 = new JTextField(path);
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Image file:"));
        panel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                String tmp;
                tmp = field2.getText();
                chooser.setCurrentDirectory(new java.io.File(field2.getText()));
                chooser.setDialogTitle("Select image file");
                FileNameExtensionFilter image =  new FileNameExtensionFilter("Image", new String[] {"jpg", "png", "jpeg"});
                chooser.addChoosableFileFilter(image);
                chooser.setAcceptAllFileFilterUsed(true);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    field2.setText(chooser.getSelectedFile().getAbsolutePath());
                } else {
                    field2.setText(tmp);
                }
            }
        });
        field2.setColumns(2);
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Select image file", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(field2.getText());
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
        return field2.getText();
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