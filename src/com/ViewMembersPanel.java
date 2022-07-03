package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewMembersPanel extends JPanel implements ActionListener{
    Timer vmp_timer;
    int vmp_x = 20;
    int vmp_y = 25;
    int num_of_members;
    ArrayList<Image> profile_pics;
    ArrayList<String> names;
    ArrayList<String> usernames;
    ArrayList<String> ages;
    ArrayList<String> books_issued;
    ViewMembersPanel(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        this.get_members();

        vmp_timer = new Timer(20, this);
        vmp_timer.start();
    }

    public void get_members(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            profile_pics = new ArrayList<>();
            names = new ArrayList<>();
            usernames = new ArrayList<>();
            ages = new ArrayList<>();
            books_issued = new ArrayList<>();
            ResultSet rs = stm.executeQuery("select * from members");
            while (rs.next()){
                ImageIcon member_prof = new ImageIcon(rs.getBlob(5).getBytes(1l, (int)rs.getBlob(5).length()));
                Image prof = member_prof.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                profile_pics.add(prof);
                names.add(rs.getString(3));
                usernames.add(rs.getString(1));
                ages.add(String.valueOf((rs.getInt(4))));
                books_issued.add(rs.getString(17)+"\n"+rs.getString(19)+"\n"+rs.getString(21)+"\n");
                num_of_members += 1;
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
        g2d.drawString("Name", vmp_x+100, vmp_y);
        g2d.drawString("Username", vmp_x+500, vmp_y);
        g2d.drawString("Age", vmp_x+900, vmp_y);
        g2d.drawString("Books Issued", vmp_x+1100, vmp_y);
        int add_in_vmp_y = 100;
        for (int i=0; i<num_of_members; i++){
            g2d.drawImage(profile_pics.get(i), vmp_x, vmp_y+add_in_vmp_y-20, null);
            g2d.drawString(names.get(i), vmp_x+100, vmp_y+add_in_vmp_y);
            g2d.drawString(usernames.get(i), vmp_x+500, vmp_y+add_in_vmp_y);
            g2d.drawString(ages.get(i), vmp_x+900, vmp_y+add_in_vmp_y);
            String alpha = "";
                for (int j=0; j<books_issued.get(i).length(); j++){
                    try{
                        if (alpha.equals("\n")){
                            g2d.drawString(alpha, vmp_x+1100, vmp_y+add_in_vmp_y);
                            add_in_vmp_y += 30;
                        }else{
                            alpha += books_issued.get(i).charAt(j);
                        }
                    }catch(Exception e){
                        g2d.drawString("", vmp_x+1100, vmp_y+add_in_vmp_y);
                    }
                }
            add_in_vmp_y += 100;
        }
        add_in_vmp_y = 100;
        repaint();
    }

    public void scroll_right(){
        if (vmp_x>-1100){
            vmp_x -= 20;
            repaint();
        }
    }

    public void scroll_left(){
        if (vmp_x<20){
            vmp_x += 20;
            repaint();
        }
    }

    public void scroll_up(){
        if (vmp_y<25){
            vmp_y += 20;
            repaint();
        }
    }

    public void scroll_down(){
        if (vmp_y>-200-num_of_members*60){
            vmp_y -= 100;
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
