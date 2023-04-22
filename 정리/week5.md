# 5주차 - JSP 응용

### 에러 처리 페이지

```sql
error.jsp

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	...
	<%= exception.getClass().getName() %>
	<%= exception.getMessage() %>
	...
</html>
```

## 액션 태그

---

> JSP에서 객체 생성과 공유, 페이지 이동과 전달, 태그 파일 작성 등에 필요한 기능을 제공하는 커스텀 태그
> 
- 커스텀 태그 기반이지만 별도의 taglib 지시어 없이 jsp 접두어
- JSP를 컨트롤러로 활용할 때 유용

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b7a7d275-4e42-43a8-b9dc-3b9348449aac/Untitled.png)

### forward 액션

```java
//main.jsp
<jsp:forward page="result.jsp>
	<jsp:param name="title" value="My homepage" />
</jsp:forward>

//result.jsp
<h2><%= request.getParameter("title") %></h2>
```

- 클라이언트 요청을 다른 페이지로 전환
- response.sendRedirect()와 기능적으로 유사, 내부적으로는 차이
    - `response.sendRedirect()`: 단순 페이지 이동시 사용, 서버가 클라이언트에게 새로운 페이지로 다시 접속하도록 응답을 보내고 클라이언트가 다시 새로운 페이지로 접속
    - `foward` 액션: 최초 request를 유지하거나 request의 setAttribute()로 속성값을 저장하고 유지하면서 페이지를 이동, 클라이언트가 새로 접속하는 것이 아니라 **서버에서 내부적으로 새로운 페이지로 이동** → 클라이언트에게 response

### include 액션

- **include 지시어**: include 된 파일 구조를 모두 포함해 하나의 파일로 컴파일한 다음 처리
    
    include 된 파일이 따로 컴파일되지 않음
    
- **include 액션**: include 된 파일을 각각 호출해 처리된 결과만 포함해 보여줌
    
    include된 파일이 각각 컴파일됨
    

```java
//main.jsp
<jsp:include page="header.jsp">
	<jsp:param name="title" value="My homepage" />
</jsp:include>
//jsp:param 액션을 통해 파라미터 값 수정 가능
//header.jsp가 호출될 때 URL은 header.jsp?title=My homepage 

//header.jsp
<h2><%= request.getParameter("title") %></h2>
```

---

### 자바 빈(Java Bean)

> 자바의 재활용 가능한 컴포넌트 모델
> 
- **요구 사항**
    - 인자가 없는 생성자(기본 생성자)로 구성
    - 직렬화 가능
    - getter, setter 메서드를 통한 멤버변수 접근
- **POJO**(Plain Old Java Object):
    
    특정 기술이나 프레임워크에 종속하지 않고기본 생성자와 멤버 변수에 대한 getter, setter 메서드를 제공하고 직렬화 할 수 있는 자바 클래스
    
     ex) 엔티티 클래스 혹은 DO(Data Object)는 기본적으로 테이블 칼럼에 해당하는 private 멤버변수와 getter, setter 메서드로 구성
    

⇒ **캡슐화의 하나의 형태**

### useBean 액션

> JSP에서 자바 빈 객체를 생성하거나 참조하기 위한 액션
> 
- JSP를 단순히 뷰 역할로만 사용한다면 사용할 일은 없음
- **동작 방식**
    1. useBean을 이용해 만든 객체의 범위를 지정하는 속성인 scope에 주어진 id의 객체가 있는지 확인
    2. 객체가 없다면 새로 객체를 생성하고 해당 scope에 저장
- **scope**
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b4ff6ac7-9583-48e7-af3f-b483b9249d2b/Untitled.png)
    
- **자바 빈 구조**
    
    회원관리를 위한 Member 클래스를 자바 빈 구조로 표현
    
    ```java
    class Member { //클래스 선언
    	private int id;
    	private String name;
    	private String email;
    	...
    	public void setId(int id) { //setter 메서드 선언
    		this.id = id;
    	}
    	public int getId() { //getter 메서드 선언
    		return id;
    	}
    	...
    }
    ```
    
