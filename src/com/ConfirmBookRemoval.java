package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConfirmBookRemoval extends JFrame implements  ActionListener{
    SmallLabel confirm_book_removal;
    EnlongedButton confirm_removal_button;
    private String isbn;
    ConfirmBookRemoval(String isbn){
        this.setSize(500, 200);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setIsbn(isbn);

        confirm_book_removal = new SmallLabel("Confirm Book Removal ?", 20, 20);
        confirm_book_removal.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(confirm_book_removal);

        confirm_removal_button = new EnlongedButton("Confirm", 175, 80);
        confirm_removal_button.addActionListener(this);
        this.add(confirm_removal_button);

        this.setVisible(true);
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void remove_book(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM books WHERE isbn = ?");
            preparedStatement.setInt(1, Integer.parseInt(isbn));
            preparedStatement.execute();
            new DateAddedFrame("Book Removed");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confirm_removal_button){
            remove_book();
        }
    }
}
