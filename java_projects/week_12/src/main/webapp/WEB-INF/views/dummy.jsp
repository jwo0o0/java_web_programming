<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>dummy</title>
</head>
<body>
<p><spring:message code="name" /> : ${studentInfo.name}</p>
<p><spring:message code="univ" />: ${studentInfo.univ}</p>
<p><spring:message code="dept" />: ${studentInfo.dept}</p>
<p><spring:message code="stdid" />: ${studentInfo.stdid}</p>
<p><spring:message code="email" />: ${studentInfo.email}</p>
<a href="./"><spring:message code="back" /></a>
</body>
</html>
