<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="bookpage" /></title>
</head>
<body>
<h2><spring:message code="bookpage" /></h2>
<form:form action="/addbook" modelAttribute="book">
    <p>
        <spring:message code="bookname" /> : <br>
        <form:input path="bookname" /> <br>
        <form:errors path="bookname" />
    </p>
    <p>
        <spring:message code="publisher" /> : <br>
        <form:input path="publisher" /> <br>
        <form:errors path="publisher" />
    </p>
    <p>
        <spring:message code="price" /> : <br>
        <form:input path="price" /> <br>
        <form:errors path="price" />
    </p>
    <button class="btn" type="submit"><spring:message code="submit" /> </button>
</form:form>
<p>
    <a href="/"><spring:message code="homepage" /></a>
</p>
</body>
</html>
