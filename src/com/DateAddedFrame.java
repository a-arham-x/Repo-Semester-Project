package com;

import javax.swing.*;
import java.awt.*;

public class DateAddedFrame extends JFrame{
    JLabel date_added;
    DateAddedFrame(String text){
        this.setSize(300, 100);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        date_added = new JLabel(text);
        date_added.setFont(new Font("Arial", Font.BOLD, 15));
        date_added.setBounds(30, 10, 240, 25);
        this.add(date_added);

        this.setVisible(true);
    }
}
