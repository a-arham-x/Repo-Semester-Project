package com;

import javax.swing.*;
import java.awt.*;

public class IncorrectNameLength extends JFrame{
    JLabel incorrect_name_length;
    IncorrectNameLength(){
        this.setSize(500, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        incorrect_name_length = new JLabel("Name must be greater than 3 characters");
        incorrect_name_length.setBounds(30, 5, 500, 20);
        incorrect_name_length.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(incorrect_name_length);

        this.setVisible(true);
    }
}
