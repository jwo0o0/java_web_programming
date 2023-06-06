<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<!-- 세션 정보가 없으면 -->
<c:if test="${empty authInfo}">
    <p>
        <spring:message code="loginmesg" />
    </p>
    <form:form action="submit" modelAttribute="loginInfo">
        <p>
            <label>
                <spring:message code="userid" /> : <br>
                <form:input path="userid" />
                <form:errors path="userid" />
                <br><spring:message code="rememberid" />
                <form:checkbox path="rememberid" />
            </label>
        </p>
        <p>
            <label>
                <spring:message code="pwd" /> : <br>
                <form:input path="pwd" />
                <form:errors path="pwd" />
            </label>
        </p>
        <button class="btn" type="submit"><spring:message code="submit" /></button>
    </form:form>
</c:if>
<!-- 세션 정보가 있으면 -->
<c:if test="${! empty authInfo}">
    <p>${authInfo.userid}님 환영합니다.</p>
    <a href="/userinfo/${authInfo.userid}">${authInfo.userid}님의 정보</a>
    <a href="/modifyuserinfo">회원정보 수정</a>
    <a href="/logout">로그아웃</a>
</c:if>
</body>
</html>
