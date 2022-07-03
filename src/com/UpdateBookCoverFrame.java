package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateBookCoverFrame extends JFrame implements MouseListener{
    private String book_isbn;
    UpdateBookCoverFrame(String book_isbn){
        this.setSize(400, 300);
        this.addMouseListener(this);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(245, 222, 179));

        this.setBook_isbn(book_isbn);

        JLabel update_cover = new JLabel("Update Cover");
        update_cover.setFont(new Font("Arial", Font.BOLD, 30));
        update_cover.setBounds(5, 10, 400, 50);
        this.add(update_cover);

        JLabel remove_cover = new JLabel("Remove Cover");
        remove_cover.setFont(new Font("Arial", Font.BOLD, 30));
        remove_cover.setBounds(5, 80, 400, 50);
        this.add(remove_cover);

        JLabel update_issue = new JLabel("Issue");
        update_issue.setFont(new Font("Arial", Font.BOLD, 30));
        update_issue.setBounds(5, 150, 400, 50);
        this.add(update_issue);

        JLabel returned = new JLabel("Return");
        returned.setFont(new Font("Arial", Font.BOLD, 30));
        returned.setBounds(5, 220, 400, 50);
        this.add(returned);

        this.setVisible(true);
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void mousePressed(MouseEvent e){
        if (e.getY()>=10 && e.getY()<=60){
            new UpdateBookCover(Integer.parseInt(book_isbn));
        }if (e.getY()>=80 && e.getY()<=130){
            RemoveBookCover removeBookCover = new RemoveBookCover(Integer.parseInt(book_isbn));
            removeBookCover.remove_cover();
        }if (e.getY()>=150 && e.getY()<=200){
            CheckBookIssued checkBookIssued = new CheckBookIssued();
            checkBookIssued.check_book_issued(Integer.parseInt(book_isbn));
        }if (e.getY()>=220 && e.getY()<=270){
            ReturnBook returnBook = new ReturnBook();
            returnBook.check_book_issued(Integer.parseInt(book_isbn));
        }
    }
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
}
