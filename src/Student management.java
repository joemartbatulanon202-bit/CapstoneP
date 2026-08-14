package com.schoolsystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentManagement extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField studentIdField;
    private JTextField fullNameField;
    private JTextField strandField;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    public StudentManagement() {

        setTitle("Student Management");
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel =
                new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        JPanel formPanel =
                new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Full Name:"));
        fullNameField = new JTextField();
        formPanel.add(fullNameField);

        formPanel.add(new JLabel("Strand:"));
        strandField = new JTextField();
        formPanel.add(strandField);

        mainPanel.add(
                formPanel,
                BorderLayout.NORTH
        );

        tableModel =
                new DefaultTableModel(
                        new String[] {
                                "Student ID",
                                "Full Name",
                                "Strand"
                        },
                        0
                );

        studentTable =
                new JTable(tableModel);

        mainPanel.add(
                new JScrollPane(studentTable),
                BorderLayout.CENTER
        );

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(1, 4, 10, 10)
                );

        JButton addButton =
                new JButton("ADD");

        JButton updateButton =
                new JButton("UPDATE");

        JButton deleteButton =
                new JButton("DELETE");

        JButton closeButton =
                new JButton("CLOSE");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(closeButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        loadStudents();

        addButton.addActionListener(e -> addStudent());

        updateButton.addActionListener(e -> updateStudent());

        deleteButton.addActionListener(e -> deleteStudent());

        closeButton.addActionListener(e -> dispose());
    }

    private void loadStudents() {

        tableModel.setRowCount(0);

        String sql =
                "SELECT student_id, full_name, strand " +
                "FROM students";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet result =
                        statement.executeQuery()
        ) {

            while (result.next()) {

                tableModel.addRow(
                        new Object[] {
                                result.getInt("student_id"),
                                result.getString("full_name"),
                                result.getString("strand")
                        }
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database error:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void addStudent() {

        String sql =
                "INSERT INTO students " +
                "(student_id, full_name, strand) " +
                "VALUES (?, ?, ?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    Integer.parseInt(
                            studentIdField.getText()
                    )
            );

            statement.setString(
                    2,
                    fullNameField.getText()
            );

            statement.setString(
                    3,
                    strandField.getText()
            );

            statement.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Student added successfully!"
            );

            loadStudents();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database error:\n"
                    + e.getMessage()
            );
        }
    }

    private void updateStudent() {

        JOptionPane.showMessageDialog(
                this,
                "Update function will be connected next."
        );
    }

    private void deleteStudent() {

        JOptionPane.showMessageDialog(
                this,
                "Delete function will be connected next."
        );
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            StudentManagement window =
                    new StudentManagement();

            window.setVisible(true);
        });
    }
}