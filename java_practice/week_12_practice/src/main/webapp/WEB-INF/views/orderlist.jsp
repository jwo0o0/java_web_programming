<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<html>
<head>
    <title><spring:message code="orderlist" /></title>
</head>
<body>
<h2><spring:message code="orderlist" /></h2>
<table border="1" cellpadding="10">
    <tr>
        <th><spring:message code="orderId" /></th>
        <th><spring:message code="orderPerson" /></th>
        <th><spring:message code="bookname" /></th>
        <th><spring:message code="price" /></th>
        <th><spring:message code="purchaseTime" /></th>
    </tr>
    <c:forEach var="item" items="${orderlist}">
        <tr>
            <td>${item.orderId}</td>
            <td>${item.name}</td>
            <td>${item.bookname}</td>
            <td>${item.price}</td>
            <td>${item.purchase_time}</td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/"><spring:message code="homepage" /></a>
</p>
</body>
</html>
