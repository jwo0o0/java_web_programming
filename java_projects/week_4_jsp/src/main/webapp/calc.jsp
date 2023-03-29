<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/03/24
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%
    int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));

    long result = 0;

    switch (request.getParameter("op")) {
        case "+": result = n1 + n2; break;
        case "-": result = n1 - n2; break;
        case "*": result = n1 * n2; break;
        case "/": result = n1 / n2; break;
    }
%>
<html>
<head>
    <title>calculate</title>
</head>
<body>
    <h2>계산 결과</h2>
    결과: <%=result %>
</body>
</html>
