package com.tuana9a.learnjavaservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    private static final DatabaseManager instance = new DatabaseManager();

    private DatabaseManager() {

    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    public Connection createConnection(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

}
