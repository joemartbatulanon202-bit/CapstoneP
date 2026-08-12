package com.schoolsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StudentAttendance extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public StudentAttendance() {

        setTitle("School Management System - Attendance");
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 204));
        headerPanel.setBounds(0, 0, 984, 80);
        headerPanel.setLayout(null);
        contentPane.add(headerPanel);

        JLabel lblTitle = new JLabel("School Management System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setBounds(30, 15, 450, 35);
        headerPanel.add(lblTitle);

        JLabel lblStudent = new JLabel("STUDENT ATTENDANCE");
        lblStudent.setForeground(Color.WHITE);
        lblStudent.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblStudent.setHorizontalAlignment(SwingConstants.RIGHT);
        lblStudent.setBounds(650, 20, 290, 30);
        headerPanel.add(lblStudent);

        // Page title
        JLabel lblPageTitle = new JLabel("My Attendance");
        lblPageTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblPageTitle.setBounds(40, 105, 350, 40);
        contentPane.add(lblPageTitle);

        // Attendance table
        String[] columns = {
                "Date",
                "Subject",
                "Time",
                "Status"
        };

        Object[][] data = {
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""}
        };

        JTable table = new JTable(data, columns);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 170, 900, 250);
        contentPane.add(scrollPane);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBack.setBounds(800, 460, 140, 40);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> dispose());
    }
}