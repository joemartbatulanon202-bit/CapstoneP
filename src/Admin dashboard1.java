package com.schoolsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminDashboard extends JFrame {

    private static final long serialVersionUID = 1L;

    public AdminDashboard() {

        setTitle("School Management System - Admin Dashboard");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 247, 250));

        // Header
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(30, 70, 120));
        header.setBounds(0, 0, 900, 90);

        JLabel title = new JLabel(
                "SCHOOL MANAGEMENT SYSTEM"
        );

        title.setForeground(Color.WHITE);
        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );
        title.setBounds(30, 15, 600, 35);

        header.add(title);

        JLabel adminLabel = new JLabel(
                "ADMIN DASHBOARD"
        );

        adminLabel.setForeground(Color.WHITE);
        adminLabel.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );
        adminLabel.setBounds(30, 50, 300, 25);

        header.add(adminLabel);

        panel.add(header);

        // Dashboard title
        JLabel dashboardTitle =
                new JLabel("Dashboard");

        dashboardTitle.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        dashboardTitle.setBounds(
                40, 115, 300, 35
        );

        panel.add(dashboardTitle);

        // Buttons
        JButton usersButton =
                new JButton("Manage Users");

        usersButton.setBounds(
                40, 175, 200, 60
        );

        panel.add(usersButton);

        JButton studentsButton =
                new JButton("Manage Students");

        studentsButton.setBounds(
                270, 175, 200, 60
        );

        panel.add(studentsButton);

        JButton teachersButton =
                new JButton("Manage Teachers");

        teachersButton.setBounds(
                500, 175, 200, 60
        );

        panel.add(teachersButton);

        JButton subjectsButton =
                new JButton("Manage Subjects");

        subjectsButton.setBounds(
                40, 270, 200, 60
        );

        panel.add(subjectsButton);

        JButton sectionsButton =
                new JButton("Manage Sections");

        sectionsButton.setBounds(
                270, 270, 200, 60
        );

        panel.add(sectionsButton);

        JButton reportsButton =
                new JButton("Reports");

        reportsButton.setBounds(
                500, 270, 200, 60
        );

        panel.add(reportsButton);

        // Logout
        JButton logoutButton =
                new JButton("LOGOUT");

        logoutButton.setBounds(
                700, 500, 120, 35
        );

        panel.add(logoutButton);

        logoutButton.addActionListener(e -> {

            Login login = new Login();
            login.setVisible(true);

            dispose();
        });

        add(panel);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            AdminDashboard dashboard =
                    new AdminDashboard();

            dashboard.setVisible(true);
        });
    }
}