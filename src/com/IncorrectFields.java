package com;

import javax.swing.*;
import java.awt.*;

public class IncorrectFields extends JFrame{
    JLabel incorrect_fields;
    IncorrectFields(){
        this.setSize(500, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        incorrect_fields = new JLabel("One of the required fields is incorrect.");
        incorrect_fields.setBounds(30, 5, 500, 20);
        incorrect_fields.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(incorrect_fields);

        this.setVisible(true);
    }
}
