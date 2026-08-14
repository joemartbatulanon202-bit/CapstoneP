package com.schoolsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {

                Login frame = new Login();
                frame.setVisible(true);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }

    public Login() {

        setTitle("School Management System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(
                new EmptyBorder(10, 10, 10, 10)
        );

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // School Logo
        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(
                SwingConstants.CENTER
        );
        lblLogo.setBounds(175, 20, 150, 120);

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource(
                                "/images/school_logo.png"
                        )
                );

        Image image =
                icon.getImage().getScaledInstance(
                        120,
                        120,
                        Image.SCALE_SMOOTH
                );

        lblLogo.setIcon(
                new ImageIcon(image)
        );

        contentPane.add(lblLogo);

        // Title
        JLabel lblTitle =
                new JLabel("SCHOOL MANAGEMENT SYSTEM");

        lblTitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        lblTitle.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        lblTitle.setBounds(50, 145, 400, 35);

        contentPane.add(lblTitle);

        // Username
        JLabel lblUsername =
                new JLabel("Username:");

        lblUsername.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        lblUsername.setBounds(70, 205, 100, 25);

        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(170, 205, 250, 28);

        contentPane.add(txtUsername);

        // Password
        JLabel lblPassword =
                new JLabel("Password:");

        lblPassword.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        lblPassword.setBounds(70, 250, 100, 25);

        contentPane.add(lblPassword);

        txtPassword =
                new JPasswordField();

        txtPassword.setBounds(170, 250, 250, 28);

        contentPane.add(txtPassword);

        // Login button
        JButton btnLogin =
                new JButton("LOGIN");

        btnLogin.setBounds(170, 305, 115, 35);

        contentPane.add(btnLogin);

        // Exit button
        JButton btnExit =
                new JButton("EXIT");

        btnExit.setBounds(305, 305, 115, 35);

        contentPane.add(btnExit);

        // Login action
        btnLogin.addActionListener(e -> {

            String username =
                    txtUsername.getText();

            String password =
                    new String(
                            txtPassword.getPassword()
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

        // Exit action
        btnExit.addActionListener(e -> {

            System.exit(0);
        });
    }
}