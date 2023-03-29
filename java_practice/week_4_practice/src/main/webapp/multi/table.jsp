<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/03/29
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>곱셈표</title>
</head>
<body>
<%@include file="../nav.jsp"%>
<h2>곱셈표</h2>
<table>
    <th>X</th>
    <%
        for (int h = 1; h < 10; h++) {
    %>
        <th><%= h%></th>
    <%
        }
    %>
    <%
        for (int i = 1; i < 10; i++) {
    %>
        <tr>
            <td><%= i %></td>
            <%
                for (int j = 1; j < 10; j++) {
            %>
                <td><%= i*j %></td>
            <%
                }
            %>
        </tr>
    <%
        }
    %>
</table>
</body>
</html>
