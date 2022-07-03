package com;

import javax.swing.*;
import java.awt.*;

public class IncorrectKeyLength extends JFrame{
    JLabel incorrect_key_length;
    IncorrectKeyLength(){
        this.setSize(500, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        incorrect_key_length = new JLabel("Key must be between 4 to 12 characters");
        incorrect_key_length.setBounds(30, 5, 500, 20);
        incorrect_key_length.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(incorrect_key_length);

        this.setVisible(true);
    }
}
