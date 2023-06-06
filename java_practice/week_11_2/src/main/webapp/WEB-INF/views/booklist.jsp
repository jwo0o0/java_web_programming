<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>도서 리스트</title>
</head>
<body>
<h2>도서 리스트</h2>
<table border="1" cellpadding="10">
    <c:forEach var="item" items="${booklist}">
        <tr>
            <td>${item.bookId}</td>
            <td>${item.bookname}</td>
            <td>${item.publisher}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
