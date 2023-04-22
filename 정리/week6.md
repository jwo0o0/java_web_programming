# 6주차 - MVC 패턴과 프로젝트 관리

# MVC 패턴 개요

## 디자인 패턴

---

### 시초

- 건축학적 관점에서 출발 - 이후 컴퓨터 과학 등 다른 분야에도 도입
- 1994년 GoF가 소프트웨어 설계에서 **공통적으로 발생하는 문제에 대한 재사용 가능한 솔루션**으로 제시함
    
    (생성, 구조, 행동, 동시실행 등의 문제에 대한 여러 패턴을 제시)
    

### 디자인 패턴 개념

> **객체지향 프로그래밍 설계를 할 때 자주 발생하는 문제들을 피하기 위해 사용되는 패턴**
> 
- **의사소통 수단의 일종**으로서 아래 문제를 해결
    - 여러 사람이 협업할 때 다른 사람이 작성한 코드를 이해하기 어려움
    - 코드를 수정하거나 새로운 기능을 추가할 때 의도치 않은 결과나 버그 발생

## 추상 팩토리 패턴

---

### 추상(abstract)

- 자바의 추상 클래스 `abstract class`에도 사용되는 표현으로 **구체적인 내용의 구현을 하위 객체에 위임**하는 모델

### 팩토리(Factory)

- 팩토리: **디자인 패턴에서** **객체를 생성하는 역할**
- 직접적인 객체 생성 대신 **팩토리 클래스에 객체 생성을 위임**

### 추상 팩토리

> 객체를 생성하는 것을 별도로 구현하되, 관련된 구체적인 구현을 하위 클래스에서 담당하게 하는 설계 모델
> 
- 객체를 만드는 곳과 이용하는 곳의 분리
- 추상 모델로 객체를 구현 → 팩토리에서 생성

### 추상 팩토리 패턴의 적용

```jsx
MemeberDAO dao = new MemberDAO();
dao.insertDB(p);
...
```

- `MemberDAO` 클래스가 특정 DBMS에 종속된 경우 다른 DBMS에서도 사용하려면 `MemberDAO` 클래스를 수정해야 함

```jsx
MemberDAO dao = DAOFactory.create("mysql");
dao.insertDB(p);
...
```

- `DAOFactory` 클래스에서 `MemberDAO` 클래스 객체를 생성해서 리턴

## MVC 패턴

---

- MVC: **Model - View - Controller**
- GUI 기반의 애플리케이션 개발에 사용되는 패턴
- 백엔드 기반의 웹 애플리케이션 개발의 기본 모델이 됨

→ **목적: 화면과 데이터 처리를 분리**해 코드 간 종속성 ↓

→ 구성 요소간 역할을 명확하게 해 코드를 쉽게 분리하고 협업이 용이

### MVC 패턴 구조

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/abfd2779-a002-4099-89ab-d49cedd37280/Untitled.png)

### MVC 패턴을 사용한 애플리케이션의 흐름

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/56253370-3e5b-4628-890a-5ec11aa6178a/Untitled.png)

- 모델 - 뷰는 직접적인 연동은 없고 컨트롤러를 통해 소통

## 모델(Model)

---

- 데이터를 처리하는 영역(데이터 정의, 어떻게 데이터가 저장되는지 ..)
- DBMS와 연동을 위한 **`DAO`**(Data Access Object) 클래스와
    
    데이터 구조를 표현하는 **`DO`**(Data Object, 엔티티 클래스) 등으로 구성
    
- **뷰나 컨트롤러에 독립적**인 구조
    
    → 데이터베이스 처리를 필요로 하는 여러 애플리케이션에서 공유 가능
    
    → 웹 애플리케이션이 아닌 곳에서도 사용 가능
    

## 뷰(View)

---

- 화면 구성을 담당
- **주어진 데이터를 출력하는 용도**로만 사용하는 것이 바람직함
- 뷰에서 DB를 가져오는 방식은 X
- 뷰 영역 구현을 위해 **뷰 템플릿 엔진**이 사용됨 (ex. JSP, Thymeleaf)
- HTML 이외에 EL, JSTL 등을 사용해 **컨트롤러에게 전달 받은 데이터를 출력**
- **모델, 컨트롤러와 종속성이 없도록** 구현해야 함

## 컨트롤러(Controller)

---

- **사용자 요청**: 특정 뷰에 바로 전달되지 않고 **컨트롤러를 통해야 함**
- **컨트롤러**: 사용자 요청에 따라 **모델을 통해 데이터베이스와 연동해 데이터를 처리하고 뷰에 전달**
- 뷰로 전달하기 위해 데이터가 들어있는 `DO` 혹은 `List<DO>` 형태의 객체를 request에 저장한 후 포워딩
- 특정 뷰를 지정해야 하기 때문에 뷰와 종속관계가 발생 → 프로젝트 규모가 클수록 복잡해지고 관리 어려움

### 컨트롤러의 구현

