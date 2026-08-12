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

public class Student extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public Student() {

        setTitle("School Management System - Student");
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ==========================================
        // BLUE HEADER
        // ==========================================

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 204));
        headerPanel.setBounds(0, 0, 984, 80);
        headerPanel.setLayout(null);
        contentPane.add(headerPanel);

        // ==========================================
        // SCHOOL TITLE
        // ==========================================

        JLabel lblTitle = new JLabel("School Management System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setBounds(30, 15, 450, 35);
        headerPanel.add(lblTitle);

        // ==========================================
        // STUDENT LABEL
        // ==========================================

        JLabel lblStudent = new JLabel("STUDENT");
        lblStudent.setForeground(Color.WHITE);
        lblStudent.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblStudent.setHorizontalAlignment(SwingConstants.RIGHT);
        lblStudent.setBounds(700, 20, 240, 30);
        headerPanel.add(lblStudent);

        // ==========================================
        // PAGE TITLE
        // ==========================================

        JLabel lblDashboard = new JLabel("Student Dashboard");
        lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblDashboard.setBounds(40, 110, 400, 40);
        contentPane.add(lblDashboard);

        // ==========================================
        // WELCOME MESSAGE
        // ==========================================

        JLabel lblWelcome = new JLabel(
                "Welcome to your student account."
        );
        lblWelcome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblWelcome.setBounds(40, 150, 400, 25);
        contentPane.add(lblWelcome);

        // ==========================================
        // VIEW GRADES
        // ==========================================

        JButton btnGrades = new JButton("View Grades");
        btnGrades.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnGrades.setBounds(80, 220, 220, 55);
        contentPane.add(btnGrades);

        // ==========================================
        // VIEW ATTENDANCE
        // ==========================================

        JButton btnAttendance = new JButton("View Attendance");
        btnAttendance.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnAttendance.setBounds(350, 220, 220, 55);
        contentPane.add(btnAttendance);

        // ==========================================
        // MY PROFILE
        // ==========================================

        JButton btnProfile = new JButton("My Profile");
        btnProfile.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnProfile.setBounds(620, 220, 220, 55);
        contentPane.add(btnProfile);

        // ==========================================
        // VIEW REPORT
        // ==========================================

        JButton btnReport = new JButton("View Report");
        btnReport.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnReport.setBounds(80, 310, 220, 55);
        contentPane.add(btnReport);

        // ==========================================
        // LOGOUT
        // ==========================================

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnLogout.setBounds(620, 310, 220, 55);
        contentPane.add(btnLogout);

        // ==========================================
        // VIEW GRADES ACTION
        // ==========================================

        btnGrades.addActionListener(e -> {

            StudentGrades grades = new StudentGrades();
            grades.setVisible(true);

        });

        // ==========================================
        // VIEW ATTENDANCE ACTION
        // ==========================================

        btnAttendance.addActionListener(e -> {

            StudentAttendance attendance = new StudentAttendance();
            attendance.setVisible(true);

        });

        // ==========================================
        // VIEW REPORT ACTION
        // ==========================================

        btnReport.addActionListener(e -> {

            PDFReport report = new PDFReport();
            report.setVisible(true);

        });

        // ==========================================
        // LOGOUT ACTION
        // ==========================================

        btnLogout.addActionListener(e -> {

            Login login = new Login();
            login.setVisible(true);

            dispose();
        });
    }
}