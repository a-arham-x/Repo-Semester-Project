package com;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckMemberFields implements UniqueUsername{
    public void check(String name, String username, String password, String gender, String age, String phone_number, String email_address){
        boolean name_check = false;
        boolean username_check = false;
        boolean password_check = false;
        boolean age_check = true;
        boolean phone_number_check = true;
        boolean email_check = false;
        String numbers = "0123456789";
        if (name.length()>2 && name.length()<21){
            for (int i=0; i<name.length(); i++){
                if (name.charAt(i)!='9'){
                    if (numbers.indexOf(name.charAt(i))==-1){
                        name_check = true;
                    }
                }
            }
        }
        if (username.length()>19 && username.length()<31){
            if (username.indexOf("@member.library")>4){
                username_check = unique_username(username);
            }
        }
        if (password.length()>7 && password.length()<17){
            password_check = true;
        }
        for (int i=0; i<age.length(); i++){
            if (age.charAt(i)!='9'){
                if (numbers.indexOf(age.charAt(i))==-1){
                    age_check = false;
                }
            }
        }
        if (age_check){
            if (Integer.parseInt(age)<10){
                age_check = false;
            }
        }
        for (int i=0; i<age.length(); i++){
            if (age.charAt(i)!='9'){
                if (numbers.indexOf(age.charAt(i))==-1){
                    phone_number_check = false;
                }
            }
        }
        if (phone_number_check){
            if (phone_number.length()!=11){
                phone_number_check = false;
            }
        }
        String ee1 = "@gmail.com";
        String ee2 = "@outlook.com";
        String ee3 = "@hotmail.com";
        String ee4 = "@yahoo.com";
        if (email_address.indexOf(ee1)>4 || email_address.indexOf(ee2)>4 || email_address.indexOf(ee3)>4 || email_address.indexOf(ee4)>4){
            email_check = true;
        }
        if (name_check && username_check && password_check && age_check && phone_number_check && email_check){
            CreateMember createMember = new CreateMember(name, username, password, gender, Integer.parseInt(age), phone_number, email_address);
            createMember.add_member_to_database();
        }else{
            new IncorrectFields();
        }
    }

    public boolean unique_username(String username){
        boolean username_is_unique = true;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            while(rs.next()){
                if (rs.getString(1).equals(username)){
                    username_is_unique = false;
                }
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return username_is_unique;
    }
}
