package com;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class AddBookToDatabase {
    private String name;
    private String isbn;
    private String author;
    private String publisher;
    private String genre;
    private String damage_level;

    AddBookToDatabase(String name, String isbn, String author, String publisher, String genre, String damage_level){
        this.setName(name);
        this.setIsbn(isbn);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setGenre(genre);
        this.setDamage_level(damage_level);
    }

    public void check_fields(){
        boolean fields_correct = true;
        String numbers = "0123456789";
        if (name.length()<1){
            fields_correct = false;
        }if (author.length()<1){
            fields_correct = false;
        }if (publisher.length()<1){
            fields_correct = false;
        }if (genre.length()<1){
            fields_correct = false;
        }
        for (int i=0; i<isbn.length(); i++){
            if (!numbers.contains(String.valueOf(isbn.charAt(i)))){
                fields_correct = false;
            }
        }
        for (int i=0; i<damage_level.length(); i++){
            if (!numbers.contains(String.valueOf(damage_level.charAt(i)))){
                fields_correct = false;
            }
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            while (rs.next()){
                if (fields_correct){
                    if (rs.getInt(1)==Integer.parseInt(isbn)){
                        fields_correct = false;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (fields_correct){
            add_book_to_database();
        }else{
            new IncorrectFields();
        }
    }

    public void add_book_to_database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?,?,?,?)");
            File file = new File("grey.png");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setInt(1, Integer.parseInt(isbn));
            preparedStatement.setString(2, name);
            preparedStatement.setBlob(3, fileInputStream);
            preparedStatement.setString(4, author);
            preparedStatement.setString(5, publisher);
            preparedStatement.setString(6, genre);
            preparedStatement.setInt(7, Integer.parseInt(damage_level));
            preparedStatement.setString(8, "No One");
            new DateAddedFrame("Book Added to Catalogue");
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setDamage_level(String damage_level) {
        this.damage_level = damage_level;
    }

    public String getDamage_level() {
        return damage_level;
    }
}
