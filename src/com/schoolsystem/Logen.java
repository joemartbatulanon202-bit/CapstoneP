package com.schoolsystem;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {

        setTitle("School Management System");
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // =========================
        // TITLE
        // =========================

        JLabel lblTitle = new JLabel("School Management System");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblTitle.setBounds(300, 35, 400, 40);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle);

        // =========================
        // FULL NAME
        // =========================

        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblFullName.setBounds(250, 150, 100, 25);
        contentPane.add(lblFullName);

        textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBounds(350, 147, 300, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        // =========================
        // PASSWORD
        // =========================

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPassword.setBounds(250, 200, 100, 25);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBounds(350, 197, 300, 30);
        contentPane.add(passwordField);

        // =========================
        // SELECT ROLE
        // =========================

        JLabel lblRole = new JLabel("Select Role");
        lblRole.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblRole.setBounds(250, 250, 100, 25);
        contentPane.add(lblRole);

        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBounds(350, 247, 300, 30);

        comboBox.addItem("Select Role");
        comboBox.addItem("Admin");
        comboBox.addItem("Teacher");
        comboBox.addItem("Student");

        contentPane.add(comboBox);

        // =========================
        // REMEMBER ME
        // =========================

        JCheckBox chckbxRemember = new JCheckBox("Remember me");
        chckbxRemember.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        chckbxRemember.setBackground(Color.WHITE);
        chckbxRemember.setBounds(350, 290, 120, 25);
        contentPane.add(chckbxRemember);

        // =========================
        // FORGOT PASSWORD
        // =========================

        JButton btnForgot = new JButton("Forgot Password?");
        btnForgot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnForgot.setBorderPainted(false);
        btnForgot.setContentAreaFilled(false);
        btnForgot.setBounds(500, 290, 150, 25);
        contentPane.add(btnForgot);

        // =========================
        // LOGIN BUTTON
        // =========================

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnLogin.setBounds(350, 340, 140, 40);
        contentPane.add(btnLogin);

        // =========================
        // CLEAR BUTTON
        // =========================

        JButton btnClear = new JButton("CLEAR");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnClear.setBounds(510, 340, 140, 40);
        contentPane.add(btnClear);

        // =========================
        // LOGIN ACTION
        // =========================

        btnLogin.addActionListener(e -> {

            String fullName = textField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) comboBox.getSelectedItem();

            if (fullName.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your full name.",
                        "Login",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your password.",
                        "Login",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (role.equals("Select Role")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select your role.",
                        "Login",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!\nWelcome " + fullName
                    + "\nRole: " + role,
                    "Login",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =========================
        // CLEAR ACTION
        // =========================

        btnClear.addActionListener(e -> {

            textField.setText("");
            passwordField.setText("");
            comboBox.setSelectedIndex(0);
            chckbxRemember.setSelected(false);
        });

        // =========================
        // FORGOT PASSWORD ACTION
        // =========================

        btnForgot.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Password recovery will be added later.",
                    "Forgot Password",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
    }
}