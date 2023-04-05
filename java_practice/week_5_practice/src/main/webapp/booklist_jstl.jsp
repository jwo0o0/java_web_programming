<%@ page errorPage="error/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <%@page import="Data.Book" %>
  <%@page import="java.util.ArrayList" %>

  <%!
    ArrayList<Book> books = new ArrayList<>();
  %>

  <c:if test="${empty books}" scope="session" var="result">
    <%
      //session scope에 books가 없는 경우 초기화 및 session에 할당
      books.add(new Book(1, "축구의 역사", "굿스포츠", 7000));
      books.add(new Book(2, "축구 아는 여자", "나무수", 13000));
      books.add(new Book(3, "축구의 이해", "대한미디어", 22000));
      books.add(new Book(4, "골프 바이블", "대한미디어", 35000));
      books.add(new Book(5, "피겨 교본", "굿스포츠", 8000));
      session.setAttribute("books", books);
    %>
  </c:if>

  <%
    books = (ArrayList<Book>) session.getAttribute("books");
  %>

  <%
    //request로 받은 새로운 책 정보로 Book 인스턴스 생성 후 books 배열에 추가
    String title = request.getParameter("title");
    String publisher = request.getParameter("publisher");
    int price = Integer.parseInt(request.getParameter("price"));

    Book newBook = new Book(books.size() + 1, title, publisher, price);
    books.add(newBook);
  %>
  <!-- session에 새로운 도서 정보가 추가된 배열 할당 -->
  <c:set value="${books}" var="books" scope="session" />

  <div class="flex box index">
    <div class="bookId center">도서 번호</div>
    <div class="title">도서 이름</div>
    <div class="publisher">출판사</div>
    <div class="price">가격</div>
  </div>

  <!-- session에서 가져온 도서 배열 JSTL로 출력 -->
  <c:forEach var="book" items="${books}" varStatus="status" end="${books.size()}">
    <div class="flex box">
      <div class="bookId center">${book.getBookId()}</div>
      <div class="title">${book.getTitle()}</div>
      <div class="publisher">${book.getPublisher()}</div>
      <div class="price">${book.getPrice()}</div>
    </div>
  </c:forEach>
<br>
  <a href="/index.jsp">홈으로 돌아가기</a>
</body>
</html>
