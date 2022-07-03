package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeAttendancePanel extends JPanel implements ActionListener{
    Timer eap_timer;
    int eap_y = 100;
    ArrayList<String> employees_attendance_list;
    int array_length;
    private String username;
    EmployeeAttendancePanel(String username){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        this.setUsername(username);

        this.get_employees();

        eap_timer = new Timer(20, this);
        eap_timer.start();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void get_employees(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            employees_attendance_list = new ArrayList<>();
            array_length = 0;
            ResultSet rs = stm.executeQuery("select * from attendance");
            while (rs.next()){
                String date = rs.getString(1);
                if (rs.getString(2).contains(","+username+": P")){
                    employees_attendance_list.add(date+"    "+"P");
                }else if (rs.getString(2).contains(","+username+": A")){
                    employees_attendance_list.add(date+"    "+"A");
                }
                array_length += 1;
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        //g2d.drawString("Hello World", 35, 100);
        int store_eap_y = eap_y;
        g2d.drawString(username+" Attendance", 25, eap_y);
        eap_y += 50;
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        for (int i=0; i<array_length; i++){
            g2d.drawString(employees_attendance_list.get(i), 25, eap_y);
            eap_y += 30;
        }
        //repaint();
        eap_y = store_eap_y;
    }

    public void scroll_up(){
        if (eap_y <100){
            eap_y += 20;
            repaint();
        }
    }

    public void scroll_down(){
        if (eap_y >-200-array_length*30){
            eap_y -= 20;
            System.out.println(eap_y);
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
