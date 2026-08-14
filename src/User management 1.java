package com.schoolsystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UserManagement extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField fullNameField;
    private JTextField usernameField;
    private JTextField passwordField;

    private JComboBox<String> roleComboBox;

    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserManagement() {

        setTitle("School Management System - User Management");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        // =========================
        // FORM PANEL
        // =========================

        JPanel formPanel =
                new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel fullNameLabel =
                new JLabel("Full Name:");

        fullNameField =
                new JTextField();

        JLabel usernameLabel =
                new JLabel("Username:");

        usernameField =
                new JTextField();

        JLabel passwordLabel =
                new JLabel("Password:");

        passwordField =
                new JTextField();

        JLabel roleLabel =
                new JLabel("Role:");

        roleComboBox =
                new JComboBox<>(
                        new String[] {
                                "Admin",
                                "Teacher",
                                "Student"
                        }
                );

        formPanel.add(fullNameLabel);
        formPanel.add(fullNameField);

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        formPanel.add(roleLabel);
        formPanel.add(roleComboBox);

        mainPanel.add(
                formPanel,
                BorderLayout.NORTH
        );

        // =========================
        // TABLE
        // =========================

        tableModel =
                new DefaultTableModel(
                        new String[] {
                                "ID",
                                "Full Name",
                                "Username",
                                "Password",
                                "Role"
                        },
                        0
                ) {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };

        userTable =
                new JTable(tableModel);

        userTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scrollPane =
                new JScrollPane(userTable);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =========================
        // BUTTON PANEL
        // =========================

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(1, 5, 10, 10)
                );

        JButton addButton =
                new JButton("ADD");

        JButton updateButton =
                new JButton("UPDATE");

        JButton deleteButton =
                new JButton("DELETE");

        JButton clearButton =
                new JButton("CLEAR");

        JButton closeButton =
                new JButton("CLOSE");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(closeButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // =========================
        // LOAD USERS
        // =========================

        loadUsers();

        // =========================
        // TABLE SELECTION
        // =========================

        userTable.getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {

                        int row =
                                userTable
                                        .getSelectedRow();

                        if (row >= 0) {

                            fullNameField.setText(
                                    tableModel
                                            .getValueAt(
                                                    row,
                                                    1
                                            )
                                            .toString()
                            );

                            usernameField.setText(
                                    tableModel
                                            .getValueAt(
                                                    row,
                                                    2
                                            )
                                            .toString()
                            );

                            passwordField.setText(
                                    tableModel
                                            .getValueAt(
                                                    row,
                                                    3
                                            )
                                            .toString()
                            );

                            roleComboBox.setSelectedItem(
                                    tableModel
                                            .getValueAt(
                                                    row,
                                                    4
                                            )
                            );
                        }
                    }
                });

        // =========================
        // ADD
        // =========================

        addButton.addActionListener(e -> {

            addUser();
        });

        // =========================
        // UPDATE
        // =========================

        updateButton.addActionListener(e -> {

            updateUser();
        });

        // =========================
        // DELETE
        // =========================

        deleteButton.addActionListener(e -> {

            deleteUser();
        });

        // =========================
        // CLEAR
        // =========================

        clearButton.addActionListener(e -> {

            clearFields();
        });

        // =========================
        // CLOSE
        // =========================

        closeButton.addActionListener(e -> {

            dispose();
        });
    }

    // =====================================
    // LOAD USERS
    // =====================================

    private void loadUsers() {

        tableModel.setRowCount(0);

        String sql =
                "SELECT user_id, full_name, username, " +
                "password, role FROM users " +
                "ORDER BY user_id";

        try (
                Connection connection =
                        DatabaseConnection
                                .getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet result =
                        statement.executeQuery()
        ) {

            while (result.next()) {

                tableModel.addRow(
                        new Object[] {
                                result.getInt("user_id"),
                                result.getString("full_name"),
                                result.getString("username"),
                                result.getString("password"),
                                result.getString("role")
                        }
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database error:\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================
    // ADD USER
    // =====================================

    private void addUser() {

        String fullName =
                fullNameField.getText().trim();

        String username =
                usernameField.getText().trim();

        String password =
                passwordField.getText();

        String role =
                roleComboBox
                        .getSelectedItem()
                        .toString();

        if (fullName.isEmpty()
                || username.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String sql =
                "INSERT INTO users " +
                "(full_name, username, password, role) " +
                "VALUES (?, ?, ?, ?)";

        try (
                Connection connection =
                        DatabaseConnection
                                .getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, fullName);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, role);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "User added successfully!"
            );

            clearFields();
            loadUsers();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to add user:\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================
    // UPDATE USER
    // =====================================

    private void updateUser() {

        int row =
                userTable.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a user first.",
                    "Update User",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int userId =
                Integer.parseInt(
                        tableModel
                                .getValueAt(row, 0)
                                .toString()
                );

        String fullName =
                fullNameField.getText().trim();

        String username =
                usernameField.getText().trim();

        String password =
                passwordField.getText();

        String role =
                roleComboBox
                        .getSelectedItem()
                        .toString();

        if (fullName.isEmpty()
                || username.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String sql =
                "UPDATE users SET " +
                "full_name = ?, " +
                "username = ?, " +
                "password = ?, " +
                "role = ? " +
                "WHERE user_id = ?";

        try (
                Connection connection =
                        DatabaseConnection
                                .getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, fullName);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, role);
            statement.setInt(5, userId);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "User updated successfully!"
            );

            clearFields();
            loadUsers();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to update user:\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================
    // DELETE USER
    // =====================================

    private void deleteUser() {

        int row =
                userTable.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a user first.",
                    "Delete User",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int userId =
                Integer.parseInt(
                        tableModel
                                .getValueAt(row, 0)
                                .toString()
                );

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this user?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql =
                "DELETE FROM users " +
                "WHERE user_id = ?";

        try (
                Connection connection =
                        DatabaseConnection
                                .getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "User deleted successfully!"
            );

            clearFields();
            loadUsers();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to delete user:\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================
    // CLEAR
    // =====================================

    private void clearFields() {

        fullNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");

        roleComboBox.setSelectedIndex(0);

        userTable.clearSelection();
    }

    // =====================================
    // MAIN
    // =====================================

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            UserManagement window =
                    new UserManagement();

            window.setVisible(true);
        });
    }
}