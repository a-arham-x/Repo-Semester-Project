package com;

import java.sql.*;

public class RemoveMember {
    String table;
    public void check_password(String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            boolean username_correct = false;
            while(rs.next()){
                if (rs.getString(1).equals(username)){
                    username_correct = true;
                }
            }
            if (username_correct){
                new ConfirmUserRemoval(username);
            }else{
                new UserNotExist();
            }
            con.close();
        }catch(Exception e){
            System.out.println();
        }
    }

    public void remove_member(String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String del = "DELETE FROM members WHERE username=?";
            PreparedStatement preparedStmt1 = con.prepareStatement(del);
            preparedStmt1.setString(1, username);
            preparedStmt1.execute();
            con.close();
            new UserRemoved();
        }catch(Exception e){
            System.out.println();
        }
    }
}
