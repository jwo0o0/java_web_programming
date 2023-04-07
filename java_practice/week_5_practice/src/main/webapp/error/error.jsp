<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<%!
    String ex;
%>
<%
    ex = exception.getClass().getName();
%>


<div>에러가 발생했습니다.</div>
<div>오류 타입: <%= exception.getClass().getName() %></div>
<div>오류 메시지: <%= exception.getMessage() %></div>

<a href="../index.jsp">홈으로 돌아가기</a>
</body>
</html>
