package com.schoolsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField fullNameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public Login() {

        setTitle("School Management System - Login");
        setSize(500, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();

        panel.setBackground(
                new Color(245, 247, 250)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 40, 25, 40
                )
        );

        panel.setLayout(
                new GridLayout(5, 2, 10, 15)
        );

        // Title
        JLabel titleLabel =
                new JLabel(
                        "SCHOOL MANAGEMENT SYSTEM"
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        titleLabel.setHorizontalAlignment(
                JLabel.CENTER
        );

        // Full Name
        JLabel fullNameLabel =
                new JLabel("Full Name:");

        fullNameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        fullNameField =
                new JTextField();

        // Password
        JLabel passwordLabel =
                new JLabel("Password:");

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        passwordField =
                new JPasswordField();

        // Role
        JLabel roleLabel =
                new JLabel("Role:");

        roleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        roleComboBox =
                new JComboBox<>(
                        new String[] {
                                "Admin",
                                "Teacher",
                                "Student"
                        }
                );

        // Login button
        JButton loginButton =
                new JButton("LOGIN");

        loginButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        loginButton.setBackground(
                new Color(46, 125, 50)
        );

        loginButton.setForeground(
                Color.WHITE
        );

        // Exit button
        JButton exitButton =
                new JButton("EXIT");

        exitButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        exitButton.setBackground(
                new Color(180, 40, 40)
        );

        exitButton.setForeground(
                Color.WHITE
        );

        // Add components
        panel.add(titleLabel);
        panel.add(new JLabel());

        panel.add(fullNameLabel);
        panel.add(fullNameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(roleLabel);
        panel.add(roleComboBox);

        panel.add(loginButton);
        panel.add(exitButton);

        add(panel);

        // Login button
        loginButton.addActionListener(e -> {

            String fullName =
                    fullNameField
                            .getText()
                            .trim();

            String password =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            String role =
                    roleComboBox
                            .getSelectedItem()
                            .toString();

            if (fullName.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your full name and password.",
                        "Login",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            String sql =
                    "SELECT * FROM users " +
                    "WHERE full_name = ? " +
                    "AND password = ? " +
                    "AND role = ?";

            try (
                    Connection connection =
                            DatabaseConnection
                                    .getConnection();

                    PreparedStatement statement =
                            connection.prepareStatement(sql)
            ) {

                statement.setString(
                        1,
                        fullName
                );

                statement.setString(
                        2,
                        password
                );

                statement.setString(
                        3,
                        role
                );

                ResultSet result =
                        statement.executeQuery();

                if (result.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Login successful!\n\n"
                            + "Welcome, "
                            + fullName
                            + "\nRole: "
                            + role,
                            "Login Successful",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid full name, password, or role.",
                            "Login Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Database error:\n"
                        + e.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // Exit button
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            Login login =
                    new Login();

            login.setVisible(true);
        });
    }
}