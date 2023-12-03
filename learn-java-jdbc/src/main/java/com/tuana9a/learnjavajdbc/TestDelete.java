package com.tuana9a.learnjavajdbc;

import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) throws Exception {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Statement statement = databaseManager.getConnection().createStatement();
        statement.executeQuery("DELETE FROM product WHERE id=1");

        statement.close();
        databaseManager.disconnect();
    }
}
