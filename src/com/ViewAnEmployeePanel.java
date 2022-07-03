package com;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class ViewAnEmployeePanel extends JPanel{
    private Image profile_pic;
    private String username;
    private String name;
    private String age;
    private String job;
    private String phone_number;
    private String email;

    ViewAnEmployeePanel(){
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);
        this.setBounds(160, 70, 650, 470);
    }

    public void get_employee(String username_){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from employees");
            while (rs.next()){
                if (rs.getString(1).equals(username_)){
                    username= rs.getString(1);
                    name = rs.getString(2);
                    age = String.valueOf(rs.getInt(5));
                    job = rs.getString(6);
                    email = rs.getString(7);
                    phone_number = rs.getString(8);
                    ImageIcon prof = new ImageIcon(rs.getBlob(9).getBytes(1l, (int)rs.getBlob(9).length()));
                    profile_pic = prof.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                }
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawImage(profile_pic, 10, 10, null);
        g2d.drawString("Name: "+name, 10, 230);
        g2d.drawString("Username: "+username, 10, 260);
        g2d.drawString("Age: "+age, 10, 290);
        g2d.drawString("Job: "+job, 10, 320);
        g2d.drawString("Email Address: "+email, 10, 350);
        g2d.drawString("Phone Number: "+phone_number, 10, 380);
        repaint();
    }
}
