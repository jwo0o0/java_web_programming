package Controller;

import Model.User;
import Model.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    UserService service;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = new UserService();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String action = request.getParameter("action"); //signin or login or logout
        String view = "";

        if (action == null) {
            view = "/index.jsp";
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
            }
            getServletContext().getRequestDispatcher(view).forward(request, response);
        }
    }

    //회원가입
    private String signin(HttpServletRequest request, HttpServletResponse response) {
        //새로운 User 생성 후 UserService service에 추가
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        User newUser = new User(userId, password, address, phoneNumber);
        System.out.println("회원가입: " + userId);

        service.setUser(newUser);

        return "/login.jsp";
    }

    //로그인
    private String login(HttpServletRequest request, HttpServletResponse response) {
        //UserService service에 있는 유저인지 확인
        //존재하면 세션에 유저 정보 저장, 메인 페이지로 이동
        //존재하지 않으면 로그아웃 실패 -> 다시 로그인 페이지로

        User userCheck = service.findUser(request.getParameter("userId"));
        if (userCheck == null) { //로그인 실패
            System.out.println("로그인 실패: 존재하지 않는 유저");
            return "/login.jsp";
        } else { //로그인 성공
            //비밀번호 확인
            if (userCheck.getPassword().equals(request.getParameter("password"))) {
                HttpSession session = request.getSession();
                session.setAttribute("isLogin", true);
                session.setAttribute("userInfo", userCheck);
                System.out.println("로그인 성공: " + userCheck.getId());
                return "/index.jsp";
            } else {
                System.out.println("로그인 실패: 비밀번호 불일치");
                return "/login.jsp";
            }
        }
    }

    //로그아웃
    private String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //세션에서 유저 정보 삭제
        session.setAttribute("isLogin", false);
        session.removeAttribute("userinfo");
        return "/index.jsp";
    }
}
