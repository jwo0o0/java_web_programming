<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>home</h1>
<p><spring:message code="homemsg" /></p>

<form class="form-login" action="./submit" method="post">
    <p>
        <label>
            <spring:message code="univ" /> : <br>
            <input type="text" class="input" name="univ" placeholder="대학">
        </label>
    </p>
    <p>
        <label>
            <spring:message code="dept" /> : <br>
            <input type="text" class="input" name="dept" placeholder="학과">
            <form:errors path="dept" />
        </label>
    </p>
    <p>
        <label>
            <spring:message code="name" /> : <br>
            <input type="text" class="input" name="name" placeholder="이름">
            <form:errors path="name" />
        </label>
    </p>
    <p>
        <label>
            <spring:message code="stdid" /> : <br>
            <input type="text" class="input" name="stdid" placeholder="학번">
            <form:errors path="stdid" />
        </label>
    </p>
    <p>
        <label>
            <spring:message code="email" /> : <br>
            <input type="text" class="input" name="email" placeholder="이메일">
            <form:errors path="email" />
        </label>
    </p>
    <button class="btn" type="submit"><spring:message code="submit" /> </button>
</form>
</body>
</html>
