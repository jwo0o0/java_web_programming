package com.week_11_2;

import jakarta.servlet.http.HttpServletRequest;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BookController {
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/book")
    public String book() {
        return "book";
    }

    //도서 정보 추가
    @RequestMapping(value="/addbook", method={RequestMethod.POST})
    public String addBook(HttpServletRequest request) {
        //새로운 책 정보
        String bookname = request.getParameter("bookname");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");

        String sql = "INSERT INTO Book (`bookname`, `publisher`, `price`) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, bookname, publisher, price);

        return "redirect:booklist";
    }

    //책 리스트
    @RequestMapping(value="/booklist", method = {RequestMethod.GET})
    public String bookList(Model model) {
        List<Book> booklist = (List<Book>) jdbcTemplate.query("select * from book", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rownum) throws SQLException {
                Book book = new Book();
                book.setBookId(rs.getInt("bookId"));
                book.setBookname(rs.getString("bookname"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getInt("price"));
                return book;
            }
        });
        model.addAttribute("booklist", booklist);

        return "booklist";
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
