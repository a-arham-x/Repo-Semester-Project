package com;

import java.sql.*;
import java.io.*;

public class CreateMember {
    String name;
    String username;
    String password;
    String gender;
    int age;
    String phone_number;
    String email_address;
    CreateMember(String name, String username, String password, String gender, int age, String phone_number, String email_address){
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.phone_number = phone_number;
        this.email_address = email_address;
    }

    public void add_member_to_database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String sql = "INSERT INTO members VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, password);
            preparedStmt.setString(3, name);
            preparedStmt.setInt(4, age);
            File empty_pic = new File("EmptyProfilePic.png");
            FileInputStream profile_file = new FileInputStream(empty_pic);
            preparedStmt.setBlob(5, profile_file);
            int i=6;
            while(i<22){
                preparedStmt.setString(i, "");
                i += 1;
            }
            preparedStmt.setString(22,gender);
            preparedStmt.setString(23, email_address);
            preparedStmt.setString(24, phone_number);
            preparedStmt.execute();
            con.close();
            new MemberAdded();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
