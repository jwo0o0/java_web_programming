<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>헤더</title>
</head>
<body>
<%!
    boolean isLogin;
%>
<%
    if (session.getAttribute("isLogin") == null || (Boolean)session.getAttribute("isLogin") == false) {
        isLogin = false;
    } else {
        isLogin = true;
    }
%>
<div>
    <c:choose>
        <c:when test="${isLogin}">
            <a href="/mypage.jsp">마이페이지</a>
            <a href="/user?action=logout">로그아웃</a>
            <a href="/userCart.jsp">장바구니</a>
        </c:when>
        <c:otherwise>
            <a href="/login.jsp">로그인</a>
        </c:otherwise>
    </c:choose>
    <a href="/signin.jsp">회원가입</a>
    <a href="/books?action=list">도서 목록</a>
</div>
</body>
</html>
