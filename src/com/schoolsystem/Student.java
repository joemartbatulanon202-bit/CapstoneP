package com.schoolsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textFullName;
    private JPasswordField passwordField;
    private JComboBox<String> comboRole;

    public Login() {

        setTitle("School Management System - Login");
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
        headerPanel.setBounds(0, 0, 984, 90);
        headerPanel.setLayout(null);
        contentPane.add(headerPanel);

        JLabel lblTitle = new JLabel("School Management System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(250, 20, 480, 45);
        headerPanel.add(lblTitle);

        // ==========================================
        // LOGIN TITLE
        // ==========================================

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBounds(350, 120, 300, 45);
        contentPane.add(lblLogin);

        JLabel lblSubtitle = new JLabel(
                "Enter your account information to continue"
        );
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitle.setBounds(300, 165, 400, 25);
        contentPane.add(lblSubtitle);

        // ==========================================
        // FULL NAME
        // ==========================================

        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblFullName.setBounds(280, 215, 120, 30);
        contentPane.add(lblFullName);

        textFullName = new JTextField();
        textFullName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textFullName.setBounds(400, 215, 320, 35);
        contentPane.add(textFullName);

        // ==========================================
        // PASSWORD
        // ==========================================

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPassword.setBounds(280, 270, 120, 30);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBounds(400, 270, 320, 35);
        contentPane.add(passwordField);

        // ==========================================
        // ROLE
        // ==========================================

        JLabel lblRole = new JLabel("Select Role");
        lblRole.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblRole.setBounds(280, 325, 120, 30);
        contentPane.add(lblRole);

        comboRole = new JComboBox<String>();
        comboRole.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboRole.setBounds(400, 325, 320, 35);

        comboRole.addItem("Select Role");
        comboRole.addItem("Admin");
        comboRole.addItem("Teacher");
        comboRole.addItem("Student");

        contentPane.add(comboRole);

        // ==========================================
        // REMEMBER ME
        // ==========================================

        JCheckBox checkRemember = new JCheckBox("Remember me");
        checkRemember.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        checkRemember.setBackground(Color.WHITE);
        checkRemember.setBounds(400, 370, 150, 25);
        contentPane.add(checkRemember);

        // ==========================================
        // LOGIN BUTTON
        // ==========================================

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnLogin.setBounds(400, 415, 150, 42);
        contentPane.add(btnLogin);

        // ==========================================
        // CLEAR BUTTON
        // ==========================================

        JButton btnClear = new JButton("CLEAR");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnClear.setBounds(570, 415, 150, 42);
        contentPane.add(btnClear);

        // ==========================================
        // FORGOT PASSWORD
        // ==========================================

        JButton btnForgot = new JButton("Forgot Password?");
        btnForgot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnForgot.setBorderPainted(false);
        btnForgot.setContentAreaFilled(false);
        btnForgot.setBounds(500, 462, 160, 30);
        contentPane.add(btnForgot);

        // ==========================================
        // LOGIN ACTION
        // ==========================================

        btnLogin.addActionListener(e -> {

            String fullName = textFullName.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) comboRole.getSelectedItem();

            if (fullName.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Please enter your full name.",
                        "Login",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (password.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Please enter your password.",
                        "Login",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if ("Select Role".equals(role)) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Please select your role.",
                        "Login",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // ==========================================
            // TEMPORARY ROLE NAVIGATION
            // ==========================================

            if ("Admin".equals(role)) {

                Admin admin = new Admin();
                admin.setVisible(true);
                dispose();

            } else if ("Teacher".equals(role)) {

                Teacher teacher = new Teacher();
                teacher.setVisible(true);
                dispose();

            } else if ("Student".equals(role)) {

                Student student = new Student();
                student.setVisible(true);
                dispose();
            }
        });

        // ==========================================
        // CLEAR ACTION
        // ==========================================

        btnClear.addActionListener(e -> {

            textFullName.setText("");
            passwordField.setText("");
            comboRole.setSelectedIndex(0);
            checkRemember.setSelected(false);
        });

        // ==========================================
        // FORGOT PASSWORD
        // ==========================================

        btnForgot.addActionListener(e -> {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Password recovery will be added later.",
                    "Forgot Password",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
        });
    }
}