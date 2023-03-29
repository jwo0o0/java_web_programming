package myPackage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloWorld() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1, num2;
        int result;
        String op;

        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        num1 = Integer.parseInt(request.getParameter("num1"));
        num2 = Integer.parseInt(request.getParameter("num2"));
        op = request.getParameter("operator");
        result = calc(num1, num2, op);

        out.println("<html><body>");
        out.println("<title>계산기</title>");
        out.println("<h2>계산 결과</h2>");
        out.println(num1 + op + num2 + " = " + result);
        out.println("</body></html>");
    }

    public int calc(int num1, int num2, String op) {
        int result = 0;
        if (op.equals("+")) {
            result = num1 + num2;
        } else if (op.equals("-")) {
            result = num1 - num2;
        } else if (op.equals("*")) {
            result = num1 * num2;
        } else if (op.equals("/")) {
            result = num1 / num2;
        }
        return result;
    }
}
