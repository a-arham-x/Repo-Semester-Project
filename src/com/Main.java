package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends JFrame implements ActionListener, MouseListener{
    LoginWindowPanel loginWindowPanel;
    LargeLabel openning_label;
    ProjectTextfield username_login_textfield;
    JPasswordField password_login_textfield;
    SmallButton loginButton;
    JButton show_hide_login_password;
    ImageIcon icon1;
    ImageIcon icon2;
    JButton settings_button;
    boolean password_visible = false;
    Timer timer;
    boolean sliding = false;
    boolean reverse_sliding = false;
    int slide_x=-140;
    int label_x = 145;
    boolean shifting_page = false;
    CreditsPanel creditsPanel;
    AboutPanel aboutPanel;
    ImageIcon icon3;
    ImageIcon icon4;
    JButton admin_settings_button;
    int admin_slide_x=-140;
    boolean admin_settings_sliding = false;
    boolean admin_settings_reverse_sliding = false;
    boolean shifting_in_admin_account = false;
    ImageIcon admin_profile_pic_icon;
    JLabel admin_profile_pic_label;
    JLabel admin_name;
    JLabel lms_admin_account;
    JButton refresh_admin_page;
    EnlongedButton admin_page_requests_button;
    EnlongedButton admin_page_catalogue_button;
    EnlongedButton admin_page_attendance_button;
    JPanel admin_home_page_panel;
    JPanel admin_info_panel;
    JLabel admin_change_info;
    JLabel admin_update_name_label;
    JLabel admin_update_key_label;
    JLabel admin_update_new_key_label;
    JTextField admin_update_name_textfield;
    JPasswordField admin_update_key_textfield;
    JPasswordField admin_update_new_key_textfield;
    JButton admin_info_update;
    JButton admin_info_key_show_hide_button;
    JButton admin_info_new_key_show_hide_button;
    boolean admin_key_info_visible = false;
    boolean admin_new_key_visible = false;
    AdminMembersPanel adminMembersPanel;
    LargerEnlongedButton admin_add_member;
    LargerEnlongedButton admin_remove_member;
    LargerEnlongedButton admin_view_members;
    AddMemberPanel addMemberPanel;
    SmallLabel add_member_name_label;
    SmallLabel add_member_username_label;
    SmallLabel add_member_password_label;
    SmallLabel add_member_age_label;
    SmallLabel add_member_gender_label;
    SmallLabel add_member_phone_label;
    SmallLabel add_member_email_label;
    ProjectTextfield add_member_name_textfield;
    ProjectTextfield add_member_username_textfield;
    ProjectTextfield add_member_password_textfield;
    ProjectTextfield add_member_age_textfield;
    JComboBox<String> add_member_gender_combobox;
    ProjectTextfield add_member_phone_textfield;
    ProjectTextfield add_member_email_textfield;
    SmallButton add_member_button;
    RemoveMemberPanel removeMemberPanel;
    SmallLabel remove_member_username_label;
    ProjectTextfield remove_member_username_textfield;
    EnlongedButton remove_member_button;
    LargeLabel delete_member_account;
    ViewMembersPanel viewMembersPanel;
    JButton vmp_scroll_up;
    JButton vmp_scroll_down;
    JButton vmp_scroll_left;
    JButton vmp_scroll_right;
    SearchButton search_member;
    boolean searching_member = false;
    JPanel search_panel;
    ProjectTextfield search_member_textfield;
    JPanel admin_employee_panel;
    LargerEnlongedButton admin_add_employee;
    LargerEnlongedButton admin_remove_employee;
    LargerEnlongedButton admin_view_employees;
    ViewAMemberPanel viewAMemberPanel;
    EnlongedButton back_from_vamp;
    JPanel addEmployeePanel;
    SmallLabel add_employee_name_label;
    SmallLabel add_employee_username_label;
    SmallLabel add_employee_password_label;
    SmallLabel add_employee_age_label;
    SmallLabel add_employee_gender_label;
    SmallLabel add_employee_job_label;
    SmallLabel add_employee_phone_label;
    SmallLabel add_employee_email_label;
    ProjectTextfield add_employee_name_textfield;
    ProjectTextfield add_employee_username_textfield;
    ProjectTextfield add_employee_password_textfield;
    ProjectTextfield add_employee_age_textfield;
    JComboBox<String> add_employee_gender_combobox;
    ProjectTextfield add_employee_job_textfield;
    ProjectTextfield add_employee_phone_textfield;
    ProjectTextfield add_employee_email_textfield;
    EnlongedButton add_employee_button;
    JPanel remove_employee_panel;
    LargeLabel delete_employee_account;
    SmallLabel remove_employee_username_label;
    ProjectTextfield remove_employee_username_textfield;
    EnlongedButton remove_employee_button;
    ViewEmployeesPanel viewEmployeesPanel;
    JButton vep_scroll_up;
    JButton vep_scroll_down;
    JButton vep_scroll_left;
    JButton vep_scroll_right;
    SearchButton search_employee;
    boolean searching_employee = false;
    JPanel search_employee_panel;
    ProjectTextfield search_employee_textfield;
    ViewAnEmployeePanel viewAnEmployeePanel;
    EnlongedButton back_from_vaep;
    JPanel attendance_panel;
    SmallLabel add_date_label;
    ProjectTextfield addDateTextField;
    SmallLabel search_employee_label;
    ProjectTextfield search_employee_attendance_textfield;
    EnlongedButton searchEmployeeAttendanceButton;
    EnlongedButton add_date_button;
    EmployeeAttendancePanel employeeAttendancePanel;
    String a_user;
    JButton eap_scroll_up;
    JButton eap_scroll_down;
    JLabel edit_attendance_label;
    JComboBox<String> date_box;
    JComboBox<String> presence_absence;
    SmallButton markAttendanceButton;
    JPanel adminBookCataloguePanel;
    LargerEnlongedButton addBook;
    LargerEnlongedButton removeBook;
    LargerEnlongedButton viewBook;
    JPanel addBookPanel;
    SmallLabel add_book_name_label;
    SmallLabel add_book_author_label;
    SmallLabel add_book_publisher_label;
    SmallLabel add_book_genre_label;
    SmallLabel add_book_dl_label;
    SmallLabel add_book_isbn_label;
    ProjectTextfield add_book_name_textfield;
    ProjectTextfield add_book_author_textfield;
    ProjectTextfield add_book_publisher_textfield;
    ProjectTextfield add_book_genre_textfield;
    ProjectTextfield add_book_dl_textfield;
    ProjectTextfield add_book_isbn_textfield;
    EnlongedButton add_book_button;
    JPanel removeBookPanel;
    LargeLabel removeBookLabel;
    SmallLabel enter_isbn;
    ProjectTextfield remove_book_textfield;
    EnlongedButton remove_book_button;
    ViewBooksPanel viewBooksPanel;
    JButton vbp_scroll_left;
    JButton vbp_scroll_right;
    JPanel admin_sent_recieved;
    AdminViewRequests adminViewRequests;
    LargerEnlongedButton admin_view_sent_messages;
    LargerEnlongedButton admin_view_recieved_requests;
    JButton admin_vr_scroll_up;
    JButton admin_vr_scroll_down;
    AdminViewMessages adminViewMessages;
    JButton admin_vm_scroll_up;
    JButton admin_vm_scroll_down;
    EnlongedButton adminMessageButton;
    JPanel adminMessagePanel;
    JLabel admin_type_message;
    JLabel admin_enter_user;
    ProjectTextfield admin_message_textfield;
    ProjectTextfield admin_enter_user_textfield;
    EnlongedButton adminSendMessage;
    Main(){
        this.setSize(1000, 670);
        this.addMouseListener(this);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);

        settings_button = new JButton("⁞");
        settings_button.addActionListener(this);
        settings_button.setFocusable(false);
        settings_button.setBackground(new Color(148, 0, 211));
        settings_button.setForeground(Color.white);
        settings_button.setFont(new Font("Arial", Font.BOLD, 15));
        settings_button.setBounds(0, 0, 40, 40);
        this.add(settings_button);

        loginWindowPanel = new LoginWindowPanel();
        this.add(loginWindowPanel);

        openning_label = new LargeLabel("Library Management System", label_x, 20);
        this.add(openning_label);

        username_login_textfield = new ProjectTextfield(185, 150);
        loginWindowPanel.add(username_login_textfield);

        password_login_textfield = new JPasswordField();
        password_login_textfield.setFont(new Font("Arial", Font.PLAIN, 20));
        password_login_textfield.setBounds(185, 250, 300, 30);
        password_login_textfield.setEchoChar('●');
        loginWindowPanel.add(password_login_textfield);

        loginButton = new SmallButton("LogIn", 285, 310);
        loginButton.addActionListener(this);
        loginWindowPanel.add(loginButton);

        icon1 = new ImageIcon("eyes to be used (2).png");
        icon2 = new ImageIcon("eyes to be used (3).png");
        show_hide_login_password = new JButton();
        show_hide_login_password.setIcon(icon1);
        show_hide_login_password.setForeground(Color.white);
        show_hide_login_password.addActionListener(this);
        show_hide_login_password.setFocusable(false);
        show_hide_login_password.setBounds(485, 250, 30, 30);
        loginWindowPanel.add(show_hide_login_password);

        creditsPanel = new CreditsPanel();
        this.add(creditsPanel);
        creditsPanel.setVisible(false);

        aboutPanel = new AboutPanel();
        this.add(aboutPanel);
        aboutPanel.setVisible(false);

        icon1 = new ImageIcon("eyes to be used (2).png");
        icon2 = new ImageIcon("eyes to be used (3).png");
        icon3 = new ImageIcon("Show or Hide Admin Key (4).png");
        icon4 = new ImageIcon("Show or Hide Admin Key (3).png");

        admin_settings_button = new JButton("⁞");
        admin_settings_button.addActionListener(this);
        admin_settings_button.setFocusable(false);
        admin_settings_button.setBackground(new Color(148, 0, 211));
        admin_settings_button.setForeground(Color.white);
        admin_settings_button.setFont(new Font("Arial", Font.BOLD, 15));
        admin_settings_button.setBounds(0, 0, 40, 40);
        this.add(admin_settings_button);
        admin_settings_button.setVisible(false);

        admin_home_page_panel = new JPanel();
        admin_home_page_panel.setBounds(200, 50, 650, 550);
        admin_home_page_panel.setBackground(new Color(245, 222, 179));
        admin_home_page_panel.setLayout(null);
        this.add(admin_home_page_panel);
        admin_home_page_panel.setVisible(false);

        ImageIcon refresh_icon = new ImageIcon("refresh.png");
        refresh_admin_page = new JButton(refresh_icon);
        refresh_admin_page.setBounds(945, 0, 40, 40);
        refresh_admin_page.addActionListener(this);
        refresh_admin_page.setFocusable(false);
        this.add(refresh_admin_page);
        refresh_admin_page.setVisible(false);

        admin_profile_pic_label = new JLabel();
        admin_profile_pic_label.setBounds(200, 50, 200, 150);
        admin_home_page_panel.add(admin_profile_pic_label);

        admin_name = new JLabel();
        admin_name.setForeground(new Color(148, 0, 211));
        admin_name.setFont(new Font("Arial", Font.BOLD, 20));
        admin_name.setBounds(230, 220, 300, 30);
        admin_home_page_panel.add(admin_name);

        lms_admin_account = new JLabel("Library Management System - Admin Account");
        lms_admin_account.setForeground(new Color(148, 0, 211));
        lms_admin_account.setBounds(100, 250, 450, 30);
        lms_admin_account.setFont(new Font("Arial", Font.BOLD, 20));
        admin_home_page_panel.add(lms_admin_account);

        admin_page_requests_button = new EnlongedButton("Requests", 50, 380);
        admin_page_requests_button.addActionListener(this);
        admin_home_page_panel.add(admin_page_requests_button);

        admin_page_catalogue_button = new EnlongedButton("Catalogue", 250, 380);
        admin_page_catalogue_button.addActionListener(this);
        admin_home_page_panel.add(admin_page_catalogue_button);

        admin_page_attendance_button = new EnlongedButton("Attendance", 450, 380);
        admin_page_attendance_button.addActionListener(this);
        admin_home_page_panel.add(admin_page_attendance_button);

        admin_info_panel = new JPanel();
        admin_info_panel.setBounds(200, 50, 650, 550);
        admin_info_panel.setBackground(new Color(245, 222, 179));
        admin_info_panel.setLayout(null);
        this.add(admin_info_panel);
        admin_info_panel.setVisible(false);

        admin_change_info = new JLabel("Change Login Credentals");
        admin_change_info.setBounds(100, 20, 450, 100);
        admin_change_info.setFont(new Font("Arial", Font.BOLD, 30));
        admin_info_panel.add(admin_change_info);

        admin_update_name_label = new JLabel("Name");
        admin_update_name_label.setForeground(Color.BLACK);
        admin_update_name_label.setFont(new Font("Arial", Font.BOLD, 30));
        admin_update_name_label.setBounds(60, 140, 100, 30);
        admin_info_panel.add(admin_update_name_label);

        admin_update_key_label = new JLabel("Old Key");
        admin_update_key_label.setForeground(Color.BLACK);
        admin_update_key_label.setFont(new Font("Arial", Font.BOLD, 30));
        admin_update_key_label.setBounds(60, 200, 140, 30);
        admin_info_panel.add(admin_update_key_label);

        admin_update_new_key_label = new JLabel("New Key");
        admin_update_new_key_label.setForeground(Color.BLACK);
        admin_update_new_key_label.setFont(new Font("Arial", Font.BOLD, 30));
        admin_update_new_key_label.setBounds(60, 260, 140, 30);
        admin_info_panel.add(admin_update_new_key_label);

        admin_update_name_textfield = new JTextField();
        admin_update_name_textfield.setBounds(200, 140, 300, 30);
        admin_update_name_textfield.setFont(new Font("Arial", Font.BOLD, 30));
        admin_update_name_textfield.setForeground(Color.BLACK);
        admin_info_panel.add(admin_update_name_textfield);

        admin_update_key_textfield = new JPasswordField();
        admin_update_key_textfield.setEchoChar('●');
        admin_update_key_textfield.setBounds(200, 200, 300, 30);
        admin_update_key_textfield.setFont(new Font("Arial", Font.BOLD, 30));
        admin_update_key_textfield.setForeground(Color.BLACK);
        admin_info_panel.add(admin_update_key_textfield);

        admin_update_new_key_textfield = new JPasswordField();
        admin_update_new_key_textfield.setEchoChar('●');
        admin_update_new_key_textfield.setBounds(200, 260, 300, 30);
        admin_update_new_key_textfield.setFont(new Font("Arial", Font.BOLD, 30));
        admin_update_new_key_textfield.setForeground(Color.BLACK);
        admin_info_panel.add(admin_update_new_key_textfield);

        admin_info_update = new JButton("UPDATE");
        admin_info_update.setBounds(200, 400, 200, 100);
        admin_info_update.setFont(new Font("Arial", Font.BOLD, 30));
        admin_info_update.setBackground(new Color(148, 0, 211));
        admin_info_update.setForeground(Color.white);
        admin_info_update.addActionListener(this);
        admin_info_update.setFocusable(false);
        admin_info_panel.add(admin_info_update);

        admin_info_key_show_hide_button = new JButton();
        admin_info_key_show_hide_button.setIcon(icon1);
        admin_info_key_show_hide_button.setForeground(Color.white);
        admin_info_key_show_hide_button.addActionListener(this);
        admin_info_key_show_hide_button.setFocusable(false);
        admin_info_key_show_hide_button.setBounds(500, 200, 30, 30);
        admin_info_panel.add(admin_info_key_show_hide_button);

        admin_info_new_key_show_hide_button = new JButton();
        admin_info_new_key_show_hide_button.setIcon(icon1);
        admin_info_new_key_show_hide_button.setForeground(Color.white);
        admin_info_new_key_show_hide_button.addActionListener(this);
        admin_info_new_key_show_hide_button.setFocusable(false);
        admin_info_new_key_show_hide_button.setBounds(500, 260, 30, 30);
        admin_info_panel.add(admin_info_new_key_show_hide_button);

        adminMembersPanel = new AdminMembersPanel();
        this.add(adminMembersPanel);
        adminMembersPanel.setVisible(false);

        admin_add_member = new LargerEnlongedButton("Add Member", 175, 40);
        admin_add_member.addActionListener(this);
        adminMembersPanel.add(admin_add_member);

        admin_remove_member = new LargerEnlongedButton("Remove Member", 175, 180);
        admin_remove_member.addActionListener(this);
        adminMembersPanel.add(admin_remove_member);

        admin_view_members = new LargerEnlongedButton("View Members", 175, 320);
        admin_view_members.addActionListener(this);
        adminMembersPanel.add(admin_view_members);

        addMemberPanel = new AddMemberPanel();
        this.add(addMemberPanel);
        addMemberPanel.setVisible(false);

        add_member_name_label = new SmallLabel("Name", 100, 20);
        addMemberPanel.add(add_member_name_label);

        add_member_username_label = new SmallLabel("Username", 100, 100);
        addMemberPanel.add(add_member_username_label);

        add_member_password_label = new SmallLabel("Password", 100, 180);
        addMemberPanel.add(add_member_password_label);

        add_member_gender_label = new SmallLabel("Gender", 300, 260);
        addMemberPanel.add(add_member_gender_label);

        add_member_age_label = new SmallLabel("Age", 400, 20);
        addMemberPanel.add(add_member_age_label);

        add_member_phone_label = new SmallLabel("Phone Number", 400, 100);
        addMemberPanel.add(add_member_phone_label);

        add_member_email_label = new SmallLabel("Email Address", 400, 180);
        addMemberPanel.add(add_member_email_label);

        add_member_name_textfield = new ProjectTextfield(10, 60);
        addMemberPanel.add(add_member_name_textfield);

        add_member_username_textfield = new ProjectTextfield(10, 140);
        addMemberPanel.add(add_member_username_textfield);

        add_member_password_textfield = new ProjectTextfield(10, 220);
        addMemberPanel.add(add_member_password_textfield);

        String[] genders = {"Male", "Female"};

        add_member_gender_combobox = new JComboBox<>(genders);
        add_member_gender_combobox.setBounds(200, 300, 300, 30);
        add_member_gender_combobox.setFont(new Font("Arial", Font.BOLD, 20));
        addMemberPanel.add(add_member_gender_combobox);

        add_member_age_textfield = new ProjectTextfield(350, 60);
        addMemberPanel.add(add_member_age_textfield);

        add_member_phone_textfield = new ProjectTextfield(350, 140);
        addMemberPanel.add(add_member_phone_textfield);

        add_member_email_textfield = new ProjectTextfield(350, 220);
        addMemberPanel.add(add_member_email_textfield);

        add_member_button = new SmallButton("ADD", 300, 380);
        add_member_button.addActionListener(this);
        add_member_button.setForeground(Color.white);
        add_member_button.setBackground(new Color(148, 0, 211));
        addMemberPanel.add(add_member_button);

        removeMemberPanel = new RemoveMemberPanel();
        this.add(removeMemberPanel);
        removeMemberPanel.setVisible(false);

        remove_member_username_label = new SmallLabel("Username", 300, 160);
        removeMemberPanel.add(remove_member_username_label);

        remove_member_username_textfield = new ProjectTextfield(200, 200);
        removeMemberPanel.add(remove_member_username_textfield);

        remove_member_button = new EnlongedButton("Remove", 275, 320);
        remove_member_button.addActionListener(this);
        removeMemberPanel.add(remove_member_button);

        delete_member_account = new LargeLabel("Delete Account", 175, 20);
        removeMemberPanel.add(delete_member_account);

        viewMembersPanel = new ViewMembersPanel();
        this.add(viewMembersPanel);
        viewMembersPanel.setVisible(false);

        vmp_scroll_up = new JButton("^");
        vmp_scroll_up.setBounds(435, 30, 100, 40);
        vmp_scroll_up.setForeground(Color.white);
        vmp_scroll_up.setBackground(new Color(148, 0, 211));
        vmp_scroll_up.setFont(new Font("Arial", Font.BOLD, 20));
        vmp_scroll_up.setFocusable(false);
        vmp_scroll_up.addActionListener(this);
        this.add(vmp_scroll_up);
        vmp_scroll_up.setVisible(false);

        vmp_scroll_down = new JButton("v");
        vmp_scroll_down.setBounds(435, 540, 100, 40);
        vmp_scroll_down.setForeground(Color.white);
        vmp_scroll_down.setBackground(new Color(148, 0, 211));
        vmp_scroll_down.setFont(new Font("Arial", Font.BOLD, 15));
        vmp_scroll_down.setFocusable(false);
        vmp_scroll_down.addActionListener(this);
        this.add(vmp_scroll_down);
        vmp_scroll_down.setVisible(false);

        vmp_scroll_right = new JButton(">");
        vmp_scroll_right.setBounds(810, 255, 60, 100);
        vmp_scroll_right.setForeground(Color.white);
        vmp_scroll_right.setBackground(new Color(148, 0, 211));
        vmp_scroll_right.setFont(new Font("Arial", Font.BOLD, 20));
        vmp_scroll_right.setFocusable(false);
        vmp_scroll_right.addActionListener(this);
        this.add(vmp_scroll_right);
        vmp_scroll_right.setVisible(false);

        vmp_scroll_left = new JButton("<");
        vmp_scroll_left.setBounds(100, 255, 60, 100);
        vmp_scroll_left.setForeground(Color.white);
        vmp_scroll_left.setBackground(new Color(148, 0, 211));
        vmp_scroll_left.setFont(new Font("Arial", Font.BOLD, 20));
        vmp_scroll_left.setFocusable(false);
        vmp_scroll_left.addActionListener(this);
        this.add(vmp_scroll_left);
        vmp_scroll_left.setVisible(false);

        search_member = new SearchButton(905, 0);
        search_member.addActionListener(this);
        this.add(search_member);
        search_member.setVisible(false);

        search_panel = new JPanel();
        search_panel.setBounds(585, 0, 320, 40);
        search_panel.setBackground(Color.BLUE);
        search_panel.setLayout(null);
        this.add(search_panel);
        search_panel.setVisible(false);

        search_member_textfield = new ProjectTextfield(10, 5);
        search_panel.add(search_member_textfield);

        admin_add_employee = new LargerEnlongedButton("Add Employee",5,5);
        admin_add_employee.addActionListener(this);
        admin_remove_employee = new LargerEnlongedButton("Remove Employee",5,5);
        admin_remove_employee.addActionListener(this);
        admin_view_employees = new LargerEnlongedButton("View Employees",5,5);
        admin_view_employees.addActionListener(this);

        admin_employee_panel = new JPanel();
        admin_employee_panel.setBounds(160, 70, 650, 470);
        admin_employee_panel.setBackground(new Color(245,222,179));
        admin_employee_panel.setLayout(new BoxLayout(admin_employee_panel,BoxLayout.Y_AXIS));
        admin_add_employee.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin_remove_employee.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin_view_employees.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin_employee_panel.add(Box.createRigidArea(new Dimension(300,80)));
        admin_employee_panel.add(admin_add_employee);
        admin_employee_panel.add(Box.createRigidArea(new Dimension(300,80)));
        admin_employee_panel.add(admin_remove_employee);
        admin_employee_panel.add(Box.createRigidArea(new Dimension(300,80)));
        admin_employee_panel.add(admin_view_employees);
        this.add(admin_employee_panel);
        admin_employee_panel.setVisible(false);

        viewAMemberPanel = new ViewAMemberPanel();
        this.add(viewAMemberPanel);
        viewAMemberPanel.setVisible(false);

        back_from_vamp = new EnlongedButton("BACK", 10, 400);
        back_from_vamp.addActionListener(this);
        viewAMemberPanel.add(back_from_vamp);

        addEmployeePanel = new JPanel();
        addEmployeePanel.setBackground(new Color(245, 222, 179));
        addEmployeePanel.setBounds(150, 70, 670, 470);
        addEmployeePanel.setLayout(null);
        this.add(addEmployeePanel);
        addEmployeePanel.setVisible(false);

        add_employee_name_label = new SmallLabel("Name", 100, 20);
        addEmployeePanel.add(add_employee_name_label);

        add_employee_username_label = new SmallLabel("Username", 100, 100);
        addEmployeePanel.add(add_employee_username_label);

        add_employee_password_label = new SmallLabel("Password", 100, 180);
        addEmployeePanel.add(add_employee_password_label);

        add_employee_gender_label = new SmallLabel("Gender", 100, 260);
        addEmployeePanel.add(add_employee_gender_label);

        add_employee_age_label = new SmallLabel("Age", 400, 20);
        addEmployeePanel.add(add_employee_age_label);

        add_employee_job_label = new SmallLabel("Job", 400, 100);
        addEmployeePanel.add(add_employee_job_label);

        add_employee_phone_label = new SmallLabel("Phone Number", 400, 180);
        addEmployeePanel.add(add_employee_phone_label);

        add_employee_email_label = new SmallLabel("Email Address", 400, 260);
        addEmployeePanel.add(add_employee_email_label);

        add_employee_name_textfield = new ProjectTextfield(10, 60);
        addEmployeePanel.add(add_employee_name_textfield);

        add_employee_username_textfield = new ProjectTextfield(10, 140);
        addEmployeePanel.add(add_employee_username_textfield);

        add_employee_password_textfield = new ProjectTextfield(10, 220);
        addEmployeePanel.add(add_employee_password_textfield);

        add_employee_gender_combobox = new JComboBox<>(genders);
        add_employee_gender_combobox.setBounds(10, 300, 300, 30);
        add_employee_gender_combobox.setFont(new Font("Arial", Font.BOLD, 20));
        addEmployeePanel.add(add_employee_gender_combobox);

        add_employee_age_textfield = new ProjectTextfield(350, 60);
        addEmployeePanel.add(add_employee_age_textfield);

        add_employee_job_textfield = new ProjectTextfield(350, 140);
        addEmployeePanel.add(add_employee_job_textfield);

        add_employee_phone_textfield = new ProjectTextfield(350, 220);
        addEmployeePanel.add(add_employee_phone_textfield);

        add_employee_email_textfield = new ProjectTextfield(350, 300);
        addEmployeePanel.add(add_employee_email_textfield);

        add_employee_button = new EnlongedButton("ADD", 265, 370);
        add_employee_button.addActionListener(this);
        addEmployeePanel.add(add_employee_button);

        remove_employee_panel = new JPanel();
        remove_employee_panel.setBounds(160, 70, 650, 470);
        remove_employee_panel.setBackground(new Color(245, 222, 179));
        remove_employee_panel.setLayout(null);
        this.add(remove_employee_panel);
        remove_employee_panel.setVisible(false);

        remove_employee_panel = new JPanel();
        remove_employee_panel.setBounds(150, 50, 700, 500);
        remove_employee_panel.setBackground(new Color(245, 222, 179));
        remove_employee_panel.setLayout(null);
        this.add(remove_employee_panel);
        remove_employee_panel.setVisible(false);

        remove_employee_username_label = new SmallLabel("Username", 300, 160);
        remove_employee_panel.add(remove_employee_username_label);

        remove_employee_username_textfield = new ProjectTextfield(200, 200);
        remove_employee_panel.add(remove_employee_username_textfield);

        remove_employee_button = new EnlongedButton("Remove", 275, 320);
        remove_employee_button.addActionListener(this);
        remove_employee_panel.add(remove_employee_button);

        delete_employee_account = new LargeLabel("Delete Account", 175, 20);
        remove_employee_panel.add(delete_employee_account);

        viewEmployeesPanel = new ViewEmployeesPanel();
        this.add(viewEmployeesPanel);
        viewEmployeesPanel.setVisible(false);

        vep_scroll_up = new JButton("^");
        vep_scroll_up.setBounds(435, 30, 100, 40);
        vep_scroll_up.setForeground(Color.white);
        vep_scroll_up.setBackground(new Color(148, 0, 211));
        vep_scroll_up.setFont(new Font("Arial", Font.BOLD, 20));
        vep_scroll_up.setFocusable(false);
        vep_scroll_up.addActionListener(this);
        this.add(vep_scroll_up);
        vep_scroll_up.setVisible(false);

        vep_scroll_down = new JButton("v");
        vep_scroll_down.setBounds(435, 540, 100, 40);
        vep_scroll_down.setForeground(Color.white);
        vep_scroll_down.setBackground(new Color(148, 0, 211));
        vep_scroll_down.setFont(new Font("Arial", Font.BOLD, 15));
        vep_scroll_down.setFocusable(false);
        vep_scroll_down.addActionListener(this);
        this.add(vep_scroll_down);
        vep_scroll_down.setVisible(false);

        vep_scroll_right = new JButton(">");
        vep_scroll_right.setBounds(810, 255, 60, 100);
        vep_scroll_right.setForeground(Color.white);
        vep_scroll_right.setBackground(new Color(148, 0, 211));
        vep_scroll_right.setFont(new Font("Arial", Font.BOLD, 20));
        vep_scroll_right.setFocusable(false);
        vep_scroll_right.addActionListener(this);
        this.add(vep_scroll_right);
        vep_scroll_right.setVisible(false);

        vep_scroll_left = new JButton("<");
        vep_scroll_left.setBounds(100, 255, 60, 100);
        vep_scroll_left.setForeground(Color.white);
        vep_scroll_left.setBackground(new Color(148, 0, 211));
        vep_scroll_left.setFont(new Font("Arial", Font.BOLD, 20));
        vep_scroll_left.setFocusable(false);
        vep_scroll_left.addActionListener(this);
        this.add(vep_scroll_left);
        vep_scroll_left.setVisible(false);

        search_employee = new SearchButton(905, 0);
        search_employee.addActionListener(this);
        this.add(search_employee);
        search_employee.setVisible(false);

        search_employee_panel = new JPanel();
        search_employee_panel.setBounds(585, 0, 320, 40);
        search_employee_panel.setBackground(Color.BLUE);
        search_employee_panel.setLayout(null);
        this.add(search_employee_panel);
        search_employee_panel.setVisible(false);

        search_employee_textfield = new ProjectTextfield(10, 5);
        search_employee_panel.add(search_employee_textfield);

        viewAnEmployeePanel = new ViewAnEmployeePanel();
        this.add(viewAnEmployeePanel);
        viewAnEmployeePanel.setVisible(false);

        back_from_vaep = new EnlongedButton("BACK", 10, 400);
        back_from_vaep.addActionListener(this);
        viewAnEmployeePanel.add(back_from_vaep);

        attendance_panel = new JPanel();
        attendance_panel.setBounds(160, 70, 650, 470);
        attendance_panel.setBackground(new Color(245, 222, 179));
        attendance_panel.setLayout(null);
        this.add(attendance_panel);
        attendance_panel.setVisible(false);

        search_employee_label = new SmallLabel("Search Employee", 220, 100);
        attendance_panel.add(search_employee_label);

        search_employee_attendance_textfield = new ProjectTextfield(175, 140);
        attendance_panel.add(search_employee_attendance_textfield);

        searchEmployeeAttendanceButton = new EnlongedButton("Search", 245, 180);
        searchEmployeeAttendanceButton.addActionListener(this);
        attendance_panel.add(searchEmployeeAttendanceButton);

        add_date_label = new SmallLabel("Add date (dd/mm/yyyy) ", 225, 300);
        attendance_panel.add(add_date_label);

        addDateTextField = new ProjectTextfield(175, 340);
        attendance_panel.add(addDateTextField);

        add_date_button = new EnlongedButton("ADD", 245, 380);
        add_date_button.addActionListener(this);
        attendance_panel.add(add_date_button);

        employeeAttendancePanel = new EmployeeAttendancePanel("uuuu");
        this.add(employeeAttendancePanel);
        employeeAttendancePanel.setVisible(false);

        eap_scroll_up = new JButton("^");
        eap_scroll_up.setBounds(435, 30, 100, 40);
        eap_scroll_up.setForeground(Color.white);
        eap_scroll_up.setBackground(new Color(148, 0, 211));
        eap_scroll_up.setFont(new Font("Arial", Font.BOLD, 20));
        eap_scroll_up.setFocusable(false);
        eap_scroll_up.addActionListener(this);
        this.add(eap_scroll_up);
        eap_scroll_up.setVisible(false);

        eap_scroll_down = new JButton("v");
        eap_scroll_down.setBounds(435, 540, 100, 40);
        eap_scroll_down.setForeground(Color.white);
        eap_scroll_down.setBackground(new Color(148, 0, 211));
        eap_scroll_down.setFont(new Font("Arial", Font.BOLD, 15));
        eap_scroll_down.setFocusable(false);
        eap_scroll_down.addActionListener(this);
        this.add(eap_scroll_down);
        eap_scroll_down.setVisible(false);

        edit_attendance_label = new JLabel("Mark Attendance");
        edit_attendance_label.setBounds(820, 130, 180, 15);
        edit_attendance_label.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(edit_attendance_label);
        edit_attendance_label.setVisible(false);

        add_to_date_combobox();

        String[] PA_list = {"P", "A"};

        presence_absence = new JComboBox<>(PA_list);
        presence_absence.setBounds(820, 190, 150, 30);
        this.add(presence_absence);
        presence_absence.setVisible(false);

        markAttendanceButton = new SmallButton("MARK", 845, 230);
        markAttendanceButton.setBackground(new Color(148, 0, 211));
        markAttendanceButton.setForeground(Color.white);
        markAttendanceButton.addActionListener(this);
        this.add(markAttendanceButton);
        markAttendanceButton.setVisible(false);

        adminBookCataloguePanel = new JPanel();
        adminBookCataloguePanel.setBounds(160, 70, 650, 470);
        adminBookCataloguePanel.setLayout(null);
        adminBookCataloguePanel.setBackground(new Color(245, 222, 179));
        this.add(adminBookCataloguePanel);
        adminBookCataloguePanel.setVisible(false);

        addBook = new LargerEnlongedButton("Add Book", 175, 40);
        addBook.addActionListener(this);
        adminBookCataloguePanel.add(addBook);

        removeBook = new LargerEnlongedButton("Remove Book", 175, 180);
        removeBook.addActionListener(this);
        adminBookCataloguePanel.add(removeBook);

        viewBook = new LargerEnlongedButton("View Books", 175, 320);
        viewBook.addActionListener(this);
        adminBookCataloguePanel.add(viewBook);

        addBookPanel = new JPanel();
        addBookPanel.setBounds(160, 70, 650, 470);
        addBookPanel.setBackground(new Color(245, 222, 179));
        addBookPanel.setLayout(null);
        this.add(addBookPanel);
        addBookPanel.setVisible(false);

        add_book_name_label = new SmallLabel("Name of the Book", 100, 20);
        addBookPanel.add(add_book_name_label);

        add_book_author_label = new SmallLabel("Author of the Book", 400, 20);
        addBookPanel.add(add_book_author_label);

        add_book_publisher_label = new SmallLabel("Publisher of the Book", 80, 150);
        addBookPanel.add(add_book_publisher_label);

        add_book_genre_label = new SmallLabel("Genre of the Book", 400, 150);
        addBookPanel.add(add_book_genre_label);

        add_book_dl_label = new SmallLabel("Damage Level of the Book", 50, 280);
        addBookPanel.add(add_book_dl_label);

        add_book_isbn_label = new SmallLabel("ISBN Number", 400, 280);
        addBookPanel.add(add_book_isbn_label);

        add_book_name_textfield = new ProjectTextfield(10, 65);
        addBookPanel.add(add_book_name_textfield);

        add_book_author_textfield = new ProjectTextfield(340, 65);
        addBookPanel.add(add_book_author_textfield);

        add_book_publisher_textfield = new ProjectTextfield(10, 195);
        addBookPanel.add(add_book_publisher_textfield);

        add_book_genre_textfield = new ProjectTextfield(340, 195);
        addBookPanel.add(add_book_genre_textfield);

        add_book_dl_textfield = new ProjectTextfield(10, 325);
        addBookPanel.add(add_book_dl_textfield);

        add_book_isbn_textfield = new ProjectTextfield(340, 325);
        addBookPanel.add(add_book_isbn_textfield);

        add_book_button = new EnlongedButton("ADD", 250, 385);
        add_book_button.addActionListener(this);
        addBookPanel.add(add_book_button);

        removeBookPanel = new JPanel();
        removeBookPanel.setBounds(160, 70, 650, 470);
        removeBookPanel.setBackground(new Color(245, 222, 179));
        removeBookPanel.setLayout(null);
        this.add(removeBookPanel);
        removeBookPanel.setVisible(false);

        removeBookLabel = new LargeLabel("Remove Book", 175, 20);
        removeBookPanel.add(removeBookLabel);

        enter_isbn = new SmallLabel("Enter Isbn", 300, 160);
        removeBookPanel.add(enter_isbn);

        remove_book_textfield = new ProjectTextfield(200, 200);
        removeBookPanel.add(remove_book_textfield);

        remove_book_button = new EnlongedButton("Remove", 275, 320);
        remove_book_button.addActionListener(this);
        removeBookPanel.add(remove_book_button);

        viewBooksPanel = new ViewBooksPanel();
        this.add(viewBooksPanel);
        viewBooksPanel.setVisible(false);

        vbp_scroll_right = new JButton(">");
        vbp_scroll_right.setBounds(810, 255, 60, 100);
        vbp_scroll_right.setForeground(Color.white);
        vbp_scroll_right.setBackground(new Color(148, 0, 211));
        vbp_scroll_right.setFont(new Font("Arial", Font.BOLD, 20));
        vbp_scroll_right.setFocusable(false);
        vbp_scroll_right.addActionListener(this);
        this.add(vbp_scroll_right);
        vbp_scroll_right.setVisible(false);

        vbp_scroll_left = new JButton("<");
        vbp_scroll_left.setBounds(100, 255, 60, 100);
        vbp_scroll_left.setForeground(Color.white);
        vbp_scroll_left.setBackground(new Color(148, 0, 211));
        vbp_scroll_left.setFont(new Font("Arial", Font.BOLD, 20));
        vbp_scroll_left.setFocusable(false);
        vbp_scroll_left.addActionListener(this);
        this.add(vbp_scroll_left);
        vbp_scroll_left.setVisible(false);

        adminViewRequests = new AdminViewRequests();
        this.add(adminViewRequests);
        adminViewRequests.setVisible(false);

        admin_sent_recieved = new JPanel();
        admin_sent_recieved.setBounds(160, 70, 650, 470);
        admin_sent_recieved.setLayout(null);
        admin_sent_recieved.setBackground(new Color(245, 222, 179));
        this.add(admin_sent_recieved);
        admin_sent_recieved.setVisible(false);

        admin_view_sent_messages = new LargerEnlongedButton("SENT", 175, 100);
        admin_view_sent_messages.addActionListener(this);
        admin_sent_recieved.add(admin_view_sent_messages);

        admin_view_recieved_requests = new LargerEnlongedButton("RECIEVED", 175, 300);
        admin_view_recieved_requests.addActionListener(this);
        admin_sent_recieved.add(admin_view_recieved_requests);

        admin_vr_scroll_up = new JButton("^");
        admin_vr_scroll_up.setBounds(435, 30, 100, 40);
        admin_vr_scroll_up.setForeground(Color.white);
        admin_vr_scroll_up.setBackground(new Color(148, 0, 211));
        admin_vr_scroll_up.setFont(new Font("Arial", Font.BOLD, 20));
        admin_vr_scroll_up.setFocusable(false);
        admin_vr_scroll_up.addActionListener(this);
        this.add(admin_vr_scroll_up);
        admin_vr_scroll_up.setVisible(false);

        admin_vr_scroll_down = new JButton("v");
        admin_vr_scroll_down.setBounds(435, 540, 100, 40);
        admin_vr_scroll_down.setForeground(Color.white);
        admin_vr_scroll_down.setBackground(new Color(148, 0, 211));
        admin_vr_scroll_down.setFont(new Font("Arial", Font.BOLD, 15));
        admin_vr_scroll_down.setFocusable(false);
        admin_vr_scroll_down.addActionListener(this);
        this.add(admin_vr_scroll_down);
        admin_vr_scroll_down.setVisible(false);

        adminViewMessages = new AdminViewMessages();
        this.add(adminViewMessages);
        adminViewMessages.setVisible(false);

        admin_vm_scroll_up = new JButton("^");
        admin_vm_scroll_up.setBounds(435, 30, 100, 40);
        admin_vm_scroll_up.setForeground(Color.white);
        admin_vm_scroll_up.setBackground(new Color(148, 0, 211));
        admin_vm_scroll_up.setFont(new Font("Arial", Font.BOLD, 20));
        admin_vm_scroll_up.setFocusable(false);
        admin_vm_scroll_up.addActionListener(this);
        this.add(admin_vm_scroll_up);
        admin_vm_scroll_up.setVisible(false);

        admin_vm_scroll_down = new JButton("v");
        admin_vm_scroll_down.setBounds(435, 540, 100, 40);
        admin_vm_scroll_down.setForeground(Color.white);
        admin_vm_scroll_down.setBackground(new Color(148, 0, 211));
        admin_vm_scroll_down.setFont(new Font("Arial", Font.BOLD, 15));
        admin_vm_scroll_down.setFocusable(false);
        admin_vm_scroll_down.addActionListener(this);
        this.add(admin_vm_scroll_down);
        admin_vm_scroll_down.setVisible(false);

        adminMessageButton = new EnlongedButton("Message", 660, 540);
        adminMessageButton.addActionListener(this);
        this.add(adminMessageButton);
        adminMessageButton.setVisible(false);

        adminMessagePanel = new JPanel();
        adminMessagePanel.setBounds(160, 70, 650, 470);
        adminMessagePanel.setBackground(new Color(245, 222, 179));
        adminMessagePanel.setLayout(null);
        this.add(adminMessagePanel);
        adminMessagePanel.setVisible(false);

        admin_type_message = new JLabel("Type Message");
        admin_type_message.setFont(new Font("Arial", Font.BOLD, 20));
        admin_type_message.setBounds(30, 100, 150, 25);
        adminMessagePanel.add(admin_type_message);

        admin_message_textfield = new ProjectTextfield(30, 150);
        adminMessagePanel.add(admin_message_textfield);

        admin_enter_user = new JLabel("To (Username)");
        admin_enter_user.setFont(new Font("Arial", Font.BOLD, 20));
        admin_enter_user.setBounds(30, 200, 150, 25);
        adminMessagePanel.add(admin_enter_user);

        admin_enter_user_textfield = new ProjectTextfield(30, 250);
        adminMessagePanel.add(admin_enter_user_textfield);

        adminSendMessage = new EnlongedButton("Send", 30, 300);
        adminSendMessage.addActionListener(this);
        adminMessagePanel.add(adminSendMessage);


        this.setVisible(true);

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(148, 0, 211));
        g2D.drawRect(slide_x, 75, 140, 600);
        g2D.fillRect(slide_x, 70, 140, 600);
        g2D.setPaint(Color.white);
        g2D.setFont(new Font("Arial", Font.BOLD, 20));
        g2D.drawString("About", slide_x+20, 90);
        g2D.drawString("LogIn", slide_x + 20, 120);
        g2D.drawString("Credits", slide_x+20, 150);
        g2D.setPaint(new Color(148, 0, 211));
        g2D.drawRect(admin_slide_x, 75, 140, 600);
        g2D.fillRect(admin_slide_x, 70, 140, 600);
        g2D.setPaint(Color.white);
        g2D.setFont(new Font("Arial", Font.BOLD, 20));
        g2D.drawString("Home", admin_slide_x+20, 90);
        g2D.drawString("Employees", admin_slide_x+20, 120);
        g2D.drawString("Members", admin_slide_x + 20, 150);
        g2D.drawString("Info", admin_slide_x+20, 180);
        g2D.drawString("LogOut", admin_slide_x+20, 210);

    }

    public static void main(String[] args){
        new Main();
    }

    public void move_to_login_page(){
        if (slide_x==0){
            shifting_page = true;
        }
        aboutPanel.setVisible(false);
        creditsPanel.setVisible(false);
        openning_label.setVisible(true);
        loginWindowPanel.setVisible(true);
        settings_button.setVisible(true);
    }

    public void check_login_credentials(){
        AdminCredentials adminCredentials = new AdminCredentials();
        CheckCredentials checkMemberCredentials = new CheckMemberCredentials(username_login_textfield.getText());
        CheckCredentials checkEmployeeCredentials = new CheckEmployeeCredentials(username_login_textfield.getText());
        if (username_login_textfield.getText().equals(adminCredentials.getAdmin_name())){
            if (String.valueOf(password_login_textfield.getPassword()).equals(adminCredentials.getAdmin_key())){
                open_admin_account();
            }else{
                new IncorrectPassword();
            }
        }else{
            boolean it_is_member = checkMemberCredentials.username_in_database();
            if (it_is_member){
                if (String.valueOf(password_login_textfield.getPassword()).equals(checkMemberCredentials.getPassword())){
                    System.out.println("It is a member.");
                }else{
                    new IncorrectPassword();
                }
            }else{
                boolean it_is_employee = checkEmployeeCredentials.username_in_database();
                if (it_is_employee){
                    if (String.valueOf(password_login_textfield.getPassword()).equals(checkEmployeeCredentials.getPassword())){
                        System.out.println("It is an Employee.");
                    }else{
                        new IncorrectPassword();
                    }
                }else{
                    new UserNotExist();
                }
            }
        }
    }

    public void exit_login_page(){
        openning_label.setVisible(false);
        settings_button.setVisible(false);
        loginWindowPanel.setVisible(false);
        slide_x = -140;
    }

    public void open_admin_account(){
        exit_login_page();
        admin_slide_x = -140;
        repaint();
        username_login_textfield.setText("");
        password_login_textfield.setText("");
        show_hide_login_password.setIcon(icon1);
        password_login_textfield.setEchoChar('●');
        AdminProfilePic adminProfilePic = new AdminProfilePic();
        admin_profile_pic_icon = adminProfilePic.getAdmin_prof();
        admin_profile_pic_label.setIcon(admin_profile_pic_icon);
        AdminCredentials adminCredentials = new AdminCredentials();
        admin_name.setText(adminCredentials.getAdmin_name());
        refresh_admin_page.setVisible(true);
        admin_home_page_panel.setVisible(true);
        admin_settings_button.setVisible(true);
        addMemberPanel.setVisible(false);
        admin_info_panel.setVisible(false);
        adminMembersPanel.setVisible(false);
        removeMemberPanel.setVisible(false);
        admin_employee_panel.setVisible(false);
        viewAMemberPanel.setVisible(false);
        addEmployeePanel.setVisible(false);
        remove_employee_panel.setVisible(false);
        viewAnEmployeePanel.setVisible(false);
        attendance_panel.setVisible(false);
        adminBookCataloguePanel.setVisible(false);
        addBookPanel.setVisible(false);
        removeBookPanel.setVisible(false);
        adminMessagePanel.setVisible(false);
        exitAdminViewMessages();
        exitAdminViewRequests();
        exitAdminSentRecieved();
        exitAdminViewBooksPanel();
        exitEmployeeAttendancePanel();
        exitViewEmployeesPanel();
        exit_viewMembersPanel();
        setTextFieldsNull();
    }

    public void open_creditsPanel(){
        creditsPanel.setVisible(true);
        shifting_page = true;
        aboutPanel.setVisible(false);
        loginWindowPanel.setVisible(false);
        openning_label.setVisible(false);
        username_login_textfield.setText("");
        password_login_textfield.setText("");

    }

    public void open_aboutPanel(){
        aboutPanel.setVisible(true);
        creditsPanel.setVisible(false);
        shifting_page = true;
        loginWindowPanel.setVisible(false);
        openning_label.setVisible(false);
        username_login_textfield.setText("");
        password_login_textfield.setText("");
    }

    public void logout_admin_account(){
        shifting_in_admin_account = true;
        admin_info_panel.setVisible(false);
        admin_settings_button.setVisible(false);
        admin_home_page_panel.setVisible(false);
        refresh_admin_page.setVisible(false);
        adminMembersPanel.setVisible(false);
        addMemberPanel.setVisible(false);
        removeMemberPanel.setVisible(false);
        admin_employee_panel.setVisible(false);
        viewAMemberPanel.setVisible(false);
        addEmployeePanel.setVisible(false);
        remove_employee_panel.setVisible(false);
        viewAnEmployeePanel.setVisible(false);
        attendance_panel.setVisible(false);
        adminBookCataloguePanel.setVisible(false);
        addBookPanel.setVisible(false);
        removeBookPanel.setVisible(false);
        adminMessagePanel.setVisible(false);
        exitAdminViewMessages();
        exitAdminViewRequests();
        exitAdminSentRecieved();
        exitAdminViewBooksPanel();
        exitEmployeeAttendancePanel();
        exitViewEmployeesPanel();
        exit_viewMembersPanel();
        setTextFieldsNull();
        move_to_login_page();
    }

    public void move_to_admin_info_update(){
        adminMembersPanel.setVisible(false);
        addMemberPanel.setVisible(false);
        admin_home_page_panel.setVisible(false);
        exit_viewMembersPanel();
        admin_slide_x = -140;
        repaint();
        admin_info_panel.setVisible(true);
        removeMemberPanel.setVisible(false);
        admin_employee_panel.setVisible(false);
        viewAMemberPanel.setVisible(false);
        addEmployeePanel.setVisible(false);
        remove_employee_panel.setVisible(false);
        viewAnEmployeePanel.setVisible(false);
        attendance_panel.setVisible(false);
        adminBookCataloguePanel.setVisible(false);
        addBookPanel.setVisible(false);
        removeBookPanel.setVisible(false);
        adminMessagePanel.setVisible(false);
        exitAdminViewMessages();
        exitAdminViewRequests();
        exitAdminSentRecieved();
        exitAdminViewBooksPanel();
        exitEmployeeAttendancePanel();
        exitViewEmployeesPanel();
        setTextFieldsNull();
    }

    public void open_admin_members_panel(){
        adminMembersPanel.setVisible(true);
        admin_home_page_panel.setVisible(false);
        exit_viewMembersPanel();
        admin_slide_x = -140;
        repaint();
        viewAMemberPanel.setVisible(false);
        admin_info_panel.setVisible(false);
        addMemberPanel.setVisible(false);
        removeMemberPanel.setVisible(false);
        admin_employee_panel.setVisible(false);
        addEmployeePanel.setVisible(false);
        remove_employee_panel.setVisible(false);
        viewAnEmployeePanel.setVisible(false);
        attendance_panel.setVisible(false);
        adminBookCataloguePanel.setVisible(false);
        addBookPanel.setVisible(false);
        removeBookPanel.setVisible(false);
        adminMessagePanel.setVisible(false);
        exitAdminViewMessages();
        exitAdminViewRequests();
        exitAdminSentRecieved();
        exitAdminViewBooksPanel();
        exitEmployeeAttendancePanel();
        exitViewEmployeesPanel();
        setTextFieldsNull();
    }

    public void open_add_member_panel(){
        admin_slide_x = -140;
        adminMembersPanel.setVisible(false);
        addMemberPanel.setVisible(true);
    }

    public void open_removeMemberPanel(){
        adminMembersPanel.setVisible(false);
        admin_slide_x = -140;
        repaint();
        removeMemberPanel.setVisible(true);
    }

    public void setTextFieldsNull(){
        admin_update_name_textfield.setText("");
        admin_update_key_textfield.setText("");
        admin_update_new_key_textfield.setText("");
        remove_member_username_textfield.setText("");
        username_login_textfield.setText("");
        password_login_textfield.setText("");
        add_member_name_textfield.setText("");
        add_member_username_textfield.setText("");
        add_member_password_textfield.setText("");
        add_member_age_textfield.setText("");
        add_member_phone_textfield.setText("");
        add_member_email_textfield.setText("");
        search_member_textfield.setText("");
        add_employee_name_textfield.setText("");
        add_employee_username_textfield.setText("");
        add_employee_password_textfield.setText("");
        add_employee_age_textfield.setText("");
        add_employee_job_textfield.setText("");
        add_employee_phone_textfield.setText("");
        add_employee_email_textfield.setText("");
        remove_employee_username_textfield.setText("");
        search_employee_attendance_textfield.setText("");
        addDateTextField.setText("");
        add_book_name_textfield.setText("");
        add_book_author_textfield.setText("");
        add_book_publisher_textfield.setText("");
        add_book_genre_textfield.setText("");
        add_book_dl_textfield.setText("");
        add_book_isbn_textfield.setText("");
    }

    public void open_viewMembersPanel(){
        adminMembersPanel.setVisible(false);
        admin_slide_x = -140;
        repaint();
        viewMembersPanel = new ViewMembersPanel();
        this.add(viewMembersPanel);
        viewMembersPanel.setVisible(true);
        vmp_scroll_up.setVisible(true);
        vmp_scroll_down.setVisible(true);
        vmp_scroll_right.setVisible(true);
        vmp_scroll_left.setVisible(true);
        search_member.setVisible(true);
        admin_employee_panel.setVisible(false);
        viewAMemberPanel.setVisible(false);
    }

    public void exit_viewMembersPanel(){
        viewMembersPanel.setVisible(false);
        vmp_scroll_up.setVisible(false);
        vmp_scroll_down.setVisible(false);
        vmp_scroll_right.setVisible(false);
        vmp_scroll_left.setVisible(false);
        search_member.setVisible(false);
        search_panel.setVisible(false);
        viewAMemberPanel.setVisible(false);
    }

    public void openViewAMemberPanel(){
        vmp_scroll_up.setVisible(false);
        vmp_scroll_down.setVisible(false);
        vmp_scroll_right.setVisible(false);
        vmp_scroll_left.setVisible(false);
        viewMembersPanel.setVisible(false);
        viewAMemberPanel.setVisible(true);
        setTextFieldsNull();
    }

    public void openAdminEmployeesPanel(){
        admin_slide_x = -140;
        repaint();
        admin_home_page_panel.setVisible(false);
        admin_settings_button.setVisible(true);
        addMemberPanel.setVisible(false);
        admin_info_panel.setVisible(false);
        adminMembersPanel.setVisible(false);
        removeMemberPanel.setVisible(false);
        admin_employee_panel.setVisible(true);
        addEmployeePanel.setVisible(false);
        remove_employee_panel.setVisible(false);
        attendance_panel.setVisible(false);
        adminBookCataloguePanel.setVisible(false);
        addBookPanel.setVisible(false);
        removeBookPanel.setVisible(false);
        adminMessagePanel.setVisible(false);
        exitAdminViewMessages();
        exitAdminViewRequests();
        exitAdminSentRecieved();
        exitAdminViewBooksPanel();
        exitEmployeeAttendancePanel();
        exitViewEmployeesPanel();
        exit_viewMembersPanel();
        setTextFieldsNull();
    }

    public void openAddEmployeePanel(){
        admin_slide_x = -140;
        repaint();
        admin_employee_panel.setVisible(false);
        addEmployeePanel.setVisible(true);
    }

    public void search_member(String username_input){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from members");
            boolean user_found = false;
            while (rs.next()){
                if(rs.getString(1).equals(username_input)){
                    user_found = true;
                }else if (rs.getString(3).equals(username_input)){
                    user_found = true;
                    username_input = rs.getString(1);
                }
            }
            con.close();
            if (!user_found){
                new UserNotExist();
            }else{
                viewAMemberPanel.getMember(username_input);
                openViewAMemberPanel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void search_employee(String username_input){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from employees");
            boolean user_found = false;
            while (rs.next()){
                if(rs.getString(1).equals(username_input)){
                    user_found = true;
                }else if (rs.getString(2).equals(username_input)){
                    user_found = true;
                    username_input = rs.getString(1);
                }
            }
            con.close();
            if (!user_found){
                new UserNotExist();
            }else{
                viewAnEmployeePanel.get_employee(username_input);
                openViewAnEmployeePanel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openRemoveEmployeePanel(){
        admin_slide_x = -140;
        admin_employee_panel.setVisible(false);
        remove_employee_panel.setVisible(true);
    }

    public void openViewEmployeesPanel(){
        admin_employee_panel.setVisible(false);
        admin_slide_x = -140;
        repaint();
        viewEmployeesPanel = new ViewEmployeesPanel();
        this.add(viewEmployeesPanel);
        viewEmployeesPanel.setVisible(true);
        eap_scroll_up.setVisible(true);
        eap_scroll_down.setVisible(true);
        vep_scroll_right.setVisible(true);
        vep_scroll_left.setVisible(true);
        search_employee.setVisible(true);
        search_employee_panel.setVisible(false);
        viewAnEmployeePanel.setVisible(false);
    }

    public void exitViewEmployeesPanel(){
        viewEmployeesPanel.setVisible(false);
        eap_scroll_up.setVisible(false);
        eap_scroll_down.setVisible(false);
        vep_scroll_right.setVisible(false);
        vep_scroll_left.setVisible(false);
        search_employee.setVisible(false);
        search_employee_panel.setVisible(false);
        viewAnEmployeePanel.setVisible(false);
    }

    public void openViewAnEmployeePanel(){
        exitViewEmployeesPanel();
        viewAnEmployeePanel.setVisible(true);
    }

    public void openAttendancePanel(){
        admin_home_page_panel.setVisible(false);
        attendance_panel.setVisible(true);
        exitEmployeeAttendancePanel();
    }

    public void openEmployeeAttendancePanel(String username){
        add_to_date_combobox();
        attendance_panel.setVisible(false);
        setTextFieldsNull();
        employeeAttendancePanel = new EmployeeAttendancePanel(username);
        eap_scroll_up.setVisible(true);
        eap_scroll_down.setVisible(true);
        this.add(employeeAttendancePanel);
        date_box.setVisible(true);
        edit_attendance_label.setVisible(true);
        presence_absence.setVisible(true);
        markAttendanceButton.setVisible(true);
    }

    public void exitEmployeeAttendancePanel(){
        employeeAttendancePanel.setVisible(false);
        eap_scroll_up.setVisible(false);
        eap_scroll_down.setVisible(false);
        date_box.setVisible(false);
        edit_attendance_label.setVisible(false);
        presence_absence.setVisible(false);
        markAttendanceButton.setVisible(false);
    }

    public void add_to_date_combobox(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from attendance");
            int date_array_length = 0;
            while(rs.next()){
                date_array_length += 1;
            }
            String[] date_array = new String[date_array_length];
            ResultSet rs2 = stm.executeQuery("select * from attendance");
            int index = 0;
            while (rs2.next()){
                date_array[index] = rs2.getString(1);
                index += 1;
            }
            date_box = new JComboBox<>(date_array);
            date_box.setBounds(820, 150, 150, 30);
            this.add(date_box);
            date_box.setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openAdminViewBooksPanel(){
        adminBookCataloguePanel.setVisible(false);
        viewBooksPanel = new ViewBooksPanel();
        this.add(viewBooksPanel);
        viewBooksPanel.setVisible(true);
        vbp_scroll_right.setVisible(true);
        vbp_scroll_left.setVisible(true);
    }

    public void exitAdminViewBooksPanel(){
        viewBooksPanel.setVisible(false);
        vbp_scroll_left.setVisible(false);
        vbp_scroll_right.setVisible(false);
    }

    public void openAdminSentRecieved(){
        admin_home_page_panel.setVisible(false);
        admin_sent_recieved.setVisible(true);
    }

    public void exitAdminSentRecieved(){
        admin_sent_recieved.setVisible(false);
    }

    public void openAdminViewRequests(){
        adminViewRequests = new AdminViewRequests();
        this.add(adminViewRequests);
        adminViewRequests.setVisible(true);
        admin_sent_recieved.setVisible(false);
        admin_vr_scroll_up.setVisible(true);
        admin_vr_scroll_down.setVisible(true);
    }

    public void exitAdminViewRequests(){
        adminViewRequests.setVisible(false);
        admin_vr_scroll_up.setVisible(false);
        admin_vr_scroll_down.setVisible(false);
    }

    public void openAdminViewMessages(){
        adminViewMessages = new AdminViewMessages();
        this.add(adminViewMessages);
        adminViewMessages.setVisible(true);
        admin_sent_recieved.setVisible(false);
        admin_vm_scroll_up.setVisible(true);
        admin_vm_scroll_down.setVisible(true);
        adminMessageButton.setVisible(true);
    }

    public void exitAdminViewMessages(){
        adminViewMessages.setVisible(false);
        admin_vm_scroll_up.setVisible(false);
        admin_vm_scroll_down.setVisible(false);
        adminMessageButton.setVisible(false);
    }

    public void actionPerformed(ActionEvent e){
        if (sliding){
            repaint();
            slide_x += 20;
        }if (slide_x>-1){
            sliding = false;
        }if (reverse_sliding){
            repaint();
            slide_x -= 20;
        }if (slide_x==-140){
            reverse_sliding = false;}
        if (shifting_page){
            repaint();
            slide_x -= 140;
            shifting_page = false;
        }if (e.getSource()==show_hide_login_password){
            if (password_visible){
                show_hide_login_password.setIcon(icon1);
                password_login_textfield.setEchoChar('●');
                password_visible = false;
            }else {
                show_hide_login_password.setIcon(icon2);
                password_login_textfield.setEchoChar((char) 0);
                password_visible = true;
            }
        }
        if (admin_settings_sliding){
            admin_slide_x += 20;
            repaint();
        }if (admin_slide_x==0){
            admin_settings_sliding = false;
        }if (admin_settings_reverse_sliding){
            repaint();
            admin_slide_x -= 20;
        }if (admin_slide_x==-140){
            admin_settings_reverse_sliding = false;
        }if (shifting_in_admin_account) {
            repaint();
            admin_slide_x -= 140;
            shifting_in_admin_account = false;
        }if (e.getSource()==loginButton){
            check_login_credentials();
        }if (e.getSource()==settings_button){
            if (slide_x==-140){
                sliding = true;
            }else if (slide_x==0){
                reverse_sliding = true;
            }
        }
        if (e.getSource()==admin_settings_button){
            if (admin_slide_x==-140){
                admin_settings_sliding = true;
            }else if (admin_slide_x==0){
                admin_settings_reverse_sliding = true;
            }
        }if (e.getSource()==refresh_admin_page){
            open_admin_account();
        }if (e.getSource()==admin_info_key_show_hide_button){
            if (admin_key_info_visible){
                admin_key_info_visible = false;
                admin_info_key_show_hide_button.setIcon(icon1);
                admin_update_key_textfield.setEchoChar('●');
            }else {
                admin_key_info_visible = true;
                admin_info_key_show_hide_button.setIcon(icon2);
                admin_update_key_textfield.setEchoChar((char)0);
            }
        }if (e.getSource()==admin_info_new_key_show_hide_button){
            if (admin_new_key_visible){
                admin_new_key_visible = false;
                admin_info_new_key_show_hide_button.setIcon(icon1);
                admin_update_new_key_textfield.setEchoChar('●');
            }else{
                admin_new_key_visible = true;
                admin_info_new_key_show_hide_button.setIcon(icon2);
                admin_update_new_key_textfield.setEchoChar((char)0);
            }
        }if (e.getSource()==admin_info_update){
            new UpdateAdminCredentials(admin_update_name_textfield.getText(), String.valueOf(admin_update_key_textfield.getPassword()), String.valueOf(admin_update_new_key_textfield.getPassword()));
        }if (e.getSource()==admin_add_member){
            open_add_member_panel();
        }if (e.getSource()==add_member_button){
            CheckMemberFields checkMemberFields = new CheckMemberFields();
            String name = add_member_name_textfield.getText();
            String username = add_member_username_textfield.getText();
            String password = add_member_password_textfield.getText();
            String gender = String.valueOf(add_member_gender_combobox.getSelectedItem());
            String age = add_member_age_textfield.getText();
            String phone_number = add_member_phone_textfield.getText();
            String email_address = add_member_email_textfield.getText();
            checkMemberFields.check(name, username, password, gender, age, phone_number, email_address);
        }if (e.getSource()==admin_remove_member){
            open_removeMemberPanel();
        }if (e.getSource()==remove_member_button){
            RemoveMember removeMember = new RemoveMember();
            removeMember.check_password(remove_member_username_textfield.getText());
        }if (e.getSource()==admin_view_members){
            open_viewMembersPanel();
        }if (e.getSource()==vmp_scroll_right){
            viewMembersPanel.scroll_right();
        }if (e.getSource()==vmp_scroll_left){
            viewMembersPanel.scroll_left();
        }if (e.getSource()==vmp_scroll_up){
            viewMembersPanel.scroll_up();
        }if (e.getSource()==vmp_scroll_down){
            viewMembersPanel.scroll_down();
        }if (e.getSource()==search_member){
            if (!searching_member){
                search_panel.setVisible(true);
                searching_member = true;
            }else{
                searching_member = false;
                search_panel.setVisible(false);
                if (search_member_textfield.getText().length()>0){
                    search_member(search_member_textfield.getText());
                }
            }
        }if (e.getSource()==back_from_vamp){
            open_viewMembersPanel();
        }if (e.getSource()==admin_add_employee){
            openAddEmployeePanel();
        }if (e.getSource()==add_employee_button){
            CheckEmployeeFields checkEmployeeFields = new CheckEmployeeFields();
            String employee_username = add_employee_username_textfield.getText();
            String employee_password = add_employee_password_textfield.getText();
            String employee_name = add_employee_name_textfield.getText();
            String employee_age = add_employee_age_textfield.getText();
            String employee_gender = String.valueOf(add_employee_gender_combobox.getSelectedItem());
            String employee_job = add_employee_job_textfield.getText();
            String employeee_phone = add_employee_phone_textfield.getText();
            String employee_email = add_employee_email_textfield.getText();
            checkEmployeeFields.check(employee_name, employee_username, employee_password, employee_gender, employee_age, employee_job, employeee_phone, employee_email);
        }if (e.getSource()==admin_remove_employee){
            openRemoveEmployeePanel();
        }if (e.getSource()==remove_employee_button){
            new CheckEmployeeDeletion(remove_employee_username_textfield.getText());
        }if (e.getSource()==admin_view_employees){
            openViewEmployeesPanel();
        }if (e.getSource()==vep_scroll_right){
            viewEmployeesPanel.scroll_right();
        }if (e.getSource()==vep_scroll_left){
            viewEmployeesPanel.scroll_left();
        }if (e.getSource()== eap_scroll_up){
            viewEmployeesPanel.scroll_up();
        }if (e.getSource()== eap_scroll_down){
            viewEmployeesPanel.scroll_down();
        }if (e.getSource()==search_employee){
            if (!searching_employee){
                search_employee_panel.setVisible(true);
                searching_employee = true;
            }else{
                searching_employee = false;
                search_member_textfield.setText("");
                search_employee_panel.setVisible(false);
                if (search_employee_textfield.getText().length()>0){
                    search_employee(search_employee_textfield.getText());
                }
            }
        }if (e.getSource()==back_from_vaep){
            openViewEmployeesPanel();
        }if (e.getSource()==admin_page_attendance_button){
            openAttendancePanel();
        }if (e.getSource()==add_date_button){
            CheckDate checkDate = new CheckDate(addDateTextField.getText());
            checkDate.check_date();
        }if (e.getSource()==searchEmployeeAttendanceButton){
            SearchEmployeeInAttendance searchEmployeeInAttendance = new SearchEmployeeInAttendance();
            a_user = searchEmployeeInAttendance.search_employee_in_attendance(search_employee_attendance_textfield.getText());
            if (a_user.equals("No such User")){
                new UserNotExist();
            }else{
                openEmployeeAttendancePanel(a_user);
            }
        }if (e.getSource()==eap_scroll_up){
            employeeAttendancePanel.scroll_up();
        }if (e.getSource()==eap_scroll_down){
            employeeAttendancePanel.scroll_down();
        }if (e.getSource()==markAttendanceButton){
            MarkAttendance markAttendance = new MarkAttendance(String.valueOf(presence_absence.getSelectedItem()), String.valueOf(date_box.getSelectedItem()), a_user);
            markAttendance.mark_attendance();
        }if (e.getSource()==admin_page_catalogue_button){
            admin_home_page_panel.setVisible(false);
            adminBookCataloguePanel.setVisible(true);
        }if (e.getSource()==addBook){
            adminBookCataloguePanel.setVisible(false);
            addBookPanel.setVisible(true);
        }if (e.getSource()==add_book_button){
            String name = add_book_name_textfield.getText();
            String isbn = add_book_isbn_textfield.getText();
            String author = add_book_author_textfield.getText();
            String publisher = add_book_publisher_textfield.getText();
            String genre = add_book_genre_textfield.getText();
            String damage_level = add_book_dl_textfield.getText();
            AddBookToDatabase addBookToDatabase = new AddBookToDatabase(name, isbn, author, publisher, genre, damage_level);
            addBookToDatabase.check_fields();
        }if (e.getSource()==removeBook){
            adminBookCataloguePanel.setVisible(false);
            removeBookPanel.setVisible(true);
        }if (e.getSource()==remove_book_button){
            RemoveBookClass removeBookClass = new RemoveBookClass(remove_book_textfield.getText());
            removeBookClass.check_book_in_database();
        }if (e.getSource()==viewBook){
            openAdminViewBooksPanel();
        }if (e.getSource()==vbp_scroll_right){
            viewBooksPanel.scroll_right();
        }if (e.getSource()==vbp_scroll_left){
            viewBooksPanel.scroll_left();
        }if (e.getSource()==admin_page_requests_button){
            openAdminSentRecieved();
        }if (e.getSource()==admin_view_recieved_requests){
            openAdminViewRequests();
        }if (e.getSource()==admin_vr_scroll_up){
            adminViewRequests.scroll_up();
        }if (e.getSource()==admin_vr_scroll_down){
            adminViewRequests.scroll_down();
        }if (e.getSource()==admin_view_sent_messages){
            openAdminViewMessages();
        }if (e.getSource()==admin_vm_scroll_up){
            adminViewMessages.scroll_up();
        }if (e.getSource()==admin_vm_scroll_down){
            adminViewMessages.scroll_down();
        }if (e.getSource()==adminMessageButton){
            exitAdminViewMessages();
            adminMessagePanel.setVisible(true);
        }if (e.getSource()==adminSendMessage){
            SendMessage sendMessage = new SendMessage();
            sendMessage.send_message(admin_enter_user_textfield.getText(), admin_message_textfield.getText());
        }
    }

   public void mousePressed(MouseEvent e) {
        if (slide_x==0 && e.getX()<141){
            if (e.getY()>60 && e.getY()<90){
                open_aboutPanel();
            }else if (e.getY()>90 && e.getY()<120){
                move_to_login_page();
            }else if (e.getY()>120 && e.getY()<150){
                open_creditsPanel();
            }
        }
        if (admin_slide_x==0 && e.getX()<141){
            if (e.getY()>60 && e.getY()<90){
                open_admin_account();
            }
            else if (e.getY()>90 && e.getY()<120){
                openAdminEmployeesPanel();
            }else if (e.getY()>120 && e.getY()<150){
                open_admin_members_panel();
            }else if (e.getY()>150 && e.getY()<180){
                move_to_admin_info_update();
            }else if (e.getY()>180 && e.getY()<210){
                logout_admin_account();
            }
        }if (admin_home_page_panel.isVisible()){
            if (e.getX()>400 && e.getX()<600 && e.getY()>100 && e.getY()<250){
                new AdminProfileSetFrame();
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e){
    }
}
