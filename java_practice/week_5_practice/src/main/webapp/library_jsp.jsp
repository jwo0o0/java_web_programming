<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/04/05
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

4주차 - JSP를 활용한 도서 정보 시스템
<html>
<head>
    <title>도서 정보 시스템</title>
    <script>
        function check() {
            const title = document.getElementById("title").value;
            const publisher = document.getElementById("publisher").value;
            const price = document.getElementById("price").value;
            if(title === "") {
                alert("도서 이름을 입력하세요.");
                return;
            }
            if(publisher === "") {
                alert("출판사를 입력하세요.");
                return;
            }
            if(price === "") {
                alert("가격을 입력하세요.");
                return;
            }
            //input에 빈 값이 없을 때만 서블릿 클래스에 post request
            setBook.submit();
        }
    </script>
</head>
<body>
<h1>도서 정보 시스템</h1>
<p>
<h3>신규 도서 등록</h3>
<form method="post" action="booklist_jsp.jsp" name="setBook">
    <label for="title">도서 이름</label>
    <input type="text" name="title" id="title" style="margin-bottom: 10px;"/>
    <br />
    <label for="publisher">출판사</label>
    <input type="text" name="publisher" id="publisher"/>
    <label for="price">가격</label>
    <input type="text" name="price" id="price"/>
    <div class="submit" style="margin-top: 15px">
        <input type="button" value="제출" onclick="check()" style="font-size: 15px;"/>
        <input type="reset" value="다시 입력" style="font-size: 15px;"/>
    </div>
</form>

</p>
</body>
</html>
