package com.tuana9a.learnjavajdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelectScrollable {
    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.fromEnv();

        String sql = "SELECT * FROM product;";
        PreparedStatement statement = databaseManager.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));

        statement.close();
        databaseManager.disconnect();
    }
}
