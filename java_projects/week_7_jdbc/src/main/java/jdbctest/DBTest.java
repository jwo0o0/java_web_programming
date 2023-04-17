package jdbctest;

import java.sql.*;

public class DBTest {
    Connection con;

    public DBTest() {
        String url = "jdbc:mysql://localhost/jdbctest";
        String userid = "root";
        String passwd = "wooar85_ju";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Server JDBC Driver Loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("connecting to database...");
            con = DriverManager.getConnection(url, userid, passwd);
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sqlRun() {
        String query = "SELECT * FROM BOOK";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t" + rs.getInt(4)
                );
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        DBTest so = new DBTest();
        so.sqlRun();
    }
}

