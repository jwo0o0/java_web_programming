package Controller;

import java.sql.*;
import com.example.week_7_practice.MyDB;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.String;

@WebServlet("/user")
public class UserController extends HttpServlet {
    MyDB mydb;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mydb = new MyDB();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        //회원가입 - signin, 로그인 - login, 로그아웃 - logout, 회원정보수정 - edit
        String view = "";

        if (action == null) {
            view = "/";
            getServletContext().getRequestDispatcher(view).forward(request, response);
        } else {
            switch (action) {
                case "signin": {
                    view = signin(request, response);
                    break;
                }
                case "login": {
                    view = login(request, response);
                    break;
                }
                case "logout": {
                    view = logout(request, response);
                    break;
                }
                case "edit": {
                    view = edit(request, response);
                    break;
                }
            }
            getServletContext().getRequestDispatcher(view).forward(request, response);
        }
    }

    //회원가입 처리
    private String signin(HttpServletRequest request, HttpServletResponse response) {
        //새로운 유저 정보
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        //DB 연결 생성
        Connection con = mydb.getCon();

        String query = "insert into user (name, password, address, phone) values (?,?,?,?)";

        //처리 결과
        int result = 0;

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, address);
            ps.setString(4, phone);
            result = ps.executeUpdate();
            System.out.println(">> 회원가입 완료 ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result >= 1) {
            return "/login.jsp";
        } else {
            return "/signin.jsp";
        }
    }

    //로그인 처리
    private String login(HttpServletRequest request, HttpServletResponse response) {
        //DB의 User 테이블에 존재하는 유저인지 확인
        //존재하면 세션에 유저 정보 저장 -> 메인페이지로 이동
        //존재하지 않으면 로그인 실패 -> 다시 로그인 페이지로

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //DB 연결 생성
        Connection con = mydb.getCon();
        StringBuilder sb = new StringBuilder();
        String query = sb.append("SELECT * FROM User WHERE name ='").append(name).append("';").toString();

        boolean loginResult = false;
        String userId = "0";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            //유저가 존재하고 비밀번호도 일치하는 경우
            if (rs.next()) {
                System.out.println("존재");
                String DBpassword = rs.getString(3);
                userId = rs.getString(1);
                if (password.equals(DBpassword)) loginResult = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (loginResult) { //로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", true);
            session.setAttribute("userId", userId);
            System.out.println("로그인 성공");
            return "/index.jsp";
        } else {
            System.out.println("로그인 실패");
            return "/login.jsp";
        }
    }

    //로그아웃 처리
    private String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //세션에서 유저 정보 삭제
        session.setAttribute("isLogin", false);
        session.removeAttribute("userId");
        return "/index.jsp";
    }

    private String edit(HttpServletRequest request, HttpServletResponse response) {
        //수정할 유저 정보
        String nameQuery = "name = \'" + request.getParameter("name") + "',";
        String passwordQuery = "password = \'" +request.getParameter("password") + "',";
        String addressQuery = "address = \'" +request.getParameter("address") + "',";
        String phoneQuery = "phone = \'" +request.getParameter("phone") + "'";

        //현재 로그인한 유저 아이디
        HttpSession session = request.getSession();
        String currentUserId = (String)session.getAttribute("userId");

        //DB 연결 생성
        Connection con = mydb.getCon();
        //처리 결과
        int result = 0;

        String query = "UPDATE User SET " + nameQuery + passwordQuery + addressQuery + phoneQuery + "WHERE userID=" + currentUserId + ";";

        try {
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(query);
            System.out.println(">> 회원정보 수정 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/mypage.jsp";
    }
}


