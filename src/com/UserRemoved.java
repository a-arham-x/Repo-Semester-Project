package com;

import java.awt.*;
import javax.swing.*;

public class UserRemoved extends  JFrame{
    JLabel user_removed;
    UserRemoved(){
        this.setSize(500, 100);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        user_removed = new JLabel("User Account Deleted");
        user_removed.setBounds(120, 5, 500, 20);
        user_removed.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(user_removed);

        this.setVisible(true);
    }
}
