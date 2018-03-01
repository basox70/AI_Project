package com.aiproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AI_Project {
    private JPanel panel1;
    private JButton addButton;
    private JButton decodeButton;
    private JButton homeButton;

    public AI_Project(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "Add Button has been clicked");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("AI_Project");
        frame.setContentPane(new AI_Project().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
