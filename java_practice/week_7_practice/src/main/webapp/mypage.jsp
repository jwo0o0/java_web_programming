<%@ page import="com.example.week_7_practice.MyDB" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>마이페이지</h3>
<%!
    MyDB mydb;
    Connection con;
    ResultSet rs;
    String userId;
%>
<%
    userId = (String) session.getAttribute("userId");

    mydb = new MyDB();
    con = mydb.getCon();

    try {
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM User WHERE userId=\'" + userId +"\';");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    rs.next();
    System.out.println(rs.getString(2) + rs.getString(4) + rs.getString(5));
%>
<p>
    <div>
        이름: <%= rs.getString(2)%>
    </div>
    <div>
        주소: <%= rs.getString(4)%>
    </div>
    <div>
        전화번호: <%= rs.getString(5)%>
    </div>
</p>
<%
    //admin 유저가 아닌 경우에만 회원 정보 수정 페이지 접근
    if (!userId.equals("1")) {
%>
<a href="/editinfo.jsp">회원 정보 수정</a>
<%
    }
%>
</body>
</html>