- **JSP**: 간단한 기능 구현에 유리
- **서블릿**: 규모 확장과 향후 스프링 프레임워크로 확장에 유리
- 컨트롤러 구성 방법
    1. 사용자 요청마다 만들기
    2. 특정 모듈 단위로 하나의 컨트롤러 안에서 요청 단위로 구분
    3. 프론트 컨트롤러를 따로 두어 모든 요청을 모은 다음 구현 컨트롤러 호출

# MVC 패턴의 적용

스프링 프레임워크 → 이미 MVC 패턴 설계가 반영됨

## 서블릿 컨트롤러 설계

---

### 기본 기능

1. **클라이언트 요청 처리**
2. **입력값 핸들링**
3. **뷰 이동**

## 클라이언트 요청 처리

---

**서블릿**: URL 요청을 GET, POST 등 **HTTP 메서드**를 통해 처리

- 사용자의 요청을 구분해 하나의 서블릿에서 처리하는 방법
    1. URL 파라미터 이용
    2. 프론트 컨트롤러 구현

### 1. URL 파라미터 이용

- URL에 별도의 파라미터를 두어 요청을 구분

```jsx
* http://xxx.com/member?action=create
* http://xxx.com/member?action=login
```

- action에 따라 분기
- 간단하지만 파라미터 구조 변경시 html, jsp, 컨트롤러 수정해야 함

### 2. 프론트 컨트롤러 구현

- 모든 요청의 진입점이 되는 컨트롤러 → 서브 컨트롤러 호출

```jsx
* http://xxx.com/member/create.do
* http://xxx.com/member/login.do
```

- `*.do`: 서블릿 URL 매핑값으로 모든 요청은 하나의 서블릿을 호출
- 컨트롤러는 `.do` 앞 요청 이름으로 구분해 별도의 메서드 혹은 서브 클래스 실행
- 장점:
    - 요청에 대한 파라미터 없이 명확한 이름으로 요청 가능
    - 요청에 대한 URL 관리가 필요 없음
- 단점:
    - 시스템이 크고 분산되어 있는 경우 콘텍스트 분리하면 세션 관리 등에 부담
    - 단일 콘텍스트에 경로로 구분 → 컨트롤러 클래스가 비대해짐

### 입력값 핸들링

서블릿에서 클라이언트의 입력값 처리 → `request.getParameter()`

⇒ 여러 정보가 전달되는 경우 이렇게 하면 문제

- DAO 클래스와 연동을 위해서는 입력값을 Member 객체로 만든 후 전달
    
    ```java
    doGet(...) {
    	Member m = new Member();
    	m.setName(request.getParameter("name"));
    	m.setTel(request.getParameter("tel"));
    	...
    	dao.create(m);
    }
    ```
    
- **JSP** - useBean 액션을 통해 입력값을 쉽게 Member 객체로
- **서블릿** - 별도의 라이브러리를 사용해야 함 ex. Apache Commons BeanUtils
    
    ```java
    doGet(...) {
    	Member m = new Member();
    	BeanUtils.populate(m, request.getParameterMap());
    	...
    	dao.create(m);
    }
    ```
    

### 뷰 이동

- 사용자 요청 처리 → 적절한 뷰로 이동
1. 데이터 포함 X
    - 사용자 요청 처리 후 해당 페이지로 **Redirection**
    
    ```java
    response.sendRedirect("main.jsp");
    ```
    
2. 데이터 포함
    - request scope object에 속성으로 데이터를 넣은 후 원하는 페이지로 포워딩
    - 데이터 활용 목적에 따라 session 또는 application도 활용 가능
    
    ```java
    doGet(...) {
    	...
    	request.setAttribute("member", m);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("userInfo.jsp");
    	dispatcher.forward(request, response);
    }
    ```
    

# 서블릿 컨트롤러 구현 예제

- 여러 요청을 하나의 컨트롤러에서 처리하는 구조
- 기본적으로 MVC 구조

### 뷰 구현

- productList.jsp, productInfo.jsp

### 모델 구현

- Product.java, ProductService.java

### 컨트롤러 구현

- ProductController.java

# 자바 웹 프로젝트 관리

### 수동으로 관리 시

- Dynamic Web Project 생성
- 필요한 외부 라이브러리를 직접 얻어오고 설정

⇒ 번거롭고 알 수 없는 오류가 생길 수 있음

## 자바 빌드 도구

---

- Ant
- **Maven**
    - 스프링 프레임워크에서 기본 빌드 도구
- **Gradle**
    - 안드로이드 앱 개발의 기본 빌드 도구

### 사용 목적

1. 컴파일/실행 설정과 라이브러리 설정
2. 핵심라이브러리만 설정 파일에 등록해두면 해당 라이브러리에 필요한 다른 라이브러리는 자동으로 설치됨

### Maven과 Gradle

- **Maven**
    - 빌드 설정을 `pom.xml`에 작성 - 길어질수록 가독성 ↓
    - 다중 프로젝트 - 특정 설정을 다른 모듈에서 사용하려면 상속받아야 함
- **Gradle**
    - Groovy라고 하는 JVM 기반 언어 사용, 적은 양의 스크립트
    - 다중 프로젝트 - 설정 주입 방식을 사용해 다중 프로젝트에 적합