package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAll {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public void deleteAll() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        String SQL = "truncate inventura_table";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(SQL);
    }

}
