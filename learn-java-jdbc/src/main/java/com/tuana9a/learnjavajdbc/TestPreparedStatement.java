package com.tuana9a.learnjavajdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* PreparedStatement
cũng là class để tạo các lệnh, quản lý thực thi chúng
điểm khác là do dược prepared, đã được complied, nên thực thi nhanh hơn
lấy được bằng .prepareStatement() của Connection
đặc trưng query string sẽ có ký tự '?' chính là tham số sẽ truyền vào sau này
    nhưng thường dấu hỏi sẽ được thay bởi tên cột chứ không tên bảng được
    index tính từ 1, NOT từ 0 */
public class TestPreparedStatement {
    public static void main(String[] args) throws Exception {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();

        PreparedStatement statement = databaseManager.getConnection().prepareStatement("INSERT INTO product VALUES(?,?)");
        statement.setString(1, "Giay dep");
        ResultSet resultSet = statement.executeQuery();

        statement.close();
        databaseManager.disconnect();
    }
}
