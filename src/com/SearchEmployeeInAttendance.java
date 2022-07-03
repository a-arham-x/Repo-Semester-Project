package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEmployeeInAttendance {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String search_employee_in_attendance(String employee_name){
        boolean employee_exists = false;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String sql = "select * from employees";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                if (rs.getString(1).equals(employee_name)){
                    employee_exists = true;
                    this.setUsername(rs.getString(1));
                }else if (rs.getString(2).equals(employee_name)){
                    employee_exists = true;
                    this.setUsername(rs.getString(1));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (employee_exists){
            return this.getUsername();
        }else{
            return "No such User";
        }
    }

}
