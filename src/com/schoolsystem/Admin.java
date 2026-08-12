package com.schoolsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Admin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public Admin() {

        setTitle("School Management System - Admin");
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // =========================
        // HEADER
        // =========================

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 204));
        headerPanel.setBounds(0, 0, 984, 80);
        headerPanel.setLayout(null);
        contentPane.add(headerPanel);

        JLabel lblTitle = new JLabel("School Management System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setBounds(30, 15, 400, 35);
        headerPanel.add(lblTitle);

        JLabel lblAdmin = new JLabel("ADMINISTRATOR");
        lblAdmin.setForeground(Color.WHITE);
        lblAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAdmin.setBounds(700, 25, 240, 25);
        headerPanel.add(lblAdmin);

        // =========================
        // SIDE MENU
        // =========================

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(245, 245, 245));
        sidePanel.setBounds(0, 80, 220, 480);
        sidePanel.setLayout(null);
        contentPane.add(sidePanel);

        JLabel lblMenu = new JLabel("ADMIN MENU");
        lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblMenu.setBounds(30, 20, 150, 30);
        sidePanel.add(lblMenu);

        // =========================
        // DASHBOARD
        // =========================

        JButton btnDashboard = new JButton("Dashboard");
        btnDashboard.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnDashboard.setBounds(20, 65, 180, 40);
        sidePanel.add(btnDashboard);

        // =========================
        // MANAGE USERS
        // =========================

        JButton btnUsers = new JButton("Manage Users");
        btnUsers.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnUsers.setBounds(20, 115, 180, 40);
        sidePanel.add(btnUsers);

        // =========================
        // MANAGE STUDENTS
        // =========================

        JButton btnStudents = new JButton("Manage Students");
        btnStudents.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnStudents.setBounds(20, 165, 180, 40);
        sidePanel.add(btnStudents);

        // =========================
        // MANAGE TEACHERS
        // =========================

        JButton btnTeachers = new JButton("Manage Teachers");
        btnTeachers.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnTeachers.setBounds(20, 215, 180, 40);
        sidePanel.add(btnTeachers);

        // =========================
        // MANAGE SUBJECTS
        // =========================

        JButton btnSubjects = new JButton("Manage Subjects");
        btnSubjects.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSubjects.setBounds(20, 265, 180, 40);
        sidePanel.add(btnSubjects);

        // =========================
        // MANAGE SECTIONS
        // =========================

        JButton btnSections = new JButton("Manage Sections");
        btnSections.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSections.setBounds(20, 315, 180, 40);
        sidePanel.add(btnSections);

        // =========================
        // LOGOUT
        // =========================

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogout.setBounds(20, 395, 180, 40);
        sidePanel.add(btnLogout);

        // =========================
        // MAIN CONTENT
        // =========================

        JLabel lblWelcome = new JLabel("Welcome, Administrator!");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblWelcome.setBounds(270, 120, 500, 40);
        contentPane.add(lblWelcome);

        JLabel lblDescription = new JLabel(
                "Manage the school system from the administrator dashboard."
        );
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDescription.setBounds(270, 165, 600, 30);
        contentPane.add(lblDescription);

        // =========================
        // DASHBOARD CARDS
        // =========================

        JPanel studentCard = new JPanel();
        studentCard.setBackground(new Color(240, 248, 255));
        studentCard.setBounds(270, 230, 200, 120);
        studentCard.setLayout(null);
        contentPane.add(studentCard);

        JLabel lblStudentTitle = new JLabel("STUDENTS");
        lblStudentTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblStudentTitle.setBounds(20, 20, 150, 25);
        studentCard.add(lblStudentTitle);

        JLabel lblStudentCount = new JLabel("0");
        lblStudentCount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblStudentCount.setBounds(20, 50, 150, 40);
        studentCard.add(lblStudentCount);

        JPanel teacherCard = new JPanel();
        teacherCard.setBackground(new Color(240, 248, 255));
        teacherCard.setBounds(490, 230, 200, 120);
        teacherCard.setLayout(null);
        contentPane.add(teacherCard);

        JLabel lblTeacherTitle = new JLabel("TEACHERS");
        lblTeacherTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTeacherTitle.setBounds(20, 20, 150, 25);
        teacherCard.add(lblTeacherTitle);

        JLabel lblTeacherCount = new JLabel("0");
        lblTeacherCount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTeacherCount.setBounds(20, 50, 150, 40);
        teacherCard.add(lblTeacherCount);

        JPanel subjectCard = new JPanel();
        subjectCard.setBackground(new Color(240, 248, 255));
        subjectCard.setBounds(710, 230, 200, 120);
        subjectCard.setLayout(null);
        contentPane.add(subjectCard);

        JLabel lblSubjectTitle = new JLabel("SUBJECTS");
        lblSubjectTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSubjectTitle.setBounds(20, 20, 150, 25);
        subjectCard.add(lblSubjectTitle);

        JLabel lblSubjectCount = new JLabel("0");
        lblSubjectCount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblSubjectCount.setBounds(20, 50, 150, 40);
        subjectCard.add(lblSubjectCount);

        // =========================
        // LOGOUT ACTION
        // =========================

        btnLogout.addActionListener(e -> {

            Login login = new Login();
            login.setVisible(true);

            dispose();
        });
    }
}