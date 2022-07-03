package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TemporaryClass2 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String sql = "UPDATE books SET issued_by = ? WHERE isbn = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "aarham@member.library");
            preparedStatement.setInt(2, 12345);
            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
