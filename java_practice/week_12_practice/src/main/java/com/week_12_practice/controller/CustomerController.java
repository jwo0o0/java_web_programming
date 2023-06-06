package com.week_12_practice.controller;

import com.week_12_practice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class CustomerController {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //고객 등록 페이지
    @GetMapping("/customer")
    public String customer(@ModelAttribute Customer customer) {
        return "customer";
    }

    //고객 등록 처리
    @PostMapping("/addcustomer")
    public String addCustomer(@Validated Customer customer, Errors errors, Model model) {
        model.addAttribute("customer", customer);
        if (errors.hasErrors()) { //검증 실패시 입력폼으로 돌아감
            return "customer";
        } else {
            String sql = "INSERT INTO Customer (`name`, `password`, `address`, `phone`) VALUES(?, ?, ?, ?)";
            jdbcTemplate.update(sql, customer.getName(), customer.getPassword(), customer.getAddress(), customer.getPhone());
            return "redirect:customerlist";
        }
    }

    //get 방식으로 잘못된 접근시 홈페이지로 redirect
    @GetMapping("/addcustomer")
    public String redirectaddCustomer() {
        return "redirect:home";
    }

    //고객 목록 페이지
    @GetMapping("/customerlist")
    public String customerlist(Model model) {
        List<Customer> customerlist = (List<Customer>) jdbcTemplate.query("select * from customer", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customerId"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setAddress(rs.getString("address"));
                customer.setPhone(rs.getString("phone"));
                return customer;
            }
        });
        model.addAttribute("customerlist", customerlist);

        return "customerlist";
    }

}
