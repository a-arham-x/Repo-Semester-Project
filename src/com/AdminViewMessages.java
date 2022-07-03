package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminViewMessages extends JPanel implements ActionListener{
    private ArrayList<String> messages_list;
    private ArrayList<String> users_list;
    int list_length=0;
    int y = 70;
    Timer timer;
    AdminViewMessages(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        this.fetch_messages();

        timer = new Timer(20, null);
        timer.start();

    }

    public void fetch_messages(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from messages");
            messages_list = new ArrayList<>();
            users_list = new ArrayList<>();
            while (rs.next()){
                messages_list.add(rs.getString(1));
                users_list.add(rs.getString(2));
                list_length += 1;
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
        if (list_length==0){
            g2d.setFont(new Font("Arial", Font.BOLD, 40));
            g2d.drawString("No Messages Sent Yet", 50, y+30);
        }
        else{
            int add_in_y = 0;
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            for (int i=list_length-1; i>-1; i--){
                g2d.drawString("To "+users_list.get(i)+": "+messages_list.get(i), 50, y+add_in_y);
                add_in_y += 30;
            }
            add_in_y = 0;
        }
    }

    public void scroll_up(){
        if (y<70+30*list_length){
            y += 30;
            repaint();
        }
    }

    public void scroll_down(){
        if (y>30){
            y -= 30;
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
