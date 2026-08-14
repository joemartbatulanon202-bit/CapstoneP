package com.schoolsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {

        setTitle("School Management System - Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel =
                new JLabel("Username:");

        JLabel passwordLabel =
                new JLabel("Password:");

        usernameField =
                new JTextField();

        passwordField =
                new JPasswordField();

        JButton loginButton =
                new JButton("Login");

        JButton exitButton =
                new JButton("Exit");

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(exitButton);

        add(panel);

        // Login button
        loginButton.addActionListener(e -> {

            String username =
                    usernameField.getText();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            if (username.equals("admin")
                    && password.equals("admin123")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login successful!"
                );

                // Later:
                // Dashboard dashboard = new Dashboard();
                // dashboard.setVisible(true);
                // dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password.",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // Exit button
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}