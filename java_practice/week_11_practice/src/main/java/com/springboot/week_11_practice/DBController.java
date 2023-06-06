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
public class DBController {
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/booklist")
    public String booklist(Model model) {
        List<BookInfo> booklist = (List<BookInfo>) jdbcTemplate.query("select * from book", new RowMapper<BookInfo>() {
            @Override
            public BookInfo mapRow(ResultSet rs, int rownum) throws SQLException {
                BookInfo bookInfo = new BookInfo();
                System.out.println(rs.getString("bookname"));
                bookInfo.setBookid(rs.getInt("bookid"));
                bookInfo.setBookname(rs.getString("bookname"));
                bookInfo.setPublisher(rs.getString("publisher"));
                bookInfo.setPrice(rs.getInt("price"));
                return bookInfo;
            }
        });
        model.addAttribute("bklist", booklist);
        return "booklist";
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
