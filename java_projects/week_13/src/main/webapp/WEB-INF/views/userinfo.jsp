<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>
<c:if test="${! empty authInfo}">
    <p> ${authInfo.userid} <spring:message code="userinfo" /> </p>
    <p> <spring:message code="email" />: ${userInfo.email} </p>
    <p> <spring:message code="address" />: ${userInfo.addr} </p>
    <p> <spring:message code="tel" />: ${userInfo.tel} </p>
    <p> <spring:message code="birthday" />: <tf:formatDate value="${userInfo.birthday}" pattern="yyyy-MM-dd" /> </p>
    <a href="/login"> <spring:message code="back" /> </a>
</c:if>
</body>
</html>
