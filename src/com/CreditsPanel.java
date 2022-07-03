package com;

import javax.swing.*;
import java.awt.*;

public class CreditsPanel extends JPanel{
    JLabel created_by;
    JLabel creator_1;
    JLabel creator_2;
    JLabel creator_3;
    JLabel students_of;
    JLabel created_for;
    JLabel created_for_2;
    CreditsPanel(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        created_by = new JLabel("Created By");
        created_by.setBounds(20, 30, 400, 70);
        created_by.setForeground(new Color(148, 0, 211));
        created_by.setFont(new Font("Arial", Font.BOLD, 50));
        this.add(created_by);

        creator_1 = new JLabel("* Muhammad Bilal");
        creator_1.setFont(new Font("Arial", Font.BOLD, 30));
        creator_1.setBounds(20, 110, 400, 70);
        creator_1.setForeground(new Color(148, 0, 211));
        this.add(creator_1);

        creator_2 = new JLabel("* Muhammad Ashhub Ali");
        creator_2.setFont(new Font("Arial", Font.BOLD, 30));
        creator_2.setBounds(20, 200, 500, 70);
        creator_2.setForeground(new Color(148, 0, 211));
        this.add(creator_2);

        creator_3 = new JLabel("* Abdul Arham");
        creator_3.setFont(new Font("Arial", Font.BOLD, 30));
        creator_3.setBounds(20, 280, 400, 70);
        creator_3.setForeground(new Color(148, 0, 211));
        this.add(creator_3);

        students_of = new JLabel("Students Of Software Engineering, SEECS, NUST Islamabad");
        students_of.setFont(new Font("Arial", Font.BOLD, 20));
        students_of.setBounds(20, 355, 600, 25);
        students_of.setForeground(new Color(148, 0, 211));
        this.add(students_of);

        created_for = new JLabel("This Software is created as a Project for Object Oriented ");
        created_for.setFont(new Font("Arial", Font.BOLD, 20));
        created_for.setBounds(20, 385, 600, 25);
        created_for.setForeground(new Color(148, 0, 211));
        this.add(created_for);

        created_for_2 = new JLabel("Programming during Second Semester of BESE");
        created_for_2.setFont(new Font("Arial", Font.BOLD, 20));
        created_for_2.setBounds(20, 415, 600, 25);
        created_for_2.setForeground(new Color(148, 0, 211));
        this.add(created_for_2);
    }
}
