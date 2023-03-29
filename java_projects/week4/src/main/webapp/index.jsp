<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="calc.jsp">
    <input type="text" name="n1" size="10">
    <select name="op">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
    <input type="text" name="n2" size="10">
    <input type="submit" value="실행">
</form>
<a href="times.jsp">구구단</a>
</body>
</html>