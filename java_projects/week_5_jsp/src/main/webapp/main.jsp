<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/01
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main page</title>
</head>
<body>
<jsp:forward page="result.jsp">
    <jsp:param name="title" value="my homepage"/>
</jsp:forward>
</body>
</html>
