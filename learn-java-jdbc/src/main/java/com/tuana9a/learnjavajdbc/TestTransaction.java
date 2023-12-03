package com.tuana9a.learnjavajdbc;

import java.sql.Connection;
import java.sql.SQLException;

/*  Transaction Statement
    khi bạn muốn hủy giao kèo hoặc undo nhưng thứ đã làm
    .setAutoCommit(boolean b) của Connection mặc định là true nên mọi câu lệnh sẽ dược thực thi
    vậy nếu .setAutoCommit(false)
        thì có thể dùng phương thức là .commit() và .rollback()
            .commit() sẽ thừa nhận là đã giao dịch và không hoàn trả
            .rollback() sẽ hủy giao dịch và hoàn trả lại những gì đã làm
*	trước khi commit mà có SQLException thì tất cả các câu lệnh trước nó đều sẽ bị hủy theo */
public class TestTransaction {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();
        Connection connection = databaseManager.getConnection();

        connection.setAutoCommit(false);
        connection.commit();
        connection.rollback();

        databaseManager.disconnect();
    }
}
