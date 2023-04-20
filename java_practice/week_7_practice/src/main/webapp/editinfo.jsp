<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보 수정</title>
    <script>
        function check(userId) {
            if (userId == "1") {
                alert("admin 유저는 회원정보 수정이 불가합니다.");
                return;
            }
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
            editForm.submit();
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>회원정보 수정</h3>
<%!
    String userId;
%>
<%
    userId = (String) session.getAttribute("userId");
%>
<form method="post" action="/user?action=edit" name="editForm">
    <label for="name">이름</label>
    <input type="text" id="name" name="name"><br />
    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password"/><br />
    <label for="address">주소</label>
    <input type="text" id="address" name="address"/><br />
    <label for="phone">핸드폰 번호</label>
    <input type="text" id="phone" name="phone"/><br />
    <div class="submit">
        <input type="button" value="수정하기" onclick="check(${userId})"/>
    </div>
</form>
</body>
</html>
