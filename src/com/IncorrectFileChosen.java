package com;
import javax.swing.*;
import java.awt.*;
public class IncorrectFileChosen extends JFrame{
    JLabel incorrect_file_chosen;
    IncorrectFileChosen(){
        this.setSize(600, 100);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        incorrect_file_chosen = new JLabel("The File you chose is either not available or is not supported.");
        incorrect_file_chosen.setBounds(5, 5, 550, 20);
        incorrect_file_chosen.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(incorrect_file_chosen);

        this.setVisible(true);
    }
}
