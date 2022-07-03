package com;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TemporaryClass {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            File theFile = new File("EmptyProfilePic.png");
            FileInputStream empty_profile = new FileInputStream(theFile);
            String update = "UPDATE admin SET profile_pic = ? WHERE name = ?";
            PreparedStatement preparedstmt2 = con.prepareStatement(update);
            preparedstmt2.setBlob(1, empty_profile);
            preparedstmt2.setString(2, "Abdul Arham");
            preparedstmt2.executeUpdate();
            con.close();
            System.out.println("Work Done");
        }catch(Exception e){e.printStackTrace();}
    }
}
