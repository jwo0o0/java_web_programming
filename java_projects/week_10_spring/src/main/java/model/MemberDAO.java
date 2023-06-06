package model;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component //애노테이션에 별다른 옵션이 없다면 클래스 이름의 첫글자를 소문자로 하는 이름을 가진 빈을 자동으로 생성
public class MemberDAO implements DAO {
    Connection con;

    public MemberDAO() {
        String url = "jdbc:mysql://localhost/week_10";
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
        String query = "SELECT * FROM Member";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Member name");

            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member selectByEmail(String email) {
        System.out.println("selected by email: " + email);
        Member member = new Member();
        return member;
    }
}
