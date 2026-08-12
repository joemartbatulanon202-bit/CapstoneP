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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GradeManager extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTable table;

    public GradeManager() {

        setTitle("School Management System - Manage Grades");
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

        JLabel lblPageTitle = new JLabel("Manage Grades");
        lblPageTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblPageTitle.setBounds(40, 105, 300, 40);
        contentPane.add(lblPageTitle);

        JLabel lblDescription = new JLabel(
                "Enter and manage student grades."
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
        comboSection.setBounds(105, 190, 180, 30);

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
        lblSubject.setBounds(310, 190, 70, 30);
        contentPane.add(lblSubject);

        JComboBox<String> comboSubject = new JComboBox<>();
        comboSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboSubject.setBounds(375, 190, 180, 30);

        comboSubject.addItem("Select Subject");
        comboSubject.addItem("Mathematics");
        comboSubject.addItem("English");
        comboSubject.addItem("Science");
        comboSubject.addItem("Programming");

        contentPane.add(comboSubject);

        // =========================
        // QUARTER
        // =========================

        JLabel lblQuarter = new JLabel("Quarter:");
        lblQuarter.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblQuarter.setBounds(580, 190, 70, 30);
        contentPane.add(lblQuarter);

        JComboBox<String> comboQuarter = new JComboBox<>();
        comboQuarter.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboQuarter.setBounds(650, 190, 150, 30);

        comboQuarter.addItem("Select Quarter");
        comboQuarter.addItem("Quarter 1");
        comboQuarter.addItem("Quarter 2");
        comboQuarter.addItem("Quarter 3");
        comboQuarter.addItem("Quarter 4");

        contentPane.add(comboQuarter);

        // =========================
        // TABLE
        // =========================

        String[] columns = {
                "Student ID",
                "Student Name",
                "Quiz",
                "Activity",
                "Exam",
                "Final Grade"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(28);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 245, 900, 210);
        contentPane.add(scrollPane);

        // =========================
        // BUTTONS
        // =========================

        JButton btnCalculate = new JButton("Calculate Grade");
        btnCalculate.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCalculate.setBounds(40, 480, 150, 35);
        contentPane.add(btnCalculate);

        JButton btnSave = new JButton("Save Grade");
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnSave.setBounds(205, 480, 130, 35);
        contentPane.add(btnSave);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnClear.setBounds(350, 480, 100, 35);
        contentPane.add(btnClear);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnBack.setBounds(810, 480, 130, 35);
        contentPane.add(btnBack);

        // =========================
        // BUTTON ACTIONS
        // =========================

        btnCalculate.addActionListener(e -> {

            // Grade calculation will be connected
            // to GradeCalculator.java later.

        });

        btnSave.addActionListener(e -> {

            // MySQL save operation will be added later.

        });

        btnClear.addActionListener(e -> {

            comboSection.setSelectedIndex(0);
            comboSubject.setSelectedIndex(0);
            comboQuarter.setSelectedIndex(0);

            model.setRowCount(0);
        });

        btnBack.addActionListener(e -> dispose());
    }
}