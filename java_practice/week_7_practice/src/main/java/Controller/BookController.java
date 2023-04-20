package Controller;

import com.example.week_7_practice.MyDB;

import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books")
public class BookController extends HttpServlet {
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
                case "info": {
                    view = info(request, response);
                    break;
                }
            }
            getServletContext().getRequestDispatcher(view).forward(request, response);
        }
    }

    //도서 목록
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
        return "/bookList.jsp";
    }

    //도서 상세 정보
    private String info(HttpServletRequest request, HttpServletResponse response) {
        //DB 연결
        Connection con = mydb.getCon();
        //책 아이디
        String bookId = request.getParameter("bookId");
        String query = "SELECT * FROM Book WHERE bookId = \'" + bookId + "\'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            request.setAttribute("book", rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/bookInfo.jsp";
    }

}
