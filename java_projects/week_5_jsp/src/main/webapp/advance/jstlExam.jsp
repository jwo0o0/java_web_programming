<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/03
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>jstl exam</title>
</head>
<body>
  <h2>JSTL core tag examples</h2>
  <hr>

  <!-- set, out -->
  <h3>set, out</h3>
  <c:set var="product" value="<b>apple iphone</b>" />
  <c:set var="intArray" value="${[1,2,3,4,5]}" />

  <p>
    product name(jstl):
    <c:out value="${product}" default="not registered" escapeXml="false" />
    <p>product name(el): ${product} </p>
    <p>array[2] value: ${intArray[2]} </p>
  </p>

  <!-- foreach -->
  <h3>foreach basic</h3>
  <ul>
    <li>print all items in array</li>
    <c:forEach var="num" varStatus="i" items="${intArray}">
      <li>${i.index} : ${num}</li>
    </c:forEach>
  </ul>

  <!-- if -->
  <h3>if</h3>
  <c:set var="checkout" value="true" />
  <c:if test="${checkout}">
    <p>no checkout</p>
  </c:if>
  <c:if test="${!empty product}">
    <p>
      <b>${product} already added</b>
    </p>
  </c:if>
</body>
</html>
