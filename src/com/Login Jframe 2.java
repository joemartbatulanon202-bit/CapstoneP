package com.schoolsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(5, 2, 10, 10)
        );

        // Full Name
        JLabel fullNameLabel =
                new JLabel("Full Name:");

        fullNameField =
                new JTextField();

        // Password
        JLabel passwordLabel =
                new JLabel("Password:");

        passwordField =
                new JPasswordField();

        // Role
        JLabel roleLabel =
                new JLabel("Role:");

        roleComboBox =
                new JComboBox<>(
                        new String[]{
                                "Admin",
                                "Teacher",
                                "Student"
                        }
                );

        // Buttons
        JButton loginButton =
                new JButton("Login");

        JButton exitButton =
                new JButton("Exit");

        // Add components
        panel.add(fullNameLabel);
        panel.add(fullNameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(roleLabel);
        panel.add(roleComboBox);

        panel.add(new JLabel());
        panel.add(new JLabel());

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
                            "Login successful!\n"
                            + "Welcome, "
                            + fullName
                            + "\nRole: "
                            + role
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid full name, password, or role.",
                            "Login Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Database error:\n"
                        + ex.getMessage(),
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