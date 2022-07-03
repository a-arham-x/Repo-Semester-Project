package com;

import java.sql.*;

public class ReturnBook {

    public void check_book_issued(int isbn){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            boolean book_issued = true;
            while (rs.next()){
                if (rs.getInt(1)==isbn){
                    if (rs.getString(8).equals("No One")){
                        book_issued = false;
                    }
                }
            }
            if (book_issued){
                return_book(isbn);
            }else{
                new DateAddedFrame("Book is not Issued By Anyone Yet");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void return_book(int isbn){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            String member = "";
            while (rs.next()){
                if (rs.getInt(1)==isbn){
                    member = rs.getString(8);
                }
            }
            String book_name = "";
            ResultSet rs1 = stm.executeQuery("select * from books");
            while (rs1.next()){
                if (rs1.getInt(1)==isbn){
                    book_name = rs1.getString(2);
                }
            }
            String update = "";
            String update_2 = "";
            ResultSet rs2 = stm.executeQuery("select * from members");
            while (rs2.next()){
                if (rs2.getString(1).equals(member)){
                    if (rs2.getString(16).equals(book_name)){
                        update = "UPDATE members SET book_issued_1 = ? WHERE username = ?";
                        update_2 = "UPDATE members SET book_issued_1_genre = ? WHERE username = ?";
                    }else{
                        if (rs2.getString(18).equals(book_name)){
                            update = "UPDATE members SET book_issued_2 = ? WHERE username = ?";
                            update_2 = "UPDATE members SET book_issued_2_genre = ? WHERE username = ?";
                        }else{
                            if (rs2.getString(20).equals(book_name)){
                                update = "UPDATE members SET book_issued_3 = ? WHERE username = ?";
                                update_2 = "UPDATE members SET book_issued_3_genre = ? WHERE username = ?";
                            }
                        }
                    }
                }
            }
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE books SET issued_by = ? WHERE isbn = ?");
            preparedStatement.setString(1, "No One");
            preparedStatement.setInt(2, isbn);
            preparedStatement.execute();
            PreparedStatement preparedStatement1 = con.prepareStatement(update);
            preparedStatement1.setString(1, "");
            preparedStatement1.setString(2, member);
            preparedStatement1.execute();
            PreparedStatement preparedStatement2 = con.prepareStatement(update_2);
            preparedStatement2.setString(1, "");
            preparedStatement2.setString(2, member);
            preparedStatement2.execute();
            con.close();
            new DateAddedFrame("The Book Has Been Returned");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
