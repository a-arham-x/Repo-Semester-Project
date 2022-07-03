package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmUserRemoval extends JFrame implements  ActionListener{
    JLabel confirm_user_removal_label;
    SmallButton confirm_user_removal_button;
    private String username;
    ConfirmUserRemoval(String username){

        this.setUsername(username);

        this.setSize(500, 150);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        confirm_user_removal_label = new JLabel("Confirm Account Deletion ?");
        confirm_user_removal_label.setBounds(150, 5, 500, 20);
        confirm_user_removal_label.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(confirm_user_removal_label);

        confirm_user_removal_button = new SmallButton("Confirm", 200, 60);
        confirm_user_removal_button.addActionListener(this);
        confirm_user_removal_button.setForeground(Color.white);
        confirm_user_removal_button.setFont(new Font("Arial", Font.BOLD, 10));
        confirm_user_removal_button.setBackground(new Color(148, 0, 211));
        this.add(confirm_user_removal_button);

        this.setVisible(true);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confirm_user_removal_button){
            RemoveMember removeMember = new RemoveMember();
            removeMember.remove_member(this.getUsername());
        }
    }
}
