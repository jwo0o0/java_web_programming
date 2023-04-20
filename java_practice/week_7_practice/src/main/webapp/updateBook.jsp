<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>도서 정보 수정</title>
    <script>
        function check() {
            const publisher = document.getElementById("publisher").value;
            const price = document.getElementById("price").value;
            const category = document.getElementById("category").value;
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
            updateBookForm.submit();
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp" />
<%!
    ResultSet rs;
%>
<%
    rs = (ResultSet) request.getAttribute("info");
    rs.next();
%>
<h3>도서 정보 수정</h3>
<form method="post" action="/admin?action=update&bookId=<%=rs.getString(1)%>" name="updateBookForm">
    <label for="title">제목</label>
    <input type="text" id="title" name="title" readonly value="<%= rs.getString(2)%>"><br/>
    <label for="publisher">출판사</label>
    <input type="text" id="publisher" name="publisher" /><br/>
    <label for="price">가격</label>
    <input type="text" id="price" name="price" /><br/>
    <label for="category">카테고리</label>
    <input type="text" id="category" name="category" /><br/>
    <label for="imgLink">이미지 주소</label>
    <input type="text" id="imgLink" name="imgLink" /><br/>
    <div class="submit">
        <input type="button" value="수정하기" onclick="check()" />
    </div>
</form>
</body>
</html>
