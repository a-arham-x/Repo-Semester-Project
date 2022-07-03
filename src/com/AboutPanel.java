package com;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel{
    JLabel library_management_system;
    AboutPanelLines line_1;
    AboutPanelLines line_2;
    AboutPanelLines line_3;
    AboutPanelLines line_4;
    AboutPanelLines line_5;
    AboutPanelLines line_6;
    AboutPanelLines line_7;
    AboutPanelLines line_8;
    AboutPanelLines line_9;
    AboutPanelLines line_10;
    AboutPanelLines line_11;
    AboutPanelLines line_12;
    AboutPanelLines line_13;
    AboutPanel(){
        this.setBounds(160, 70, 650, 470);
        this.setBackground(new Color(245, 222, 179));
        this.setLayout(null);

        library_management_system = new JLabel("Library Management System");
        library_management_system.setBounds(15, 20, 620, 50);
        library_management_system.setForeground(new Color(148, 0, 211));
        library_management_system.setFont(new Font("Arial", Font.BOLD, 45));
        this.add(library_management_system);

        line_1 = new AboutPanelLines(80, "This Library Management System is created by Students of");
        this.add(line_1);

        line_2 = new AboutPanelLines(110, "Software Engineering at SEECS, NUST. The aim of this Software");
        this.add(line_2);

        line_3 = new AboutPanelLines(140, "is to provide a Library Management System that is very simple");
        this.add(line_3);

        line_4 = new AboutPanelLines(170, "to use and that any Library can use for managing its records.");
        this.add(line_4);

        line_5 = new AboutPanelLines(200, "This System comes in with features like Admin Control and users");
        this.add(line_5);

        line_6 = new AboutPanelLines(230, "accounts management. A member anyone can check in the books");
        this.add(line_6);

        line_7 = new AboutPanelLines(260, "available at the Library and can request to bring in books as");
        this.add(line_7);

        line_8 = new AboutPanelLines(290, "desired. The Admin has the hold of all the records of all kinds");
        this.add(line_8);

        line_9 = new AboutPanelLines(320, "members registered, employees working in the Library, books that");
        this.add(line_9);

        line_10 = new AboutPanelLines(350, "are available in the Library and those that are requested by any");
        this.add(line_10);

        line_11 = new AboutPanelLines(380, "member. No one can make an account in the system on one's own");
        this.add(line_11);

        line_12 = new AboutPanelLines(410, "but once a member has been allocated an account, the member");
        this.add(line_12);

        line_13 = new AboutPanelLines(440, "has control over the alloted account and its LogIn Credentials.");
        this.add(line_13);
    }
}
