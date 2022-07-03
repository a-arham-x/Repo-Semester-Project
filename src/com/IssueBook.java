package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener{
    private int isbn;
    private String username;
    ProjectTextfield username_textfield;
    SmallLabel username_label;

    IssueBook(int isbn){
        this.setSize(400, 150);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        username_label = new SmallLabel("Enter Username", 50, 10);
        this.add(username_label);

        username_textfield = new ProjectTextfield(50, 50);
        username_textfield.addActionListener(this);
        this.add(username_textfield);

        this.setIsbn(isbn);


        this.setVisible(true);
    }

    public void check_user(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            boolean member_present = false;
            while (rs.next()){
                if (rs.getString(1).equals(username_textfield.getText())){
                    member_present = true;
                    this.setUsername(username_textfield.getText());
                }
            }
            if (member_present){
                issue_book();
            }else{
                new DateAddedFrame("No Such Member Present");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void issue_book(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            String book_name = "";
            String book_genre = "";
            while (rs.next()){
                if (rs.getInt(1)==isbn){
                    book_name = rs.getString(2);
                    book_genre = rs.getString(6);
                }
            }
            String update = "";
            String update_2 = "";
            ResultSet rs2 = stm.executeQuery("select * from members");
            boolean cannot_issue = false;
            while (rs2.next()){
                if (rs2.getString(1).equals(username)){
                    if (rs2.getString(16).length()==0){
                        update = "UPDATE members SET book_issued_1 = ? WHERE username = ?";
                        update_2 = "UPDATE members SET book_issued_1_genre = ? WHERE username = ?";
                    }else{
                        if (rs2.getString(18).length()==0){
                            update = "UPDATE members SET book_issued_2 = ? WHERE username = ?";
                            update_2 = "UPDATE members SET book_issued_2_genre = ? WHERE username = ?";
                        }else{
                            if (rs2.getString(20).length()==0){
                                update = "UPDATE members SET book_issued_3 = ? WHERE username = ?";
                                update_2 = "UPDATE members SET book_issued_3_genre = ? WHERE username = ?";
                            }else{
                                cannot_issue = true;
                            }
                        }
                    }
                }
            }
            if (!cannot_issue){
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE books SET issued_by = ? WHERE isbn = ?");
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, isbn);
                preparedStatement.execute();
                PreparedStatement preparedStatement2 = con.prepareStatement(update);
                preparedStatement2.setString(1, book_name);
                preparedStatement2.setString(2, username);
                preparedStatement2.execute();
                PreparedStatement preparedStatement3 = con.prepareStatement(update_2);
                preparedStatement3.setString(1, book_genre);
                preparedStatement3.setString(2, username);
                preparedStatement3.execute();
                new DateAddedFrame("The Book Has Been Issued.");
            }else{
                new DateAddedFrame("This member has Already issued 3 books.");
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        check_user();
    }
}
