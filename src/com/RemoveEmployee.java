package com;

import java.sql.*;

public class RemoveEmployee {
    private String username;
    RemoveEmployee(String username){
        this.setUsername(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void remove_employee(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String sql = "DELETE FROM employees WHERE username = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            String sql_2 = "select * from attendance";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql_2);
            String sql_3 = "UPDATE attendance SET attendances = ? WHERE dates = ?";
            PreparedStatement preparedStatement1 = con.prepareStatement(sql_3);
            while (rs.next()){
                String update="";
                if (rs.getString(2).contains(","+username+": P")){
                    update = rs.getString(2).replace(","+username+": P", "");
                }else if (rs.getString(2).contains(","+username+": A")){
                    update = rs.getString(2).replace(","+username+": A", "");
                }
                preparedStatement1.setString(1, update);
                preparedStatement1.setString(2, rs.getString(1));
            }
            preparedStatement1.execute();
            con.close();
            new UserRemoved();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
