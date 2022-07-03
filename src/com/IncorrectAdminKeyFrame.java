package com;

import javax.swing.*;
import java.awt.*;

public class IncorrectAdminKeyFrame extends JFrame{
    JLabel incorrect_admin_key;
    IncorrectAdminKeyFrame(){
        this.setSize(250, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        incorrect_admin_key = new JLabel("Incorrect Admin Key");
        incorrect_admin_key.setBounds(30, 5, 190, 20);
        incorrect_admin_key.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(incorrect_admin_key);

        this.setVisible(true);
    }
}
