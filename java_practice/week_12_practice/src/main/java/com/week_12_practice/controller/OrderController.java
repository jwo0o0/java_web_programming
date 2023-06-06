package com.week_12_practice.controller;

import com.week_12_practice.model.Book;
import com.week_12_practice.model.Customer;
import com.week_12_practice.model.Order;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class OrderController {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //책 주문 페이지
    @GetMapping("/order")
    public String order(@ModelAttribute Order order) {
        return "order";
    }

    //주문 처리
    @PostMapping("/addorder")
    public String addOrder(@Validated Order order, Errors errors, Model model) {
        model.addAttribute("order", order);
        if (errors.hasErrors()) {
            return "order";
        } else {
            String customerName = order.getName();
            String bookName = order.getBookname();

            //해당 주문 유저 찾기
            String query = "SELECT * FROM customer WHERE name=?";
            List<Customer> customers = jdbcTemplate.query(
                    query,
                    new RowMapper<Customer>() {
                        @Override
                        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Customer customer = new Customer();
                            customer.setCustomerId(rs.getInt("customerId"));
                            customer.setName(rs.getString("name"));
                            customer.setPassword(rs.getString("password"));
                            customer.setAddress(rs.getString("address"));
                            customer.setPhone(rs.getString("phone"));
                            return customer;
                        }
                    },
                    customerName
            );
            //존재하지 않는 고객 이름의 경우 order 페이지로 이동
            if (customers.isEmpty()) return "order";

            Customer customer = customers.get(0);


            //해당 주문 책 찾기
            query = "SELECT * FROM book WHERE bookname=?";
            List<Book> books = jdbcTemplate.query(
                    query,
                    new RowMapper<Book>() {
                        @Override
                        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Book book = new Book();
                            book.setBookId(rs.getInt("bookId"));
                            book.setBookname(rs.getString("bookname"));
                            book.setPublisher(rs.getString("publisher"));
                            book.setPrice(rs.getInt("price"));
                            return book;
                        }
                    },
                    bookName
            );
            //존재하지 않는 책 이름의 경우 order 페이지로 이동
            if (books.isEmpty()) return "order";

            Book book = books.get(0);

            //주문 시간 포맷
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String purchaseTime = LocalDateTime.now().format(formatter);

            query = "INSERT INTO orders (`customerId`, `bookId`, `name`, `bookname`, `publisher`, `price`, `purchase_time`) VALUES(?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, customer.getCustomerId(), book.getBookId(), customer.getName(), book.getBookname(), book.getPublisher(), book.getPrice(), purchaseTime);

            return "redirect:orderlist";
        }
    }

    //get 방식으로 잘못된 접근시 홈페이지로 redirect
    @GetMapping("/addorder")
    public String redirectOrder() { return "redirect:order"; }

    //주문 목록 페이지
    @GetMapping("/orderlist")
    public String orderlist(Model model) {
        List<Order> orderlist = (List<Order>) jdbcTemplate.query("select * from orders", new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet rs, int rownum) throws SQLException {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setBookId(rs.getInt("bookId"));
                order.setName(rs.getString("name"));
                order.setBookname(rs.getString("bookname"));
                order.setPublisher(rs.getString("publisher"));
                order.setPrice(rs.getInt("price"));
                order.setPurchase_time(rs.getString("purchase_time"));
                return order;
            }
        });
        model.addAttribute("orderlist", orderlist);

        return "orderlist";
    }
}
