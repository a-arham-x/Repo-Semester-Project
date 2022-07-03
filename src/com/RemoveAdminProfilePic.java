package com;

import javax.swing.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RemoveAdminProfilePic {
    RemoveAdminProfilePic(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String update = "UPDATE admin SET profile_pic = ? WHERE name = ?";
            AdminCredentials adminCredentials = new AdminCredentials();
            FileInputStream empty_profile = new FileInputStream("EmptyProfilePic.png");
            PreparedStatement preparedstmt2 = con.prepareStatement(update);
            preparedstmt2.setBlob(1, empty_profile);
            preparedstmt2.setString(2, adminCredentials.getAdmin_name());
            preparedstmt2.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println();;
        }
    }
}
