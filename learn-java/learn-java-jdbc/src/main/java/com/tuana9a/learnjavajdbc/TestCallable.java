package com.tuana9a.learnjavajdbc;

import java.sql.CallableStatement;
import java.sql.SQLException;

/* CallableStatement
dùng các procedure đã được lưu trong database
lấy được bằng phương thức .prepareCall(String sql) của Connection, sau đó có thể set vị trí như prepareStatement
thực thi bằng .executeQuery của chính nó
trả về một bảng như select bình thường */
public class TestCallable {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        CallableStatement callableStatement = databaseManager.getConnection().prepareCall("SOME_PROCEDURE");
        callableStatement.executeQuery();
        callableStatement.close();
        databaseManager.disconnect();
    }
}
