package Controller;

import Model.BookService;
import Model.User;
import Model.UserService;
import Model.Book;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
    UserService userService;
    BookService bookService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = new UserService();
        bookService = new BookService();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        HttpSession session = request.getSession();

        User loginedUser = (User)session.getAttribute("userInfo");
        User findedUser = userService.findUser(loginedUser.getId());

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        Book book = bookService.getBook(bookId);

        //구입 시간 set
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        book.setPurchaseTime(LocalDateTime.now().format(formatter));

        //유저 카트에 책 추가
        userService.setUserBook(findedUser.getId(), book);

        getServletContext().getRequestDispatcher("/userCart.jsp").forward(request, response);
    }
}
