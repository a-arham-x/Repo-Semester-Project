package com;

import javax.swing.*;
import java.awt.*;

public class IncorrectPassword extends JFrame{
    JLabel incorrect_password;
    IncorrectPassword(){
        this.setSize(500, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        incorrect_password = new JLabel("Incorrect Password");
        incorrect_password.setBounds(150, 5, 500, 20);
        incorrect_password.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(incorrect_password);

        this.setVisible(true);
    }
}
