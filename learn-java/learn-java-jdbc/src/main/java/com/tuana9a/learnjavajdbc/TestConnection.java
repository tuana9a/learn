package com.tuana9a.learnjavajdbc;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/* DatabaseMetaData
là một class chứa thông tin của database
lấy được bằng phương thức của .getMetaData() của Connection */
public class TestConnection {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        DatabaseMetaData databaseMetaData = databaseManager.getConnection().getMetaData();
        System.out.println(databaseMetaData);
    }
}
