package com.schoolsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PDFReport extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public PDFReport() {

        setTitle("School Management System - Report");
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 204));
        headerPanel.setBounds(0, 0, 984, 80);
        headerPanel.setLayout(null);
        contentPane.add(headerPanel);

        JLabel lblTitle = new JLabel("School Management System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setBounds(30, 15, 450, 35);
        headerPanel.add(lblTitle);

        JLabel lblReport = new JLabel("REPORT");
        lblReport.setForeground(Color.WHITE);
        lblReport.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblReport.setHorizontalAlignment(SwingConstants.RIGHT);
        lblReport.setBounds(700, 20, 240, 30);
        headerPanel.add(lblReport);

        // Page title
        JLabel lblPageTitle = new JLabel("Student Report");
        lblPageTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblPageTitle.setBounds(40, 110, 350, 40);
        contentPane.add(lblPageTitle);

        JLabel lblInfo = new JLabel(
                "Generate your grades and attendance report."
        );
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblInfo.setBounds(40, 160, 500, 30);
        contentPane.add(lblInfo);

        // Generate PDF button
        JButton btnGenerate = new JButton("Generate PDF");
        btnGenerate.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnGenerate.setBounds(40, 230, 200, 50);
        contentPane.add(btnGenerate);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBack.setBounds(800, 460, 140, 40);
        contentPane.add(btnBack);

        btnGenerate.addActionListener(e -> {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "PDF generation will be connected later.",
                    "Generate Report",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );

        });

        btnBack.addActionListener(e -> dispose());
    }
}