package com;

import javax.swing.*;
import java.awt.*;

public class InfoUpdated extends JFrame{
    JLabel info_updated;
    InfoUpdated(){
        this.setSize(500, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        info_updated = new JLabel("Your Login Credentials have been updated");
        info_updated.setBounds(30, 5, 500, 20);
        info_updated.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(info_updated);

        this.setVisible(true);
    }
}
