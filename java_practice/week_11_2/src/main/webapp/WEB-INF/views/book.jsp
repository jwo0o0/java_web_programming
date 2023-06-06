<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>도서 정보 페이지</title>
    <script>
        function check() {
            const bookname = document.getElementById("bookname").value;
            const publisher = document.getElementById("publisher").value;
            const price = document.getElementById("price").value;
            if (bookname === "") {
                alert("책 제목을 입력하세요.");
                return;
            }
            if (publisher === "") {
                alert("출판사를 입력하세요.");
                return;
            }
            if (price === "") {
                alert("가격을 입력하세요.");
                return;
            }
            bookform.submit();
        }
    </script>
</head>
<body>
<h2>도서 정보 페이지</h2>
<form method="post" action="/addbook" name="bookform">
    <label for="bookname">제목</label>
    <input type="text" id="bookname" name="bookname"><br />
    <label for="publisher">출판사</label>
    <input type="text" id="publisher" name="publisher"><br />
    <label for="price">가격</label>
    <input type="text" id="price" name="price"><br />
    <div class="submit">
        <input type="button" value="도서추가" onclick="check()" />
    </div>
</form>
</body>
</html>
