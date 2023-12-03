package com.tuana9a.learnjavajdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Statement statement = databaseManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product;");
        while (resultSet.next()) System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
        statement.close();
        databaseManager.disconnect();
    }
}
