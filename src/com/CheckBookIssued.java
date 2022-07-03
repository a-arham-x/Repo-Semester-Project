package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckBookIssued {

    public void check_book_issued(int isbn){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            boolean book_not_issued = false;
            while (rs.next()){
                if (rs.getInt(1)==isbn){
                    if (rs.getString(8).equals("No One")){
                        book_not_issued = true;
                    }
                }
            }
            if (book_not_issued){
                new IssueBook(isbn);
            }else{
                new DateAddedFrame("Book is already Issued.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
