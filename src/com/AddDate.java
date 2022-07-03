package com;

import javax.xml.transform.Result;
import java.sql.*;

public class AddDate{
    private String date;
    AddDate(String date){
        this.setDate(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void add_date(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String sql = "INSERT INTO attendance VALUES (?,?)";
            String sql_2 = "select * from employees";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql_2);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            String update="";
            while (rs.next()){
                update += ","+rs.getString(1)+": P";
            }
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, update);
            preparedStatement.execute();
            new DateAddedFrame("Date Added in the database");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
