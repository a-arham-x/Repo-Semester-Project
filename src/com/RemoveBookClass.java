package com;

import java.sql.*;

public class RemoveBookClass {
    private String isbn;
    RemoveBookClass(String isbn){
        this.setIsbn(isbn);
    }

    public void check_book_in_database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            boolean book_in_db = false;
            while (rs.next()){
                if (String.valueOf(rs.getInt(1)).equals(isbn)){
                    book_in_db = true;
                }
            }
            if (book_in_db){
                new ConfirmBookRemoval(isbn);
            }else{
                new DateAddedFrame("No Book With this ISBN Present");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
