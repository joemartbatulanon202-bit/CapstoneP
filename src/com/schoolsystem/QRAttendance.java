package com.schoolsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class Attendance extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textQR;
    private JTable table;

    public Attendance() {

        setTitle("School Management System - QR Attendance");
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        // PAGE TITLE
        // =========================

        JLabel lblPageTitle = new JLabel("QR Attendance");
        lblPageTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblPageTitle.setBounds(40, 105, 300, 40);
        contentPane.add(lblPageTitle);

        JLabel lblDescription = new JLabel(
                "Scan student QR codes to record attendance."
        );
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDescription.setBounds(40, 145, 500, 25);
        contentPane.add(lblDescription);

        // =========================
        // SECTION
        // =========================

        JLabel lblSection = new JLabel("Section:");
        lblSection.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSection.setBounds(40, 190, 70, 30);
        contentPane.add(lblSection);

        JComboBox<String> comboSection = new JComboBox<>();
        comboSection.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboSection.setBounds(110, 190, 180, 30);

        comboSection.addItem("Select Section");
        comboSection.addItem("ICT 12-A");
        comboSection.addItem("STEM 12-A");
        comboSection.addItem("ABM 12-A");
        comboSection.addItem("HUMSS 12-A");

        contentPane.add(comboSection);

        // =========================
        // SUBJECT
        // =========================

        JLabel lblSubject = new JLabel("Subject:");
        lblSubject.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSubject.setBounds(320, 190, 70, 30);
        contentPane.add(lblSubject);

        JComboBox<String> comboSubject = new JComboBox<>();
        comboSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboSubject.setBounds(385, 190, 180, 30);

        comboSubject.addItem("Select Subject");
        comboSubject.addItem("Mathematics");
        comboSubject.addItem("English");
        comboSubject.addItem("Science");
        comboSubject.addItem("Programming");

        contentPane.add(comboSubject);

        // =========================
        // QR INPUT
        // =========================

        JLabel lblQR = new JLabel("QR Code:");
        lblQR.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblQR.setBounds(40, 240, 80, 30);
        contentPane.add(lblQR);

        textQR = new JTextField();
        textQR.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textQR.setBounds(120, 240, 300, 30);
        contentPane.add(textQR);

        JButton btnScan = new JButton("SCAN QR");
        btnScan.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnScan.setBounds(435, 240, 120, 30);
        contentPane.add(btnScan);

        // =========================
        // STATUS
        // =========================

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblStatus.setBounds(590, 240, 60, 30);
        contentPane.add(lblStatus);

        JComboBox<String> comboStatus = new JComboBox<>();
        comboStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboStatus.setBounds(650, 240, 150, 30);

        comboStatus.addItem("Present");
        comboStatus.addItem("Late");
        comboStatus.addItem("Absent");

        contentPane.add(comboStatus);

        // =========================
        // ATTENDANCE TABLE
        // =========================

        String[] columns = {
                "Student ID",
                "Student Name",
                "Date",
                "Time",
                "Status"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(28);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 300, 900, 170);
        contentPane.add(scrollPane);

        // =========================
        // BUTTONS
        // =========================

        JButton btnRecord = new JButton("Record Attendance");
        btnRecord.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnRecord.setBounds(40, 495, 170, 35);
        contentPane.add(btnRecord);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnClear.setBounds(225, 495, 100, 35);
        contentPane.add(btnClear);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnBack.setBounds(810, 495, 130, 35);
        contentPane.add(btnBack);

        // =========================
        // SCAN QR ACTION
        // =========================

        btnScan.addActionListener(e -> {

            /*
             * QRScanner.java will be connected here later.
             *
             * Example:
             * String studentID = QRScanner.scan();
             */

            textQR.requestFocus();
        });

        // =========================
        // RECORD ATTENDANCE
        // =========================

        btnRecord.addActionListener(e -> {

            String qrCode = textQR.getText().trim();

            if (qrCode.isEmpty()) {
                return;
            }

            String section =
                    comboSection.getSelectedItem().toString();

            String subject =
                    comboSubject.getSelectedItem().toString();

            String status =
                    comboStatus.getSelectedItem().toString();

            /*
             * MySQL attendance saving will be added later.
             */

            model.addRow(new Object[] {
                    qrCode,
                    "Student Name",
                    "Today",
                    "Time",
                    status
            });

            textQR.setText("");
            textQR.requestFocus();
        });

        // =========================
        // CLEAR
        // =========================

        btnClear.addActionListener(e -> {

            textQR.setText("");
            comboSection.setSelectedIndex(0);
            comboSubject.setSelectedIndex(0);
            comboStatus.setSelectedIndex(0);

            model.setRowCount(0);
        });

        // =========================
        // BACK
        // =========================

        btnBack.addActionListener(e -> dispose());
    }
}