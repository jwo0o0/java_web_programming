<%@ page import="Model.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Book" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>장바구니</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>나의 장바구니</h3>
<%!
    User userInfo;
    UserService userService;
    Map<Integer, Book> userCart;
    List<Book> userBooks;
%>
<%
    userInfo = (User)session.getAttribute("userInfo");
    userService = new UserService();
    userCart = userService.getUserBooks(userInfo.getId());
    userBooks = new ArrayList<>(userCart.values());
%>
<c:set value="${userBooks}" var="userBooks" />
<table border="1">
    <tr>
        <th>제목</th>
        <th>출판사</th>
        <th>가격</th>
        <th>구입 시간</th>
    </tr>
    <%
        for (Book i : userBooks) {
    %>
        <tr>
            <td><%= i.getTitle()%></td>
            <td><%= i.getPublisher()%></td>
            <td><%= i.getPrice()%></td>
            <td><%= i.getPurchaseTime()%></td>
        </tr>
    <%
        }
    %>
</table>
</body>
</html>
