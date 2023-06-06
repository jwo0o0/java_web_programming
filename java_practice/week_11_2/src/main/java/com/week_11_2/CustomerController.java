package com.week_11_2;

import jakarta.servlet.http.HttpServletRequest;
import model.Customer;
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
public class CustomerController {
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/customer")
    public String customer() {
        return "customer";
    }

    //고객 정보 추가
    @RequestMapping(value="/addcustomer", method = {RequestMethod.POST})
    public String addCustomer(HttpServletRequest request) {
        //새로운 유저 정보
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        String sql = "INSERT INTO Customer (`name`, `password`, `address`, `phone`) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, password, address, phone);

        return "redirect:customerlist";
    }

    //고객 리스트
    @RequestMapping(value="/customerlist", method = {RequestMethod.GET})
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

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
