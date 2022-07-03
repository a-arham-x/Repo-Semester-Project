package com;

import javax.swing.*;
import java.awt.*;

public class UserNotExist extends JFrame{
    JLabel no_such_user;
    UserNotExist(){
        this.setSize(500, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        no_such_user = new JLabel("No User with this username found");
        no_such_user.setBounds(30, 5, 500, 20);
        no_such_user.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(no_such_user);

        this.setVisible(true);
    }
}
