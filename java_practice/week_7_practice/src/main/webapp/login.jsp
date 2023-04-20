<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <script>
        function check() {
            const name = document.getElementById("name").value;
            const password = document.getElementById("password").value;
            if (name === "") {
                alert("이름을 입력하세요.");
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
<h3>로그인</h3>
<jsp:include page="header.jsp" />
<form action="/user?action=login" method="post" name="loginForm">
    <label for="name">아이디</label>
    <input type="text" id="name" name="name"/><br />
    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password"/><br />
    <div class="submit">
        <input type="button" value="로그인" onclick="check()" />
    </div>
</form>
</body>
</html>
