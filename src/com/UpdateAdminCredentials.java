package com;

import java.sql.*;

public class UpdateAdminCredentials {
    String name;
    String key;
    String new_key;
    AdminCredentials adminCredentials;
    UpdateAdminCredentials(String name, String key, String new_key){
        this.name = name;
        this.key = key;
        this.new_key = new_key;
        adminCredentials = new AdminCredentials();
        setNewCredentials();
    }

    public void setNewCredentials(){
            if (key.equals(adminCredentials.getAdmin_key())){
                if (name.length()>=4) {
                    if (new_key.length()>=4 && new_key.length()<=12) {
                        update_admin_name();
                    }else{
                        new IncorrectKeyLength();
                    }
                }else{
                    new IncorrectNameLength();
                }
            }else{
                new IncorrectAdminKeyFrame();
            }

    }
    public void update_admin_name(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String update = "UPDATE admin SET name = ? WHERE admin_key = ?";
            PreparedStatement preparedstmt2 = con.prepareStatement(update);
            preparedstmt2.setString(1, name);
            preparedstmt2.setString(2, adminCredentials.getAdmin_key());
            preparedstmt2.executeUpdate();
            con.close();
            update_admin_key(name);
        }catch(Exception e){
            System.out.println();
        }
    }
    public void update_admin_key(String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String update = "UPDATE admin SET admin_key = ? WHERE name = ?";
            PreparedStatement preparedstmt2 = con.prepareStatement(update);
            preparedstmt2.setString(1, new_key);
            preparedstmt2.setString(2, username);
            preparedstmt2.executeUpdate();
            con.close();
            new InfoUpdated();
        }catch(Exception e){
            System.out.println();
        }
    }

}
