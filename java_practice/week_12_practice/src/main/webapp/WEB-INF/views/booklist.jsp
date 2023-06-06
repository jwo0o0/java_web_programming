<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="booklist" /></title>
</head>
<body>
<h2><spring:message code="booklist" /></h2>
<table border="1" cellpadding="10">
    <tr>
        <th><spring:message code="bookId" /></th>
        <th><spring:message code="bookname" /></th>
        <th><spring:message code="publisher" /></th>
        <th><spring:message code="price" /></th>
    </tr>
    <c:forEach var="item" items="${booklist}">
        <tr>
            <td>${item.bookId}</td>
            <td>${item.bookname}</td>
            <td>${item.publisher}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/"><spring:message code="homepage" /></a>
</p>
</body>
</html>
