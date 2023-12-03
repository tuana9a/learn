package com.tuana9a.learnjavajdbc;

import java.sql.ResultSet;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) throws Exception {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Statement statement = databaseManager.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("UPDATE product SET name='Dien Thoai' WHERE id=1");

        statement.close();
        databaseManager.disconnect();
    }
}
