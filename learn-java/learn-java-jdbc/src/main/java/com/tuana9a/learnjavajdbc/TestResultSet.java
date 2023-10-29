package com.tuana9a.learnjavajdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/* ResultSet
là một class xử lý và chứa kết quả trả về từ SELECT
lấy được sau khi Statement(hoặc PrepareStatement) được execute
tác dụng là đọc kết quả trả về (có một con trỏ trỏ tới row của bảng trả về)
có phương thức get để lấy data tương ứng */
public class TestResultSet {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Statement statement = databaseManager.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM product;");
        while (resultSet.next()) System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));

        /* ResultSetMetaData
        là một class chứa thông tin của kết quả trả về
        lấy được bằng phương thức .getMetaData() của ResultSet */
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        statement.close();
        databaseManager.disconnect();
    }
}
