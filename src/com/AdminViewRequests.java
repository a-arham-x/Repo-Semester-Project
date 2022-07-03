package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminViewRequests extends JPanel implements ActionListener{
    private ArrayList<String> requests_list;
    private ArrayList<String> from_users;
    int requests_list_length=0;
    int y = 70;
    Timer timer;
    AdminViewRequests(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        this.fetch_requests();

        timer = new Timer(20, this);
        timer.start();
    }

    public void fetch_requests(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from requests");
            requests_list = new ArrayList<>();
            from_users = new ArrayList<>();
            while (rs.next()){
                requests_list.add(rs.getString(1));
                from_users.add(rs.getString(2));
                requests_list_length += 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (requests_list_length==0){
            g2d.setFont(new Font("Arial", Font.BOLD, 40));
            g2d.drawString("No Requests Made Yet", 50, y+30);
        }
        else{
            int add_in_y = 0;
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            for (int i=requests_list_length-1; i>-1; i--){
                g2d.drawString("From "+from_users.get(i)+": "+requests_list.get(i), 50, y+add_in_y);
                add_in_y += 30;
            }
            add_in_y = 0;
        }
    }

    public void scroll_up(){
        if (y<70+30*requests_list_length){
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
