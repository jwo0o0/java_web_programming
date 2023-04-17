<%@ page import="Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>마이페이지</h3>
<%!
    User userInfo;
%>
<%
    if (session.getAttribute("userInfo") != null) {
        userInfo = (User)session.getAttribute("userInfo");
    }
%>
<p>
    <div>
        아이디: ${userInfo.getId()}
    </div>
    <div>
        주소: ${userInfo.address}
    </div>
    <div>
        전화번호: ${userInfo.phoneNumber}
    </div>
</p>
</body>
</html>
