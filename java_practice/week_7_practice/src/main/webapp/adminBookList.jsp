<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>도서 관리</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>도서 관리</h3>
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
        <th>삭제</th>
        <th>수정</th>
    </tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getString(1)%></td>
        <td><%= rs.getString(2)%></td>
        <td><%= rs.getString(3)%></td>
        <td>
            <button><a href="/admin?action=delete&bookId=<%=rs.getString(1)%>">삭제하기</a></button>
        </td>
        <td>
            <button><a href="/admin?action=info&bookId=<%=rs.getString(1)%>">수정하기</a></button>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
