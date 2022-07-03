package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewEmployeesPanel extends JPanel implements  ActionListener{
    Timer vep_timer;
    int vep_x = 20;
    int vep_y = 25;
    int num_of_employees;
    ArrayList<Image> profile_pics;
    ArrayList<String> names;
    ArrayList<String> usernames;
    ArrayList<String> ages;
    ArrayList<String> jobs;
    ViewEmployeesPanel(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        this.get_employees();

        vep_timer = new Timer(20, this);
        vep_timer.start();
    }

    public void get_employees(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            profile_pics = new ArrayList<>();
            names = new ArrayList<>();
            usernames = new ArrayList<>();
            ages = new ArrayList<>();
            jobs = new ArrayList<>();
            ResultSet rs = stm.executeQuery("select * from employees");
            while (rs.next()){
                ImageIcon member_prof = new ImageIcon(rs.getBlob(9).getBytes(1l, (int)rs.getBlob(9).length()));
                Image prof = member_prof.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                profile_pics.add(prof);
                names.add(rs.getString(2));
                usernames.add(rs.getString(1));
                ages.add(String.valueOf((rs.getInt(5))));
                jobs.add(rs.getString(6));
                num_of_employees += 1;
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Name", vep_x+100, vep_y);
        g2d.drawString("Username", vep_x+500, vep_y);
        g2d.drawString("Age", vep_x+900, vep_y);
        g2d.drawString("Job", vep_x+1100, vep_y);
        int add_in_vep_y = 100;
        for (int i=0; i<num_of_employees; i++){
            g2d.drawImage(profile_pics.get(i), vep_x, vep_y+add_in_vep_y-20, null);
            g2d.drawString(names.get(i), vep_x+100, vep_y+add_in_vep_y);
            g2d.drawString(usernames.get(i), vep_x+500, vep_y+add_in_vep_y);
            g2d.drawString(ages.get(i), vep_x+900, vep_y+add_in_vep_y);
            g2d.drawString(jobs.get(i), vep_x+1100, vep_y+add_in_vep_y);
            add_in_vep_y += 100;
        }
        add_in_vep_y = 100;
        repaint();
    }

    public void scroll_right(){
        if (vep_x>-1100){
            vep_x -= 20;
            repaint();
        }
    }

    public void scroll_left(){
        if (vep_x<20){
            vep_x += 20;
            repaint();
        }
    }

    public void scroll_up(){
        if (vep_y<25){
            vep_y += 20;
            repaint();
        }
    }

    public void scroll_down(){
        if (vep_y>-200-num_of_employees*60){
            vep_y -= 100;
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

