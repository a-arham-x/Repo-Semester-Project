package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchTheMember {
    private String username;
    public void search(String username_input){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            boolean user_found = false;
            while (rs.next()){
                if(rs.getString(1).equals(username_input)){
                    username = username_input;
                    user_found = true;
                }
            }
            con.close();
            if (!user_found){
                new UserNotExist();
            }else{

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
