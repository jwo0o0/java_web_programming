<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>에러가 발생했습니다.</h1>
    <div>에러 타입: ${request.getParameter("type")}</div>
</body>
</html>
