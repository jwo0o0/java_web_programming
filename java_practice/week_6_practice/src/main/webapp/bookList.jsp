<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>도서 목록</title>
</head>
<body>
<jsp:include page="header.jsp" />
    <h3>도서 목록</h3>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>출판사</th>
        </tr>
        <c:forEach var="b" varStatus="i" items="${books}">
            <tr>
                <td>${i.count}</td>
                <td><a href="/books?action=info&bookId=${b.bookId}">${b.title}</a></td>
                <td>${b.publisher}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
