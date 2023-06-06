<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>고객 리스트</title>
</head>
<body>
<h2>고객 리스트</h2>
<table border="1" cellpadding="10">
    <c:forEach var="item" items="${customerlist}">
        <tr>
            <td>${item.customerId}</td>
            <td>${item.name}</td>
            <td>${item.address}</td>
            <td>${item.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
