<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>도서 추가</title>
    <script>
      function check(userId) {
        if (userId !== 1) {
          alert("admin 유저만 책 추가가 가능합니다.");
          return;
        }
        const title = document.getElementById("title").value;
        const publisher = document.getElementById("publisher").value;
        const price = document.getElementById("price").value;
        const category = document.getElementById("category").value;
        if (title == "") {
          alert("제목을 입력하세요.");
          return;
        }
        if (publisher == "") {
          alert("출판사를 입력하세요.");
          return;
        }
        if (price == "") {
          alert("가격을 입력하세요.");
          return;
        }
        if (category == "") {
          alert("카테고리를 입력하세요.");
          return;
        }
        addBookForm.submit();
      }
    </script>
</head>
<body>
<jsp:include page="header.jsp" />
<%!
  int userId;
%>
<%
  if (session.getAttribute("userId") != null ) {
    userId = Integer.parseInt((String) session.getAttribute("userId"));
  }
%>
<h3>도서 추가 페이지</h3>
<form method="post" action="/admin?action=add" name="addBookForm"/>
  <label for="title">제목</label>
  <input type="text" id="title" name="title"><br />
  <label for="publisher">출판사</label>
  <input type="text" id="publisher" name="publisher"><br />
  <label for="price">가격</label>
  <input type="text" id="price" name="price"><br />
  <label for="category">카테고리</label>
  <input type="text" id="category" name="category"><br />
  <label for="imgLink">이미지 주소</label>
  <input type="text" id="imgLink" name="imgLink"><br />
  <div class="submit">
    <input type="button" value="책 추가" onclick="check(${userId})"/>
  </div>
</form>
</body>
</html>
