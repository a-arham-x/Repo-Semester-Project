package com;

import javax.swing.*;
import java.sql.*;
import java.io.*;

public class AdminProfilePic {
    private Blob admin_profile_pic;
    private ImageIcon admin_prof;
    AdminProfilePic(){
        fetch_admin_profile();
    }

    public void fetch_admin_profile(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from admin");
            while (rs.next()){
                setAdmin_profile_pic(rs.getBlob(3));
            }
            admin_prof = new ImageIcon(getAdmin_profile_pic().getBytes(1l, (int)getAdmin_profile_pic().length()));
            con.close();
        }catch(Exception e){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
                String update = "UPDATE admin SET profile_pic = ? WHERE name = ?";
                AdminCredentials adminCredentials = new AdminCredentials();
                File theFile = new File("EmptyProfilePic.png");
                FileInputStream empty_profile = new FileInputStream(theFile);
                PreparedStatement preparedstmt2 = con.prepareStatement(update);
                preparedstmt2.setBlob(1, empty_profile);
                preparedstmt2.setString(2, adminCredentials.getAdmin_name());
                preparedstmt2.executeUpdate();
                con.close();
                new AdminProfilePic();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }

//        try{
//            admin_prof = new ImageIcon(getAdmin_profile_pic().getBytes(1l, (int)getAdmin_profile_pic().length()));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }



    public void setAdmin_profile_pic(Blob admin_profile_pic) {
        this.admin_profile_pic = admin_profile_pic;
    }

    public Blob getAdmin_profile_pic() {
        return admin_profile_pic;
    }

    public ImageIcon getAdmin_prof() {
        return admin_prof;
    }

    public static void main(String[] args) {
        new AdminProfilePic();
    }
}
