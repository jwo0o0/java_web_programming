<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/03
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>basic Total</title>
</head>
<body>
    <h2>JSP Basic Example</h2>
    <%!
        String[] members = {"James", "Martin", "Kim", "Hong"};
        int num1 = 10;
        int calc(int num2) {
            return num1 + num2;
        }
    %>
    <h3>2. calc(10) method result: <%=calc(10) %></h3>

    <h3>3. include: hello.jsp</h3>
    <%@include file="hello.jsp" %>

    <h3>4. pring all members</h3>
    <ul>
        <%
            for(String name: members) {
        %>
        <li><%=name%></li>
        <% } %>
    </ul>
</body>
</html>
