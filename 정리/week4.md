# 4주차 - JSP

# JSP(Java Server Pages)

---

### JSP의 특징

- HTML 페이지에 java 코드를 직접 사용
- 서블릿 컨테이너에 의해 관리되는 내장 객체의 생명 주기를 이용해 페이지 간 속성을 관리(request, session)
- 커스텀 태그 기술 활용
- EL을 통해 데이터를 표현

### JSP의 구성 요소

- 지시어
- 액션
- 템플릿 데이터
- 스크립트 요소
- 커스텀 태그, EL

### JSP의 동작과정

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/284e0246-5bf0-4f12-8d54-9ee11669107e/Untitled.png)

### JSP의 장점

- html에 자바 기술을 무한대로 사용 가능, 쉽게 프로그래밍
- 확장 태그 구조 사용 가능(커스텀 태그 라이브러리 등)
- **서블릿으로 변환되어 실행** → 서블릿 기술의 장점을 가짐
- MVC 패턴, 스프링 프레임워크 등 잘 설계된 구조를 적용 가능
- 모든 개발이 서버에서 이루어짐 → 개발의 집중화를 통한 효율

### JSP의 단점

- 화면 구성 요소 변경시
    
    JSP → java → class → 서블릿 실행
    
    사소한 UI 변경이라도 확인시간이 오래 걸림
    
- 개발자와 디자이너 간 역할 분담에 제약
- JSP 파일의 화면 디자인 확인에도 반드시 서블릿 컨테이너의 실행이 필요

## JSP 지시어

---

```java
<%@ 지시어 속성="값" %>
```

- `page`, `include`, `taglib`
- JSP 컨테이너에 해당 페이지를 어떻게 처리해야 하는지를 전달

### 1. `page` 지시어

```java
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
```

- 현재 JSP 페이지를 컨테이너에서 처리하는데 필요한 속성 기술
- 속성: language, contentType, pageEncoding, import, errorPage

### 2. `include` 지시어

```java
<%@ include file="파일 위치" %>
```

- 사용된 위치에 특정 파일(html, jsp)을 불러옴
- 컨테이너: 포함된 파일을 하나의 서블릿 코드로 처리해 자바 소스를 생성해 서블릿으로 컴파일

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/058fd458-8daf-4343-8539-6cb0cd465a86/Untitled.png)

### 3. `taglib` 지시어

- 커스텀 태그 사용을 위한 지시어

```java
<%@ taglib (uri="태그 라이브러리 경로" 혹은 tagdir="태그 파일 경로") prefix="태그 접두어" %>
```

- **uri**: .tld 파일 경로
- **tagdir**: 태그 파일 경로
- **prefix**: 해당 태그 구분을 위한 접두어

```java
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>

...
<h2><m:printData /></h2>
```

## 템플릿 데이터와 스크립트 요소

---

### 템플릿 데이터

- JSP의 화면 구성 요소
- 일반적인 HTML 파일처럼 css, javascript도 사용 가능
- 데이터 표현은 JSTL과 EL을 활용

### 스크립트 요소

- JSP는 html과 자바 코드를 섞어 사용할 수 있는데, 이 때 사용되는 자바 코드
1. **선언 태그** `<%! %>`
    - JSP에서는 일반 자바 코드와 달리 멤버 변수나 메서드 선언 불가
        
        이 때 필요하다면 사용할 수 있음, but 권장 X
        
2. **표현 태그** `<%= %>`
    - 웹 브라우저를 통해 클라이언트에 전달될 자바 표현식 포함
    - `out.println()`의 인자로 적합한 모든 자바 코드가 가능
    
    ```java
    <h2><%= member.getUserName() %></h2>
    현재 날짜와 시간: <%= java.time.LocalDateTime.now() %>
    ```
    
3. **스크립트릿(Scriptlet) 태그** `<% %>`
    - 모든 자바 코드 사용 가능 (단, _jspService() 메서드 내에 포함될 것을 고려)
    - 서블릿 코드로 변환시 모든 html은 out.write() 형태로 변경됨
    - MVC 패턴 적용과 JSTL + EL 로 대체 가능

```java
<% String name = request.getParameter("uname");
%>

<h2><%= name %></h2>

<table>
	<% for(Member m : mlist) { %>
		<tr>
			<td><%=m.name %></td>
			<td><%=m.email %></td>
		</tr>
	<% } %>
</table>
```

```java
<tabel>
	<%
		for(Member m : mlist) {
			out.println("<tr><td>"+m.name+"</td></tr>");
		}
	%>
</table>
```

## JSP와 서블릿의 관계

---

### JSP 파일의 서블릿 변환 처리

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a7db3a8f-2a26-4a8f-863a-e2aba3815530/Untitled.png)

- JSP 파일이 서블릿으로 컴파일 됨!