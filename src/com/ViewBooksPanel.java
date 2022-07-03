package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewBooksPanel extends JPanel implements ActionListener, MouseListener{
    HashMap<String, Integer> book_map_isbn;
    HashMap<String, Integer> book_map_name;
    HashMap<String, Integer> book_map_author;
    int x = 30;
    ArrayList<Image> covers;
    ArrayList<String> names;
    ArrayList<String> isbns;
    ArrayList<String> authors;
    ArrayList<String> publishers;
    ArrayList<String> genres;
    ArrayList<String> damage_levels;
    ArrayList<String> issued_by;
    int list_length = 0;
    int on_seen=0;
    JLabel cover;
    JLabel name;
    JLabel isbn;
    JLabel author;
    JLabel publisher;
    JLabel genre;
    JLabel damage_level;
    JLabel is_issued_by;
    SearchButton search_book;
    JTextField search_book_textfield;
    ViewBooksPanel(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222,179));
        this.setLayout(null);
        this.addMouseListener(this);

        this.fetch_books();

        if (list_length==0){
            LargeLabel no_book = new LargeLabel("No Book Currently Available", 30, 240);
            this.add(no_book);
        }

        else{
            cover = new JLabel(new ImageIcon(covers.get(list_length-1)));
            cover.setBounds(30, 20, 120, 170);
            this.add(cover);

            name = new JLabel("Name: "+names.get(list_length-1));
            name.setFont(new Font("Arial", Font.BOLD, 20));
            name.setBounds(30, 220, 650, 25);
            this.add(name);

            isbn = new JLabel("ISBN Number: "+isbns.get(list_length-1));
            isbn.setFont(new Font("Arial", Font.BOLD, 20));
            isbn.setBounds(30, 250, 650, 25);
            this.add(isbn);

            author = new JLabel("Author: "+authors.get(list_length-1));
            author.setFont(new Font("Arial", Font.BOLD, 20));
            author.setBounds(30, 280, 650, 25);
            this.add(author);

            publisher = new JLabel("Publisher: "+publishers.get(list_length-1));
            publisher.setFont(new Font("Arial", Font.BOLD, 20));
            publisher.setBounds(30, 310, 650, 25);
            this.add(publisher);

            genre = new JLabel("Genre: "+genres.get(list_length-1));
            genre.setFont(new Font("Arial", Font.BOLD, 20));
            genre.setBounds(30, 340, 650, 25);
            this.add(genre);

            damage_level = new JLabel("Damage Level: "+damage_levels.get(list_length-1));
            damage_level.setFont(new Font("Arial", Font.BOLD, 20));
            damage_level.setBounds(30, 370, 650, 25);
            this.add(damage_level);

            is_issued_by = new JLabel("Issued By: "+issued_by.get(list_length-1));
            is_issued_by.setFont(new Font("Arial", Font.BOLD, 20));
            is_issued_by.setBounds(30, 400, 650, 25);
            this.add(is_issued_by);
        }

        search_book = new SearchButton(610, 0);
        this.add(search_book);

        search_book_textfield = new JTextField();
        search_book_textfield.setBounds(310, 0, 300, 40);
        search_book_textfield.setFont(new Font("Arial", Font.PLAIN, 20));
        search_book_textfield.addActionListener(this);
        this.add(search_book_textfield);

    }

    public void fetch_books(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from books");
            covers = new ArrayList<>();
            names = new ArrayList<>();
            isbns = new ArrayList<>();
            authors = new ArrayList<>();
            publishers = new ArrayList<>();
            genres = new ArrayList<>();
            damage_levels = new ArrayList<>();
            issued_by = new ArrayList<>();
            while (rs.next()){
                ImageIcon book_cover = new ImageIcon(rs.getBlob(3).getBytes(1l, (int)rs.getBlob(3).length()));
                Image cover = book_cover.getImage().getScaledInstance(120, 170, Image.SCALE_DEFAULT);
                covers.add(cover);
                names.add(rs.getString(2));
                isbns.add(String.valueOf(rs.getInt(1)));
                authors.add(rs.getString(4));
                publishers.add(rs.getString(5));
                genres.add(rs.getString(6));
                damage_levels.add(String.valueOf(rs.getInt(7)));
                issued_by.add(rs.getString(8));
                list_length += 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void scroll_right(){
        if (on_seen<list_length-1){
            on_seen += 1;
            shift(on_seen);
        }
    }

    public void scroll_left(){
        if (on_seen>0){
            on_seen -= 1;
            shift(on_seen);
        }
        repaint();
    }

    public void shift(int on_seen){
        cover.setIcon(new ImageIcon(covers.get(list_length-1-on_seen)));
        name.setText("Name: "+names.get(list_length-1-on_seen));
        isbn.setText("ISBN Number: "+isbns.get(list_length-1-on_seen));
        author.setText("Author: "+authors.get(list_length-1-on_seen));
        publisher.setText("Publisher: "+publishers.get(list_length-1-on_seen));
        genre.setText("Genre: "+genres.get(list_length-1-on_seen));
        damage_level.setText("Damage Level: "+damage_levels.get(list_length-1-on_seen));
        is_issued_by.setText("Issued By: "+issued_by.get(list_length-1-on_seen));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean book_found = false;
        for (int i=0; i<list_length; i++){
            if (isbns.get(i).equals(search_book_textfield.getText())){
                book_found = true;
                on_seen = list_length-1-i;
                break;
            }
        }
        if (!book_found){
            for (int i=0; i<list_length; i++){
                if (names.get(i).equals(search_book_textfield.getText())){
                    book_found = true;
                    on_seen = list_length-1-i;
                    break;
                }
            }
        }
        if (!book_found){
            for (int i=0; i<list_length; i++){
                if (authors.get(i).equals(search_book_textfield.getText())){
                    book_found = true;
                    on_seen = list_length-1-i;
                    break;
                }
            }
        }
        if (!book_found){
            for (int i=0; i<list_length; i++){
                if (publishers.get(i).equals(search_book_textfield.getText())){
                    book_found = true;
                    on_seen = list_length-1-i;
                    break;
                }
            }
        }
        search_book_textfield.setText("");
        if (book_found){
            shift(on_seen);
        }else{
            new DateAddedFrame("No such Book Available");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (list_length!=0){
            if (e.getX()>=30 && e.getX()<=150){
                if (e.getY()>=20 && e.getY()<=190){
                    new UpdateBookCoverFrame(isbns.get(list_length-1-on_seen));
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
