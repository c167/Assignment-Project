package com.Project;

import java.io.*;
import java.util.Scanner;
import java.awt.Component;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.*;
import java.awt.event.*;


/**
 * This class mainly deals with the GUI elements and sending/recieving variables to work with.
 *
 * Author: Colin Doyle
 */
public class Control
{
    static boolean sentenceCheckerTick = false;
    static boolean shoutingCheckerTick = false;
    /** Declare these two variable as Global static variables
    so that way that can work with the inner eventHandler methods */ 
     
    public static void main(String [] args)
    {
        FileHandler p1 = new FileHandler();//Create object
        
        JFrame frame = new JFrame("Abusive text detector");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GroupLayout window = new GroupLayout(frame.getContentPane());
        frame.setLayout(window);
     
        JLabel label1 = new JLabel("Enter the full path directory to the .txt file: ");
        JTextField searchBar1 = new JTextField();
        JCheckBox sentenceCheck = new JCheckBox("Check sentence length");
        JCheckBox shoutingCheck = new JCheckBox("Check for shouting");
        JButton searchForFile = new JButton("Check for abusive content");
        
        searchForFile.addActionListener(new ActionListener() //methods for handling button inputs
        {
            public void actionPerformed(ActionEvent ae)
            {
                String fileName = searchBar1.getText();
                //If tickboxes arent clicked, then those associated modifiers wont be added since they arent true
                String foundCurseWord = p1.parser(fileName, sentenceCheckerTick, shoutingCheckerTick);
            }
        });

        
        sentenceCheck.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                sentenceCheckerTick = true;
            }
        });
        
        shoutingCheck.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                shoutingCheckerTick = true;
            }
        });

        /** GUI layout from https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
         and https://www.javacodex.com/Swing/GroupLayout */
         
        window.setAutoCreateGaps(true);
        window.setAutoCreateContainerGaps(true);
     
        window.setHorizontalGroup(window.createSequentialGroup()
            .addComponent(label1)
            .addGroup(window.createParallelGroup(LEADING)
                .addComponent(searchBar1)
                .addGroup(window.createSequentialGroup()
                    .addGroup(window.createParallelGroup(LEADING)
                        .addComponent(sentenceCheck))
                    .addGroup(window.createParallelGroup(LEADING)
                        .addComponent(shoutingCheck))))
            .addGroup(window.createParallelGroup(LEADING)
                .addComponent(searchForFile))
        );
     
        window.linkSize(SwingConstants.HORIZONTAL, searchForFile);
     
        window.setVerticalGroup(window.createSequentialGroup()
            .addGroup(window.createParallelGroup(BASELINE)
                .addComponent(label1)
                .addComponent(searchBar1)
                .addComponent(searchForFile))
            .addGroup(window.createParallelGroup(LEADING)
                .addGroup(window.createSequentialGroup()
                    .addGroup(window.createParallelGroup(BASELINE)
                        .addComponent(sentenceCheck)
                        .addComponent(shoutingCheck))
                    .addGroup(window.createParallelGroup(BASELINE))))
                
        );
     
        frame.pack();
        frame.show();
        
        
        
    }
}
