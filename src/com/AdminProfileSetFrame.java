package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminProfileSetFrame extends JFrame implements MouseListener{
    JLabel update_admin_profile;
    JLabel remove_admin_profile;
    AdminProfileSetFrame(){
        this.setSize(400, 200);
        this.addMouseListener(this);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(245, 222, 179));

        update_admin_profile = new JLabel("Update Profile");
        update_admin_profile.setFont(new Font("Arial", Font.BOLD, 30));
        update_admin_profile.setBounds(5, 10, 400, 50);
        this.add(update_admin_profile);

        remove_admin_profile = new JLabel("Remove Profile");
        remove_admin_profile.setFont(new Font("Arial", Font.BOLD, 30));
        remove_admin_profile.setBounds(5, 80, 400, 50);
        this.add(remove_admin_profile);

        this.setVisible(true);
    }
    public void mousePressed(MouseEvent e){
        if (e.getX()>5 && e.getX()<200){
            if (e.getY()>10 && e.getY()<60){
                new UpdateAdminProfilePic();
            }if (e.getY()>110 && e.getY()<160){
                new RemoveAdminProfilePic();
            }
        }
    }
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
}
