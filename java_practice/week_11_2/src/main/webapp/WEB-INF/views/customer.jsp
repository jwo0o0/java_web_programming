<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>고객 정보 페이지</title>
    <script>
        function check() {
            const userName = document.getElementById("name").value;
            const password = document.getElementById("password").value;
            if (userName === "") {
                alert("이름을 입력하세요.");
                return;
            }
            if (password === "") {
                alert("비밀번호를 입력하세요.");
                return;
            }
            customerform.submit();
        }
    </script>
</head>
<body>
<h2>고객 정보 페이지</h2>
<form method="post" action="/addcustomer" name="customerform">
    <label for="name">이름</label>
    <input type="text" id="name" name="name"><br />
    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password"/><br />
    <label for="address">주소</label>
    <input type="text" id="address" name="address"/><br />
    <label for="phone">핸드폰 번호</label>
    <input type="text" id="phone" name="phone"/><br />
    <div class="submit">
        <input type="button" value="회원가입" onclick="check()"/>
    </div>
</form>
</body>
</html>
