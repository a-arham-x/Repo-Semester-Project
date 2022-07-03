package com;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewAMemberPanel extends JPanel{
    private Image profile_pic;
    private String username;
    private String name;
    private String age;
    private String phone_number;
    private String email;
    private String book_issued_1;
    private String book_issued_2;
    private String book_issued_3;
    ViewAMemberPanel(){
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);
        this.setBounds(160, 70, 650, 470);
    }

    public void getMember(String username_){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            while (rs.next()){
                if(rs.getString(1).equals(username_)){
                    username= rs.getString(1);
                    name = rs.getString(3);
                    age = String.valueOf(rs.getInt(4));
                    email = rs.getString(23);
                    phone_number = rs.getString(24);
                    ImageIcon prof = new ImageIcon(rs.getBlob(5).getBytes(1l, (int)rs.getBlob(5).length()));
                    profile_pic = prof.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                    book_issued_1 = rs.getString(17);
                    book_issued_2 = rs.getString(19);
                    book_issued_3 = rs.getString(21);
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
        g2d.drawString("Email Address: "+email, 10, 320);
        g2d.drawString("Phone Number: "+phone_number, 10, 350);
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
        if (book_issued_1.length()>0){
            if (book_issued_2.length()>0){
                if (book_issued_3.length()>0){
                    g2d.drawString("This Member has currently issued "+book_issued_1+", "+book_issued_2+" and "+book_issued_3+".", 10, 380);
                }else{
                    g2d.drawString("This Member has currently issued "+book_issued_1+" and "+book_issued_2+".", 10, 380);
                }
            }else{
                g2d.drawString("This Member has issued "+book_issued_1+".", 10, 380);
            }
        }else{
            g2d.drawString("This Member has currently issued no book.", 10, 380);
        }
        repaint();
    }
}


