<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title><spring:message code="customerpage" /></title>
</head>
<body>
<h2><spring:message code="customerpage" /></h2>
<form:form action="/addcustomer" modelAttribute="customer">
    <p>
        <spring:message code="name" /> : <br>
        <form:input path="name" /> <br>
        <form:errors path="name" />
    </p>
    <p>
        <spring:message code="password" /> : <br>
        <form:input path="password" type="password"/> <br>
        <form:errors path="password" />
    </p>
    <p>
        <spring:message code="address" /> : <br>
        <form:input path="address" /> <br>
        <form:errors path="address" />
    </p>
    <p>
        <spring:message code="phone" /> : <br>
        <form:input path="phone" /> <br>
        <form:errors path="phone" />
    </p>
    <button class="btn" type="submit"><spring:message code="submit" /> </button>
</form:form>
<p>
    <a href="/"><spring:message code="homepage" /></a>
</p>
</body>
</html>
