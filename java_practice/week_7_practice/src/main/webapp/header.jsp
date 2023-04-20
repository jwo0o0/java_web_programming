<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>헤더</title>
</head>
<body>
<%!
    boolean isLogin;
    String userId;
%>
<%
    if (session.getAttribute("isLogin") == null || (Boolean)session.getAttribute("isLogin") == false) {
        isLogin = false;
    } else {
        isLogin = true;
    }
    if (session.getAttribute("userId") != null) {
        userId = (String) session.getAttribute("userId");
    } else {
        userId = "";
    }
%>
<div>
    <a href="/">홈</a>
    <c:choose>
        <c:when test="${isLogin}">
            <a href="/mypage.jsp">마이페이지</a>
            <a href="/user?action=logout">로그아웃</a>
            <a href="/order?action=list">장바구니</a>
        </c:when>
        <c:otherwise>
            <a href="/login.jsp">로그인</a>
        </c:otherwise>
    </c:choose>
    <a href="/signin.jsp">회원가입</a>
    <a href="/books?action=list">도서 목록</a>
</div>
<%
    if (userId.equals("1")) {
%>
<div>
    <a href="/admin.jsp">관리자 페이지</a>
</div>
<%
    }
%>
</body>
</html>
