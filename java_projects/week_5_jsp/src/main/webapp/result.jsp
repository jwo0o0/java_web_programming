<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/01
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>


<html>
<head>
    <title>result page</title>
</head>
<body>
    <h2>
        <%=request.getParameter("title")%>
    </h2>
<div>
    <!-- <tf:formatDate value="${userInfo.birthday}" pattern="yyyy-MM-dd" /> -->


</div>
</body>
</html>
