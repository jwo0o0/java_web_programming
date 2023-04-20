<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>장바구니</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>나의 장바구니</h3>
<%!
    ResultSet rs;
%>
<%
    rs = (ResultSet) request.getAttribute("orders");
%>
<table border="1">
    <tr>
        <th>제목</th>
        <th>출판사</th>
        <th>가격</th>
        <th>구입 시간</th>
    </tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getString(4)%></td>
        <td><%= rs.getString(5)%></td>
        <td><%= rs.getString(6)%></td>
        <td><%= rs.getString(7)%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
