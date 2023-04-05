<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/03
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>footer</title>
</head>
<body>
    <h3>footer.jsp</h3> <HR>
    <ul>
        <li>Name: <%=request.getParameter("name")%></li>
        <li>Email: <%=request.getParameter("email")%></li>
        <li>Tel: <%=request.getParameter("tel")%></li>
    </ul>
</body>
</html>
