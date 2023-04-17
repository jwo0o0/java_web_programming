<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <script>
        function check() {
            const userId = document.getElementById("userId").value;
            const password = document.getElementById("password").value;
            if (userId === "") {
                alert("아이디를 입력하세요.");
                return;
            }
            if (password === "") {
                alert("비밀번호를 입력하세요.");
                return;
            }
            loginForm.submit();
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp" />
    <h3>로그인</h3>
    <form action="/user?action=login" method="post" name="loginForm">
        <label for="userId">아이디</label>
        <input type="text" id="userId" name="userId"/><br />
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password"/><br />
        <div class="submit">
            <input type="button" value="로그인" onclick="check()" />
        </div>
    </form>
</body>
</html>
