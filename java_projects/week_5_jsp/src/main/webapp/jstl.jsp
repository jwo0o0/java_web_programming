<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/02
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSTL Page</title>
</head>
<body>
    <c:set var="name" value="Jack" />
    <%
        String userName = (String)pageContext.getAttribute("name");
        out.println("Hello, my name is " + userName);
    %>

    <%
        String abooklist[] = {"book1", "book2", "book3"};
    %>
    <% pageContext.setAttribute("abooklist", abooklist); %>

    <c:forEach var="list" items="${abooklist}" varStatus="status" end="3">
        <div>
            <span>var: ${list}</span>
            <span>varStatus index: ${status.index}</span>
            <span>status count: ${status.count}</span>
        </div>
    </c:forEach>

    <c:forEach begin="0" end="10" varStatus="status">
        <c:choose>
            <c:when test="${status.index == 0}">
                ${status.index}는 짝수도 홀수도 아닙니다.
            </c:when>
            <c:when test="${(status.index != 0) and (status.index % 2 == 0)}">
                ${status.index}는 짝수입니다.
            </c:when>
            <c:otherwise>
                ${status.index}는 홀수입니다.
            </c:otherwise>
        </c:choose>
        <c:if test="${status.index > 0 and status.index < 10}">
            ${status.index}는 한 자리 양의 정수입니다.
        </c:if>
        <c:if test="${status.index >= 10}">
            ${status.index}는 두 자리 양의 정수입니다.
        </c:if>
        <br>
    </c:forEach>
</body>
</html>
