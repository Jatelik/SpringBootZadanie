package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetMajetok {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public ArrayList<String> majetky = new ArrayList<>();

    public ArrayList<String> getMajetok(String state) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String SQL = "SELECT name FROM inventura_table where state = ? ORDER BY price DESC";

            if (state.equals("removed")) {
                SQL = "SELECT name FROM inventura_table where out_date <> '' ORDER BY price DESC";
            }

            PreparedStatement pstmt = conn.prepareStatement(SQL);

            majetky.clear();
            ResultSet rs;
            switch (state) {
                case "OK":
                    pstmt.setString(1, "O");
                    break;
                case "M":
                    pstmt.setString(1, "M");
                    break;
                case "V":
                    pstmt.setString(1, "V");
                    break;
            }
                rs = pstmt.executeQuery();
                while ( rs.next() ) {
                    String majetok = rs.getString("name");
                    majetky.add(majetok);
                    System.out.println(majetky);
                }
            conn.close();
            return majetky;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

}
