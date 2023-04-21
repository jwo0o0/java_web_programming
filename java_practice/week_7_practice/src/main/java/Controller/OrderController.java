package Controller;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.week_7_practice.MyDB;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    MyDB mydb;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mydb = new MyDB();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        //purchase - 구매, list - 구매 목록 조회
        String view = "";

        if (action == null) {
            view = "/";
            getServletContext().getRequestDispatcher(view).forward(request, response);
        } else {
            switch (action) {
                case "purchase": view = purchase(request, response); break;
                case "list": view = purchaseList(request, response); break;
            }
            getServletContext().getRequestDispatcher(view).forward(request, response);
        }
    }

    //책 구매
    private String purchase(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String bookId = request.getParameter("bookId");

        //DB 연결
        Connection con = mydb.getCon();
        //책 정보 가져오기
        String query = "SELECT * FROM Book WHERE bookId=" + bookId;
        String title = "";
        String publisher = "";
        String price = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            title = rs.getString(2);
            publisher = rs.getString(3);
            price = rs.getString(4);
            System.out.println(title + publisher + price);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //구입 시간 set
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String purchaseTime = LocalDateTime.now().format(formatter);

        //처리 결과
        int result = 0;

        //Orders 테이블에 저장
        query = "INSERT INTO Orders (userId, bookId, title, publisher, price, purchase_time) values (?, ?, ?, ?, ?, ?)";
        try {
            Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userId);
            ps.setString(2, bookId);
            ps.setString(3, title);
            ps.setString(4, publisher);
            ps.setString(5, price);
            ps.setString(6, purchaseTime);
            result = ps.executeUpdate();
            System.out.println(">> 구매 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result >= 1) {
            return "/order?action=list";
        } else {
            return "/books?action=list";
        }
    }

    //책 구매 목록
    private String purchaseList(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        //DB 연결
        Connection con = mydb.getCon();

        String query = "SELECT * FROM Orders WHERE userId=" + userId;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            request.setAttribute("orders", rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/userCart.jsp";
    }
}
