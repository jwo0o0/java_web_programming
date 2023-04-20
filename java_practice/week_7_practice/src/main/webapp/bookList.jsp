<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>도서 목록</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>도서 목록</h3>
<%!
    ResultSet rs;
%>
<%
    rs = (ResultSet) request.getAttribute("books");
%>
<table border="1">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>출판사</th>
    </tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getString(1)%></td>
        <td><a href="/books?action=info&bookId=<%=rs.getString(1)%>"><%= rs.getString(2)%></a></td>
        <td><%= rs.getString(3)%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
