# 3주차 - 서블릿

## 자바 서블릿(Java Servlet)

---

> 자바를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양
> 
- 웹 서버의 성능을 향상하기 위해 사용되는 **자바 클래스의 일종**
- 자바로 만들어진 프로그램을 서버에서 실행하기 위해 만들어짐
    
    → 웹 서비스 개발에 특화, DB 연동, 외부 서비스 연동을 통해 정적인 웹에 `동적인 정보 제공`
    
- **JSP**: HTML 문서 안에 java 코드를 포함
- **서블릿**: java 코드 안에 HTML을 포함
- **동작 과정**
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/38c52424-9441-4fd1-a9fc-add2575880c6/Untitled.png)
    

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a1b9ff1b-63b1-45fc-9c52-b6df22ad62f5/Untitled.png)

### 장점

- **java 기반**으로 하므로 java API를 모두 사용 가능
- OS나 하드웨어의 영향을 받지 않음
- 웹 애플리케이션에서 효율적인 자료공유 방법 제공
- 다양한 오픈소스 라이브러리, 개발도구

### 단점

- HTML 응답을 위해 출력문으로 문자열 결합
- 서블릿에서 HTML 포함할 경우 화면 수정이 어려움
- form 데이터 처리가 불편
- 기본적으로 **단일 요청과 응답을 처리**
    
    → **다양한 경로의 URL 접근을 하나의 클래스에서 처리하기 어려움**(ex. Rest API)
    

### 서블릿 클래스 구현

서블릿: java 코드로 구현 → 서블릿 컨테이너에 해당 클래스가 서블릿임을 알려야 함, 어떤 URL 접근에 실행해야하는지 등록

- 기본적으로는 web.xml에 등록
- 지금은 `자바 애너테이션` 이용

### 서블릿 클래스 구조

- `java.servlet.Servlet` 인터페이스를 구현한 추상 클래스인 `GenericServlet` 클래스와 `**HttpServlet**` 클래스 중 하나를 상속해 구현
    
    (일반적인 웹 개발은 HTTP 프로토콜에 최적화되어 있는 HttpServlet 클래스를 상속)
    

**`HttpServletRequest`**

- HTTP 프로토콜의 request 정보를 서블릿에 전달
- 클라이언트 요청이 전달될 때 인자로 함께 전달됨
- 주요 메서드
    - getParameter(), getRequestURL, getMethod, …

`**HttpServletResponse**`

- 서버에서 클라이언트로 전달하려는 목적으로 구성됨
- 서블릿 컨테이너 - HttpServletResponse 객체를 생성해 서블릿에 전달
- 주요 메서드
    - sendRedirect(), getWriter(), setContentType(), addHeader() …

### 서블릿 정보 등록

- 서블릿 3.0 → **자바 애너테이션** 사용 가능

### 서블릿 생명 주기

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6cb690de-0360-4053-b5a7-aab1847b1caf/Untitled.png)

- **서블릿 초기화**: `**init()**` 메서드
    
    클라이언트 요청 → 컨테이너가 해당 서블릿이 메모리에 있는지 확인
    
    - 없다면 init() 메서드가 호출되며 각종 초기화 작업 수행
    - 실행 중 서블릿이 변경되면 destroy되고 다시 시작되면서 init
- **요청/응답**: `**service()**` 메서드
    
    service() 메서드를 통해 각각 doGet()이나 doPost()로 분기
    
    이 때 파라미터로 `HttpServletRequest`, `HttpServletResponse` 클래스 타입인 request와 response 객체가 제공됨
    
- **서블릿 종료:** `**destroy()**` 메서드
    
    컨테이너로부터 서블릿 종료 요청 → destroy() 메서드
    

### 페이지 이동

1. **데이터를 포함하지 않는 경우**
    
    사용자 요청 처리 → 바로 리디렉션
    
    `**response.sendRedirect**(”main.jsp”);`
    
    (세션에 데이터를 저장하 경우 → 세션이 유효한 동안 모든 페이지에서 세션 정보를 참조 가능 → 리디렉션을 통해서도 데이터 참조 가능)
    
