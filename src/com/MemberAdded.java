package com;

import javax.swing.*;
import java.awt.*;

public class MemberAdded extends JFrame{
    JLabel member_added;
    MemberAdded(){
        this.setSize(250, 70);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        member_added = new JLabel("Account Created");
        member_added.setBounds(30, 5, 190, 20);
        member_added.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(member_added);

        this.setVisible(true);
    }
}
