<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>${homemsg}</h2>
<form:form action="submit" modelAttribute="studentInfo">
    <c:forEach var="i" items="${inputForm}" varStatus="status">
        <p>
            ${status.index+1}. ${i.title} <form:input path="${i.attr}" />
        </p>
    </c:forEach>
</form:form>
</body>
</html>
