<%--
  Created by IntelliJ IDEA.
  User: jwo0o0
  Date: 2023/03/29
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>도서 목록</title>
    <link href="../style/booklist.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>도서 목록</h2>
<%@include file="../nav.jsp"%>
<%@page import="Data.Book" %>
<%@ page import="java.util.ArrayList" %>
<%
    //Book 인스턴스를 저장하는 배열 books 선언 및 초기화
    ArrayList<Book> books = new ArrayList<>();
    books.add(new Book(1, "축구의 역사", "굿스포츠", 7000));
    books.add(new Book(2, "축구 아는 여자", "나무수", 13000));
    books.add(new Book(3, "축구의 이해", "대한미디어", 22000));
    books.add(new Book(4, "골프 바이블", "대한미디어", 35000));
    books.add(new Book(5, "피겨 교본", "굿스포츠", 8000));
%>
<%
    //request로 받은 새로운 책 정보로 Book 인스턴스 생성 후 books 배열에 추가
    String title = request.getParameter("title");
    String publisher = request.getParameter("publisher");
    int price = Integer.parseInt(request.getParameter("price"));

    Book newBook = new Book(books.size() + 1, title, publisher, price);
    books.add(newBook);
%>
<div class="flex box index">
    <div class="bookId center">도서 번호</div>
    <div class="title">도서 이름</div>
    <div class="publisher">출판사</div>
    <div class="price">가격</div>
</div>
<%
    for (int i = 0; i < books.size(); i++) {
%>
<div class="flex box">
    <div class="bookId center"><%= books.get(i).getBookId() %></div>
    <div class="title"><%= books.get(i).getTitle() %></div>
    <div class="publisher"><%= books.get(i).getPublisher() %></div>
    <div class="price"><%= books.get(i).getPrice() %></div>
</div>
<%
    }
%>
</body>
</html>
