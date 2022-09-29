package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PriceToComparable {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public void updatePrice() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        String SQL1 = "UPDATE inventura_table SET price  = REPLACE(price , 'EUR', '') WHERE price LIKE '%EUR'";
        String SQL2 = "UPDATE inventura_table SET price  = REPLACE(price , ',', '.') WHERE price LIKE '%,%'";
        String SQL3 = "ALTER TABLE public.inventura_table ALTER COLUMN price TYPE float8 USING price::float8;";

        Statement stmt1 = conn.createStatement();
        Statement stmt2 = conn.createStatement();
        Statement stmt3 = conn.createStatement();
        stmt1.executeUpdate(SQL1);
        stmt2.executeUpdate(SQL2);
        stmt3.executeUpdate(SQL3);
    }

    public void backToString() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        String SQL1 = "ALTER TABLE public.inventura_table ALTER COLUMN price TYPE varchar(255) USING price::varchar;\n";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(SQL1);
    }

}
