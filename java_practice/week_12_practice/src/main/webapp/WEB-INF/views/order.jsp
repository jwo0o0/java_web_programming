<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="orderpage" /></title>
</head>
<body>
<h2><spring:message code="orderpage" /></h2>
<form:form action="/addorder" modelAttribute="order">
    <p>
        <spring:message code="name" /> : <br>
        <form:input path="name" /> <br>
        <form:errors path="name" />
    </p>
    <p>
        <spring:message code="bookname" /> : <br>
        <form:input path="bookname" /> <br>
        <form:errors path="bookname" />
    </p>
    <button class="btn" type="submit"><spring:message code="submit" /></button>
</form:form>
<p>
    <a href="/"><spring:message code="homepage" /></a>
</p>
</body>
</html>
