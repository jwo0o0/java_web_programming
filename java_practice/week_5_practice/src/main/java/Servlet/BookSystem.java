package Servlet;

import Data.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//3주차 - 서블릿으로 처리

@WebServlet("/books")
public class BookSystem extends HttpServlet {
    //도서 목록 동적 배열
    ArrayList<Book> books = new ArrayList<>();

    public BookSystem() {
        books.add(new Book(1, "축구의 역사", "굿스포츠", 7000));
        books.add(new Book(2, "축구 아는 여자", "나무수", 13000));
        books.add(new Book(3, "축구의 이해", "대한미디어", 22000));
        books.add(new Book(4, "골프 바이블", "대한미디어", 35000));
        books.add(new Book(5, "피겨 교본", "굿스포츠", 8000));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Book newBook = makeNewBook(request); //새로운 Book 객체 생성
        books.add(newBook); //기존 도서 목록에 새로운 Book 객체 추가

        out.println("<html>");
        out.println("<body>");
        out.println("<title>도서 목록</title>");
        out.println("<h2>도서 목록</h2>");
        out.println("<div style=\"max-width: 500px;\">");
        out.println("<div style=\"display: flex;\"><div style=\"width: 70px;\">도서번호</div><div style=\"width: 250px;\">제목</div>");
        out.println("<div style=\"width: 100px;\">출판사</div><div style=\"width: 100px;\">가격</div></div>");
        //books 배열에 저장된 도서 목록 출력
        for (int i = 0; i < books.size(); i++) {
            out.println("<div style=\"display: flex; border-top: 1px solid gray; padding: 5px 0;\">");
            out.println("<div style=\"width: 70px;\">" + books.get(i).getBookId() + "</div>");
            out.println("<div style=\"width: 250px;\">" + books.get(i).getTitle() + "</div>");
            out.println("<div style=\"width: 100px;\">" + books.get(i).getPublisher() + "</div>");
            out.println("<div style=\"width: 100px;\">" + books.get(i).getPrice() + "</div>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("<a href=\"index.jsp\"> 홈으로 돌아가기 </a>");
        out.println("</body></html>");
    }

    //request에서 받은 정보를 가진 새로운 Book 객체를 반환
    private Book makeNewBook(HttpServletRequest request) {
        int price;
        String title, publisher;

        //가격이 정수가 아닌 경우에 대한 예외처리 -> 가격을 0으로 설정
        try {
            price = Integer.parseInt(request.getParameter("price"));
        }
        catch (NumberFormatException e) {
            price = 0;
        }

        title = request.getParameter("title");
        publisher = request.getParameter("publisher");

        //새로운 책의 도서번호 -> 1씩 더하며 자동으로 생성
        Book newBook = new Book(books.size() + 1, title, publisher, price);
        return newBook;
    }
}
