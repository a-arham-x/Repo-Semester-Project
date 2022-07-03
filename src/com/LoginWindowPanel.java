package com;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginWindowPanel extends JPanel implements ActionListener{
    int x = 50;
    Timer timer;
    SmallLabel username_login_label;
    SmallLabel password_login_label;
    LoginWindowPanel(){
        this.setBounds(160, 120, 650, 470);
        this.setBackground(new Color(148, 0, 211));
        this.setLayout(null);

        username_login_label = new SmallLabel("Username", 280, 120);
        username_login_label.setForeground(Color.white);
        this.add(username_login_label);

        password_login_label = new SmallLabel("Password", 280, 220);
        password_login_label.setForeground(Color.white);
        this.add(password_login_label);

        timer = new Timer(13, this);
        timer.start();

    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        String part_1 = "Welcome to our Library Management System ";

        g2D.setFont(new Font("Arial", Font.BOLD, 60));
        g2D.setPaint(new Color(255, 255, 255));
        g2D.drawString(part_1, x, 80);
    }

    public void actionPerformed(ActionEvent e){
        x -= 1;
        repaint();
        if (x==-1300){
            x = 650;
        }
    }
}
