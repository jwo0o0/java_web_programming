package Controller;

import Model.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books")
public class BookController extends HttpServlet {
    BookService service;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = new BookService();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String action = request.getParameter("action");
        String view = "";

        if (action == null) {
            getServletContext().getRequestDispatcher("/books?action=list").forward(request, response);
        } else {
            switch (action) {
                case "list": view = list(request, response); break;
                case "info": view = info(request, response); break;
            }
            getServletContext().getRequestDispatcher(view).forward(request, response);
        }

    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        //도서 목록 리스트
        request.setAttribute("books", service.findAll());
        return "/bookList.jsp";
    }

    private String info(HttpServletRequest request, HttpServletResponse response) {
        //도서 상세 정보
        request.setAttribute("book", service.getBook(Integer.parseInt(request.getParameter("bookId"))));
        return "/bookInfo.jsp";
    }

}
