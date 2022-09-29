package com.example.demo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.InventuraTable;

public class InsertToDB {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertToDB() throws IOException {
        String SQL = "INSERT INTO inventura_table(id, name, room, type, price, in_date, out_date, state) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        InventuraService inventuraService = new InventuraService();
        List<InventuraTable> inventura = inventuraService.getInventura();

        for (int i = 0; i < 6; i++) {
            long id = inventura.get(i).getId();
            try (Connection conn = connect();
                    PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                pstmt.setLong(1, inventura.get(i).getId());
                pstmt.setString(2, inventura.get(i).getName());
                pstmt.setString(3, inventura.get(i).getRoom());
                pstmt.setInt(4, inventura.get(i).getType());
                pstmt.setString(5, inventura.get(i).getPrice());
                pstmt.setLong(6, inventura.get(i).getInDate());
                if (inventura.get(0).getOutDate() != null) {
                    pstmt.setString(7, String.valueOf(inventura.get(i).getOutDate()));
                } else {
                    pstmt.setString(7, "null");
                }
                pstmt.setString(8, inventura.get(i).getState());

                System.out.println(SQL);

                int affectedRows = pstmt.executeUpdate();
                conn.close();
                if (affectedRows > 0) {
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            id = rs.getLong(1);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
