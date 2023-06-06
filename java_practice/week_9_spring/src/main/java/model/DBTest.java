package model;

import model.DAO;

import java.sql.*;

public class DBTest implements DAO {
    Connection con;

    public DBTest() {
        String url = "jdbc:mysql://localhost/week_9_spring";
        String userid = "root";
        String password = "wooar85_ju";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Server JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Connecting to database ...");
            con = DriverManager.getConnection(url, userid, password);
            System.out.println("Connected ...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void extract() {
        String query = "SELECT * FROM Book";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) +
                        "\t\t" + rs.getString(3) + "\t" + rs.getInt(4));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
