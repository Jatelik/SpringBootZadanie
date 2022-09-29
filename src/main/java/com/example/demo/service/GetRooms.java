package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetRooms {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public ArrayList<String> rooms = new ArrayList<>();

    public ArrayList<String> getRooms() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT DISTINCT room FROM inventura_table");
            while ( rs.next() ) {
                String room = rs.getString("room");
                rooms.add(room);
                System.out.println(room);
            }
            conn.close();
            return rooms;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
