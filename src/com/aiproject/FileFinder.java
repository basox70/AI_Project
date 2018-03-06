package com.aiproject;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;

public class FileFinder {

    public String FileFinder(){
        return FileFinder("C:\\");
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
                FileNameExtensionFilter image = new FileNameExtensionFilter("Image", new String[]{"jpg", "png", "jpeg"});
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
        } else {
            System.out.println("Cancelled");
        }
        return field2.getText();
    }
}