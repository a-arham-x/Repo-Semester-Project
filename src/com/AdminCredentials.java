package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminCredentials {
    private String admin_key;
    private String admin_name;
    AdminCredentials(){
        fetch_key_name_from_database();
    }

    public void setAdmin_key(String admin_key) {
        this.admin_key = admin_key;
    }

    public String getAdmin_key() {
        return admin_key;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void fetch_key_name_from_database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from admin");
            while (rs.next()){
                setAdmin_name(rs.getString(1));
                setAdmin_key(rs.getString(2));
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
