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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TeacherStudents extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textSearch;
    private JTable table;

    public TeacherStudents() {

        setTitle("School Management System - My Students");
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
        lblTeacher.setBounds(800, 25, 140, 25);
        headerPanel.add(lblTeacher);

        // =========================
        // PAGE TITLE
        // =========================

        JLabel lblPageTitle = new JLabel("My Students");
        lblPageTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblPageTitle.setBounds(40, 105, 300, 40);
        contentPane.add(lblPageTitle);

        JLabel lblDescription = new JLabel(
                "View and manage students assigned to your class."
        );
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDescription.setBounds(40, 145, 500, 25);
        contentPane.add(lblDescription);

        // =========================
        // SEARCH
        // =========================

        JLabel lblSearch = new JLabel("Search Student:");
        lblSearch.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSearch.setBounds(40, 190, 120, 30);
        contentPane.add(lblSearch);

        textSearch = new JTextField();
        textSearch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textSearch.setBounds(160, 190, 300, 30);
        contentPane.add(textSearch);

        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnSearch.setBounds(470, 190, 100, 30);
        contentPane.add(btnSearch);

        // =========================
        // STUDENT TABLE
        // =========================

        String[] columns = {
                "Student ID",