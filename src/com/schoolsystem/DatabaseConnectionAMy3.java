package com.schoolsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/school_management_system";

    private static final String USER = "root";

    private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}