package com.week_12_practice.controller;

import com.week_12_practice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BookController {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //책 등록 페이지
    @GetMapping("/book")
    public String book(@ModelAttribute Book book) {
        return "book";
    }

    //책 등록 처리
    @PostMapping("/addbook")
    public String addBook(@Validated Book book, Errors errors, Model model) {
        model.addAttribute("book", book);
        if (errors.hasErrors()) { //검증 실패시 입력폼으로 돌아감
            return "book";
        } else {
            String sql = "INSERT INTO Book (`bookname`, `publisher`, `price`) VALUES(?, ?, ?)";
            jdbcTemplate.update(sql, book.getBookname(), book.getPublisher(), book.getPrice());
            return "redirect:booklist";
        }
    }

    //get 방식으로 잘못된 접근시 홈페이지로 redirect
    @GetMapping("/addbook")
    public String redirectaddBook() {
        return "redirect:home";
    }

    //책 목록 반환
    @GetMapping("/booklist")
    public String booklist(Model model) {
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
}
