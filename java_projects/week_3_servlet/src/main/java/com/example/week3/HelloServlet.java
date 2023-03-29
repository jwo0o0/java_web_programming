package com.example.week3;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        out.append("<html><body>")
                .append("<div>")
                .append("현재 날짜와 시간은: " + java.time.LocalDateTime.now())
                .append("</div>")
        .append("</body><html>");

    }

    public void destroy() {
    }
}