<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>책 상세 정보</title>
    <script>
      function checkLogin(isLogin, userId) {
        console.log("유저 아이디: " + userId);
        if (userId == "1") {
          alert("admin 유저는 도서를 구매할 수 없습니다.");
          return;
        }
        if (!isLogin) {
          alert("로그인한 유저만 구매할 수 있습니다.");
          return;
        }
        purchaseForm.submit();
      }
    </script>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>책 정보 조회</h3>
<%!
  ResultSet rs;
  boolean isLogin;
  String userId;
%>
<%
  //현재 로그인한 유저 아이디
  userId = (String) session.getAttribute("userId");

  //DB로 부터 받아온 책 정보
  rs = (ResultSet) request.getAttribute("book");
  rs.next();

  //로그인 여부 저장
  if (session.getAttribute("isLogin") == null || (Boolean)session.getAttribute("isLogin") == false) {
    isLogin = false;
  } else {
    isLogin = true;
  }
%>
<img src="<%=rs.getString(6)%>" alt="책 표지"/>
<ul>
  <li>제목: <%=rs.getString(2)%></li>
  <li>출판사: <%=rs.getString(3)%></li>
  <li>가격: <%=rs.getString(4)%></li>
  <li>카테고리: <%=rs.getString(5)%></li>
</ul>
<form action="/order?action=purchase&bookId=<%=rs.getString(1)%>" method="post" name="purchaseForm">
  <div class="submit">
    <input type="button" value="구입하기" onclick="checkLogin(${isLogin}, ${userId})" />
  </div>
</form>
</body>
</html>
