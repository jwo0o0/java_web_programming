package com.week_7_practice;

import java.sql.*;

public class MyDB {
    Connection con;
    public MyDB() {
        String url = "jdbc:mysql://localhost/week_7_practice";
        String userid = "root";
        String password = "wooar85_ju";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("MySQL Server JDBC Driver Loaded succesfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //System.out.println("connecting to databases...");
            con = DriverManager.getConnection(url, userid, password);
            //System.out.println("connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
}
