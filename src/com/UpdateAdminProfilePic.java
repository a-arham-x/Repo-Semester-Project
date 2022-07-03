package com;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateAdminProfilePic implements BlobConverter{
    UpdateAdminProfilePic(){
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            convert_file_to_blob(file);
        }
    }

    public void convert_file_to_blob(File file){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String update = "UPDATE admin SET profile_pic = ? WHERE name = ?";
            AdminCredentials adminCredentials = new AdminCredentials();
            FileInputStream new_profile = new FileInputStream(file);
            PreparedStatement preparedstmt2 = con.prepareStatement(update);
            preparedstmt2.setBlob(1, new_profile);
            preparedstmt2.setString(2, adminCredentials.getAdmin_name());
            preparedstmt2.executeUpdate();
            con.close();
        }catch(Exception e){
            new IncorrectFileChosen();
        }
    }

}
