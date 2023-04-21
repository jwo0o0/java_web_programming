package Controller;

import com.week_7_practice.MyDB;

import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    MyDB mydb;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mydb = new MyDB();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String view = "";

        if (action == null) {
            view = "/";
            getServletContext().getRequestDispatcher(view).forward(request, response);
        } else {
            switch (action) {
                case "list": {
                    view = list(request, response);
                    break;
                }
                case "add": {
                    view = add(request, response);
                    break;
                }
                case "delete": {
                    view = delete(request, response);
                    break;
                }
                case "info": {
                    view = info(request, response);
                    break;
                }
                case "update": {
                    view = update(request, response);
                    break;
                }
            }
            getServletContext().getRequestDispatcher(view).forward(request, response);
        }
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        //DB 연결
        Connection con = mydb.getCon();
        String query = "SELECT * FROM Book";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            request.setAttribute("books", rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/adminBookList.jsp";
    }

    //도서 추가
    private String add(HttpServletRequest request, HttpServletResponse response) {
        //새로운 책 정보
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String imgLink = request.getParameter("imgLink");

        //DB 연결
        Connection con = mydb.getCon();

        String query = "INSERT INTO Book (title, publisher, price, category, img_link) values (?, ?, ?, ?, ?)";

        int result = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, publisher);
            ps.setString(3, price);
            ps.setString(4, category);
            ps.setString(5, imgLink);
            result = ps.executeUpdate();
            System.out.println(">> 도서 추가 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result >= 1) {
            return "/books?action=list";
        } else {
            return "/addBook.jsp";
        }
    }

    //도서 삭제
    private String delete(HttpServletRequest request, HttpServletResponse response) {
        String bookId = request.getParameter("bookId");

        //DB 연결
        Connection con = mydb.getCon();

        String query = "DELETE FROM Book WHERE bookId = " + bookId;

        int result = 0;
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(query);
            System.out.println(">> 도서 삭제 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result >= 1) {
            return "/books?action=list";
        } else {
            return "/admin?action=list";
        }
    }

    //수정할 도서 정보
    private String info(HttpServletRequest request, HttpServletResponse response) {
        String bookId = request.getParameter("bookId");

        //DB 연결
        Connection con = mydb.getCon();
        String query = "SELECT * FROM Book WHERE bookId=" + bookId;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            request.setAttribute("info", rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/updateBook.jsp";
    }

    //도서 수정
    private String update(HttpServletRequest request, HttpServletResponse response) {
        String bookId = request.getParameter("bookId");

        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String imgLink = request.getParameter("imgLink");

        //DB 연결
        Connection con = mydb.getCon();

        String query = "UPDATE Book SET publisher = ?, price= ?, category= ?, img_link= ? WHERE bookId=" + bookId;
        int result = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, publisher);
            ps.setString(2, price);
            ps.setString(3, category);
            ps.setString(4, imgLink);
            result = ps.executeUpdate();
            System.out.println(">> 도서 업데이트 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result >= 1) {
            return "/books?action=info&bookId=" + bookId;
        } else {
            return "/admin?action=list";
        }
    }
}
