<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>상품 목록</title>
    <meta charset="UTF-8">
</head>
<body>
    <h2>상품 목록</h2>
    <hr>
    <table border="1">
        <tr><th>번호</th><th>상품명</th><th>가격</th></tr>
        <c:forEach var="p" varStatus="i" items="${products}">
            <tr>
                <td>${i.count}</td>
                <td><a href="/pcontrol?action=info&id=${p.id}">${p.name}</a></td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
