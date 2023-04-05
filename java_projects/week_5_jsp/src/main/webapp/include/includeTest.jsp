<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/03
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include Test</title>
</head>
<body>
<div align="center">
    <h2>include directive example</h2>
    
    <%@include file="menu.jsp" %>
    <p>
        <table>
            <tr>
                <td><%@include file="news.jsp"%></td>
                <td><%@include file="shopping.jsp"%></td>
            </tr>
        </table>
    </p>

    <jsp:include page="footer.jsp">
        <jsp:param name="email" value="test@test.email"/>
        <jsp:param name="tel" value="000-123-4567"/>
    </jsp:include>
</div>
</body>
</html>
