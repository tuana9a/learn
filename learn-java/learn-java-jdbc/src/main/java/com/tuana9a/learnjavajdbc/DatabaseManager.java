package com.tuana9a.learnjavajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public static DatabaseManager fromEnv() throws SQLException {
        String databaseUrl = System.getenv("DATABASE_URL");
        String databaseUsername = System.getenv("DATABASE_USERNAME");
        String databasePassword = System.getenv("DATABASE_PASSWORD");
        DatabaseManager manager = new DatabaseManager();
        if (manager.connect(databaseUrl, databaseUsername, databasePassword)) {
            System.out.println("connect successfully");
        }
        return manager;
    }

    public boolean connect(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean disconnect() throws SQLException {
        if (connection == null) {
            return true;
        }
        connection.close();
        return connection.isClosed();
    }
}
