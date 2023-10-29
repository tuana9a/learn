package com.tuana9a.learnjavajdbc;

import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) throws Exception {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Statement statement = databaseManager.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("INSERT INTO product VALUES(NULL,'Quan Ao');");

        statement.close();
        databaseManager.disconnect();
    }
}
