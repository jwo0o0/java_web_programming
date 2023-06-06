<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="customerlist" /></title>
</head>
<body>
<h2><spring:message code="customerlist" /></h2>
<table border="1" cellpadding="10">
    <tr>
        <th><spring:message code="customerId" /></th>
        <th><spring:message code="name" /></th>
        <th><spring:message code="address" /></th>
        <th><spring:message code="phone" /></th>
    </tr>
    <c:forEach var="item" items="${customerlist}">
        <tr>
            <td>${item.customerId}</td>
            <td>${item.name}</td>
            <td>${item.address}</td>
            <td>${item.phone}</td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/"><spring:message code="homepage" /></a>
</p>
</body>
</html>
