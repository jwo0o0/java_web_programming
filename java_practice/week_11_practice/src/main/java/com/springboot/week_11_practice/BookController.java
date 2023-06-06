package com.springboot.week_11_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BookController {
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/books")
    public String books(Model model) {
        List<BookInfo> books = (List<BookInfo>) jdbcTemplate.query("select * from book",
                new RowMapper<BookInfo>() {
                    @Override
                    public BookInfo mapRow(ResultSet rs, int rownum) throws SQLException {
                        BookInfo bookInfo = new BookInfo();
                        bookInfo.setBookid(rs.getInt("bookid"));
                        bookInfo.setBookname(rs.getString("bookname"));
                        bookInfo.setPublisher(rs.getString("publisher"));
                        bookInfo.setPrice(rs.getInt("price"));
                        return bookInfo;
                    }
                });
        model.addAttribute("books", books);
        return "books";
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}
}
