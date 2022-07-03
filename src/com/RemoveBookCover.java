package com;

import java.io.FileInputStream;
import java.sql.*;

public class RemoveBookCover {
    private int isbn;
    RemoveBookCover(int isbn){
        this.setIsbn(isbn);
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void remove_cover(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE books SET cover = ? WHERE isbn = ?");
            FileInputStream fileInputStream = new FileInputStream("grey.png");
            preparedStatement.setBlob(1, fileInputStream);
            preparedStatement.setInt(2, isbn);
            preparedStatement.execute();
            con.close();
            new DateAddedFrame("Cover Removed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
