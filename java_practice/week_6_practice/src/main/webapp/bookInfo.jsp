<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>책 상세 정보</title>
    <script>
        function checkLogin(isLogin) {
            if (!isLogin) {
                alert("로그인한 유저만 구매할 수 있습니다.");
                return;
            }
            purchaseForm.submit();
        }
    </script>
</head>
<%!
    boolean isLogin;
%>
<%
    if (session.getAttribute("isLogin") == null || (Boolean)session.getAttribute("isLogin") == false) {
        isLogin = false;
    } else {
        isLogin = true;
    }
%>
<body>
<jsp:include page="header.jsp" />
    <h3>책 정보 조회</h3>
    <img src="${book.imgLink}" alt="책 표지"/>
    <ul>
        <li>제목: ${book.title}</li>
        <li>출판사: ${book.publisher}</li>
        <li>가격: ${book.price}</li>
        <li>분류: ${book.category}</li>
    </ul>
    <form action="/purchase?bookId=${book.bookId}" method="post" name="purchaseForm">
        <div class="submit">
            <input type="button" value="구입하기" onclick="checkLogin(${isLogin})" />
        </div>
    </form>
</body>
</html>
