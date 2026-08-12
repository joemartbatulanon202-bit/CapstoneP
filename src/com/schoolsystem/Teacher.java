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

public class Teacher extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public Teacher() {

        setTitle("School Management System - Teacher");
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

        JLabel lblTeacher = new JLabel("TEACHER");
        lblTeacher.setForeground(Color.WHITE);
        lblTeacher.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTeacher.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTeacher.setBounds(700, 25, 240, 25);
        headerPanel.add(lblTeacher);

        // =========================
        // SIDE MENU
        // =========================

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(245, 245, 245));
        sidePanel.setBounds(0, 80, 220, 480);
        sidePanel.setLayout(null);
        contentPane.add(sidePanel);

        JLabel lblMenu = new JLabel("TEACHER MENU");
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
        // STUDENTS
        // =========================

        JButton btnStudents = new JButton("My Students");
        btnStudents.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnStudents.setBounds(20, 115, 180, 40);
        sidePanel.add(btnStudents);

        // =========================
        // CLASS RECORD
        // =========================

        JButton btnClassRecord = new JButton("Class Record");
        btnClassRecord.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnClassRecord.setBounds(20, 165, 180, 40);
        sidePanel.add(btnClassRecord);

        // =========================
        // GRADES
        // =========================

        JButton btnGrades = new JButton("Manage Grades");
        btnGrades.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGrades.setBounds(20, 215, 180, 40);
        sidePanel.add(btnGrades);

        // =========================
        // QR ATTENDANCE
        // =========================

        JButton btnAttendance = new JButton("QR Attendance");
        btnAttendance.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnAttendance.setBounds(20, 265, 180, 40);
        sidePanel.add(btnAttendance);

        // =========================
        // REPORT
        // =========================

        JButton btnReport = new JButton("Generate Report");
        btnReport.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnReport.setBounds(20, 315, 180, 40);
        sidePanel.add(btnReport);

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

        JLabel lblWelcome = new JLabel("Welcome, Teacher!");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblWelcome.setBounds(270, 120, 500, 40);
        contentPane.add(lblWelcome);

        JLabel lblDescription = new JLabel(
                "Manage your classes, grades, attendance and student records."
        );
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDescription.setBounds(270, 165, 650, 30);
        contentPane.add(lblDescription);

        // =========================
        // STUDENTS CARD
        // =========================

        JPanel studentCard = new JPanel();
        studentCard.setBackground(new Color(240, 248, 255));
        studentCard.setBounds(270, 230, 200, 120);
        studentCard.setLayout(null);
        contentPane.add(studentCard);

        JLabel lblStudentTitle = new JLabel("MY STUDENTS");
        lblStudentTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblStudentTitle.setBounds(20, 20, 160, 25);
        studentCard.add(lblStudentTitle);

        JLabel lblStudentCount = new JLabel("0");
        lblStudentCount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblStudentCount.setBounds(20, 50, 150, 40);
        studentCard.add(lblStudentCount);

        // =========================
        // CLASSES CARD
        // =========================

        JPanel classCard = new JPanel();
        classCard.setBackground(new Color(240, 248, 255));
        classCard.setBounds(490, 230, 200, 120);
        classCard.setLayout(null);
        contentPane.add(classCard);

        JLabel lblClassTitle = new JLabel("MY CLASSES");
        lblClassTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblClassTitle.setBounds(20, 20, 160, 25);
        classCard.add(lblClassTitle);

        JLabel lblClassCount = new JLabel("0");
        lblClassCount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblClassCount.setBounds(20, 50, 150, 40);
        classCard.add(lblClassCount);

        // =========================
        // ATTENDANCE CARD
        // =========================

        JPanel attendanceCard = new JPanel();
        attendanceCard.setBackground(new Color(240, 248, 255));
        attendanceCard.setBounds(710, 230, 200, 120);
        attendanceCard.setLayout(null);
        contentPane.add(attendanceCard);

        JLabel lblAttendanceTitle = new JLabel("ATTENDANCE");
        lblAttendanceTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAttendanceTitle.setBounds(20, 20, 160, 25);
        attendanceCard.add(lblAttendanceTitle);

        JLabel lblAttendanceCount = new JLabel("0");
        lblAttendanceCount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblAttendanceCount.setBounds(20, 50, 150, 40);
        attendanceCard.add(lblAttendanceCount);

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