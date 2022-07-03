package com;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class CreateEmployee {

    public void add_employee_to_database(String username, String password, String name, String gender, int age, String job, String phone_number, String email){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, password);
            preparedStmt.setString(4,gender);
            preparedStmt.setInt(5, age);
            preparedStmt.setString(6, job);
            preparedStmt.setString(7, email);
            preparedStmt.setString(8, phone_number);
            File empty_pic = new File("EmptyProfilePic.png");
            FileInputStream profile_file = new FileInputStream(empty_pic);
            preparedStmt.setBlob(9, profile_file);
            preparedStmt.execute();
            String sql_1 = "select * from attendance";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql_1);
            String sql_2 = "UPDATE attendance SET attendances = ? WHERE dates = ?";
            PreparedStatement preparedStatement1 = con.prepareStatement(sql_2);
            while (rs.next()){
                String update = rs.getString(2)+","+username+": P";
                preparedStatement1.setString(1, update);
                preparedStatement1.setString(2, rs.getString(1));
            }
            preparedStatement1.execute();
            con.close();
            new MemberAdded();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
