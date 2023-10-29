package com.tuana9a.learnjavajdbc;

import java.sql.SQLException;
import java.sql.Statement;

/* Batch
khi bạn muốn thực hiện nhiều câu lệnh một lúc
thực hiện được bằng .addBath() của Statement hoặc
    PreparedStatement sau đó dùng .excuteBatch() để thực hiện */
public class TestBatch {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Statement statement = databaseManager.getConnection().createStatement();
        statement.addBatch("SQL1");
        statement.addBatch("SQL2");

        statement.executeBatch();

        statement.close();
        databaseManager.disconnect();
    }
}
