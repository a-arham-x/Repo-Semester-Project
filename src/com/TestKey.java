package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestKey extends JFrame implements KeyListener{
    ProjectTextfield projectTextfield;
    TestKey(){
        this.setSize(1000, 670);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.addKeyListener(this);
        projectTextfield=new ProjectTextfield(40, 50);
        this.add(projectTextfield);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestKey();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println("KLLL");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
