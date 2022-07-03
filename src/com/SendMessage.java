package com;

import java.sql.*;

public class SendMessage {
    public void send_message(String to, String msg){
        try{
            boolean user_exist = false;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            while (rs.next()){
                if (rs.getString(1).equals(to)){
                    user_exist = true;
                }
            }
            if (user_exist){
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO messages VALUES (?, ?)");
                preparedStatement.setString(1, msg);
                preparedStatement.setString(2, to);
                preparedStatement.execute();
                new DateAddedFrame("Message Delivered");
            }else{
                ResultSet rs1 = stm.executeQuery("select * from employees");
                while (rs1.next()){
                    if (rs1.getString(1).equals(to)){
                        user_exist = true;
                    }
                }
                if (user_exist){
                    PreparedStatement preparedStatement1 = con.prepareStatement("INSERT INTO messages VALUES (?, ?)");
                    preparedStatement1.setString(1, msg);
                    preparedStatement1.setString(2, to);
                    preparedStatement1.execute();
                    new DateAddedFrame("Message Delivered");
                }else{
                    new UserNotExist();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
