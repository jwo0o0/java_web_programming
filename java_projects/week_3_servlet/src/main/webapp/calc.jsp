<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/03/19
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Calculator</title>
</head>
<body>
  <h2 align="center">계산기</h2>
    <form name="f1" action=./calc method="post">
      <input type="text" name=num1 width="12" size="10">
        <select name="operator">
          <option selected>+</option>
          <option>-</option>
          <option>*</option>
          <option>/</option>
        </select>
      <input type="text" name=num2 width="12" size="10">
      <input type="submit" value="계산" name="B1">
      <input type="reset" value="다시 입력" name="B2">
    </form>
</body>
</html>