- useBean 액션의 구문 구조
    
    ```java
    <jsp:useBean id="instanceName" 
    	scope="page | request | session| application" 
    	class="packageName.className" 
    	type="packageName.className" 
    	beanName="packageName.className" ></jsp:useBean>
    ```
    
    - **id**: 자바 빈을 특정 scope에 저장하거나 가져올 때 사용하는 이름
    - **scope**: 해당 클래스 타입의 객체를 저장하거나 가지고 오는 범위로 내장 객체의 일부
    - **class**: 생성하거나 참조하려는 객체의 클래스명 (반드시 패키지명까지 명시, 추상클래스나 인터페이스는 X)
    - **type**: 특정 타입의 클래스를 명시할 때 사용(추상 클래스나, 인터페이스, 일반 클래스 가능, class 속성의 클래스에서 상속 or 구현이 이루어져야 함)
    - **beanName**: type과 beanName 사용으로 class 속성 대체 가능
- useBean 활용
    
    ```java
    <jsp:useBean id="m" class="com.my.Member" />
    <jsp:setProperty name="m" property="*" />
    
    <% 
    	MemberDAO dao = new MemberDAO();
    	dao.insertDB(m);
    %>
    //DAO(Data Access Object): DB의 data에 접근하기 위한 객체
    //(DB에 접근하기 위한 로직을 분리하기 위해 사용)
    ```
    

## 커스텀 태그와 표현 언어

---

### 커스텀 태그

- 스크립트릿 사용을 줄이고 재활용 가능한 구조
- XML(HTML) 태그 구조지만 **서블릿 형태로 변환시 자바 코드로 변경되어 통합**
- taglib 지시어를 사용해 커스텀 태그가 어디에 정의되어 있는지 먼저 선언하고 접두어를 지정해야 함

```java
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
//WEB-INF/tags/printData.tag 파일로부터 태그 정의를 가지고 옴

<m:printData pid="87559969" />
```

### 액션 태그 vs. 커스텀 태그

- **액션 태그:**
    
    일종의 커스텀 태그지만 JSP에서 기본적으로 지원, taglib 지시어 없이 사용 가능
    
- **커스텀 태그:**
    
    기본적으로 지원하지 않는 내용을 개발자가 추가한 것, taglib 지시어 필요
    

---

### 표현언어(EL)

- 현재 페이지의 자바 객체 혹은 scope object에 저장된 자바 빈 객체를 손쉽게 접근하고 사용할 수 있게 함
- JSP에서 사용한 자바 객체를 직접 사용할 수는 없음
- 장점
    - 간단한 구문으로 변수/객체 참조
    - 데이터가 없거나 null 객체 참조시 에러 발생 X
- 자바 빈 접근: `${저장이름.변수명}`

### 클래스 멤버에 접근하기

- EL
    
    ```java
    <h2>멤버정보<h2>
    이름: ${m.name} <br>
    ```
    
- 표현식
    
    ```java
    이름: <%= m.name %> <br>
    ```
    
- 액션
    
    ```java
    이름: <jsp:getProperty name="m" property="name" /><br>
    ```
    

### EL 연산

```java
${10+20}
${10*20}
${true && false}
${10 >= 20}
${user.name == "홍길동" ? "교수" : "학생"}
```

```java
${myList[0]} //배열 데이터
${myMap["name"]} //맵 데이터
```

### EL 기본 객체

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dc09f318-4322-4525-ac3f-9dc1bd00ba39/Untitled.png)

- Scope Object 접근
    - EL: 기본적으로 모든 scope에서 자바 빈 객체 찾음
        
        → 특정 scope만을 대상으로 참조시 `scope.속성이름`
        
        ex. session과 request에 모두 ‘m’이라는 객체가 있을 때 request scope의 객체 참조시 `${requestScope.m.name}`
        

## JSTL

---

### JSTL(JSP Standard Tag Library)

> JSP에서 스크립트릿을 사용하지 않고 HTML 형식을 유지하면서 간다한 연산과 같은 기능을 손쉽게 할 수 있도록 만들어진 표준 커스텀 태그 라이브러리
> 
- **서버에서만 해석**할 수 있는 구조
- 개발 과정에서 **UI 확인을 위해 서버를 통해야 함** : 모바일 환경 중심의 프론트엔드 개발 트렌드와는 거리가 있음

### core 라이브러리

- 변수 처리, 흐름 제어, URL 관리, 출력 등 가장 기본적인 기능을 구현해둔 라이브러리
- 종류
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/da7dcfcf-a76e-4ca1-a454-9c62d7a92dd7/Untitled.png)
    
- `<c:out>`
- `<c:set>`
- `<c:remove>`
- `<c:catch>`
- `<c:if>`
- `<c:choose>`
- `<c:when>`
- `<c:forEach>`
- `<c:forTokens>`
- `<c:param>`
- `<c:import>`
- `<c:url>`
- `<c:redirect>`

## JSTL 응용