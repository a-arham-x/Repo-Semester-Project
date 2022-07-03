package com;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateBookCover implements BlobConverter{
    private int isbn;
    UpdateBookCover(int isbn){
        this.setIsbn(isbn);
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            convert_file_to_blob(file);
        }
    }

    @Override
    public void convert_file_to_blob(File file) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            String update = "UPDATE books SET cover = ? WHERE isbn = ?";
            FileInputStream new_cover = new FileInputStream(file);
            PreparedStatement preparedstmt2 = con.prepareStatement(update);
            preparedstmt2.setBlob(1, new_cover);
            preparedstmt2.setInt(2, isbn);
            preparedstmt2.executeUpdate();
            con.close();
            new DateAddedFrame("Book Cover Updated");
        }catch (Exception e){
            new IncorrectFileChosen();
        }
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }
}
