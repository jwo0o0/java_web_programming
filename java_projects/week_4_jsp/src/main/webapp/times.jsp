<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/03/24
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>구구단</title>
</head>
<body>
    <%@page import="jsptest.Test" %>
    <%
        int i, j;
        Test t;
    %>
        ===== 구구단 ===== <br><br>
    <%
        for(i=2; i<10; i++) {
    %>
        ----- <%=i%>단 -----<br>
<%
    t = new Test(i*2);
%>
    테스트 객체: <%= t.getValue()%><br>
<%
    for(j=1; j<10; j++) {
%>
<%=i%> * <%=j%> = <%=i*j%><br>
<%
}
}%>

</body>
</html>