2. **데이터를 포함하는 경우**
    - request 속성으로 데이터를 넣은 후 원하는 페이지로 포워딩
    - session이나 application 사용 가능
    
    ```java
    //서블릿으로 구현
    doGet(...) {
    	...
    	request.setAttribute("member", m);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("userInfo.jsp");
    	dispatcher.forward(request, response);
    }
    ```
    

### URL rewriting

- HTTP의 Query String 이용 → URL에 파라미터를 추가해 서버로 요청

ex) `https://www.xxx.com/shop/productInfo?user=jwoo&p1=0112&p2=12021`

### 속성관리 - 쿠키(Cookie)

> 클라이언트에 저장되는 작은 정보
> 

+) [더보기](https://www.notion.so/3-7-Backend-Axios-OAuth-144431f9db734f46b36a26b8952d26ce)

- 특징
    - 파일로 클라이언트의 컴퓨터에 저장 → 보안상 문제 발생 가능
    - 재방문 등의 확인용도로 많이 사용
    - 주로 js를 통해 처리하지만 HttpOnly 설정으로 서버에서만 사용할 수 있도록 설정 가능

![쿠키의 동작 과정](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6e1be146-7ae6-4788-af5c-60cf6fccb87c/Untitled.png)

쿠키의 동작 과정

- **쿠키 저장 방법**
    
    ```java
    response.addCookie(new Cookie("name", "jwoo"));
    response.addCookie(new Cookie("tel", "010-1234-1234"));
    response.addCookie(new Cookie("email", "jwoo@email.com"));
    ```
    

### 속성관리 - 세션(Session)

+) [더보기](https://www.notion.so/3-7-Backend-Axios-OAuth-144431f9db734f46b36a26b8952d26ce)

> 클라이언트가 웹 애플리케이션 서버에 접속할 때 서버 쪽에 생성되는 공간 (내부적으로는 세션 아이디를 통해 참조됨)
> 
- **브라우저**:
    - 서버에 접속할 때 발급받은 세션 아이디 기억
    - 세션 ID는 암호화되어있고 유일함
- **서버**:
    - 저장소에 세션을 저장
    - 해당 세션 아이디로 할당된 영역 접근
- **특징**
    - 세션 유효 시간이나 브라우저 종료 전까지 유지 → 서로 다른페이지에서 정보 공유 가능
    - 로그인 유지, 장바구니, 컨트롤러 구현 등에서 사용
    - 사용자마다 생성됨
    - 동시에 많은 사용자가 세션을 통해 다량의 데이터를 관리한다면 충분한 메모리를 비롯한 세션 관리 대책 필요

### 속성관리 - Scope Object

> 컨테이너에서 **서블릿 관리를 위해 자동으로 생성한 객체 중 속성 관리 기능**을 제공
> 
- 특정 범위 동안 유지되는 객체
- 각각의 객체
    - 관리 목적에 따라 별도의 메서드로 구현된 기능을 가짐
    - 공통적으로 ‘키-값’ 형태의 Map 자료구조를 가짐 → 페이지 간, 사용자 간 데이터 공유
- JSP도 서블릿으로 변환되기 때문에 동일함
- 객체 - 각각 생성, 소멸시기가 정해져 있음, 서로 다른 JSP, 서블릿 간의 데이터 전달이나 공유를 위한 용도로 활용
    
    (useBean 액션의 scope에 사용되는 `page`, `request`, `session`, `application`이 해당)
    

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e039ecb7-4211-4966-be83-e8d37759a1cb/Untitled.png)

- 특징
    - Request와 Session을 주로 활용
    - 모든 사용자가 공유하거나 웹 애플리케이션 전체에서 참조가 필요한 경우 → Web Context 사용
    
    ```java
    속성을 저장하고 참조하기 위해 다음 메서드가 공통적으로 제공됨
    setAttribute(String name, Object o) //속성 저장
    Object getAttribute(String name) //속성 참조
    ```
    
    - 주의! - 저장하고자 하는 데이터가 Object 형태임
        
        ```java
        데이터를 가지고 올 때 return된 Object 타입을 원래 저장된 데이터 타입으로 변환
        String name = "홍길동";
        request.setAttribute("name", name);
        String rname = (String) request.getAttribute("name");
        ```