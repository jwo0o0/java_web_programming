# 2주차 - 자바 웹 프로그래밍 개요

## 웹

---

### WWW(월드 와이드 웹)

- 웹: 인터넷에서 운영되는 서비스 중 하나 (웹 ≠ 인터넷)

### 웹의 특징

> 인터넷 상의 정보를 하이퍼텍스트 방식과 멀티미디어 환경에서 검색할 수 있게 해주는 정보 검색 시스템
> 
- 인터넷 - 컴퓨터 네트워크 망 / 웹 - 인터넷 서비스 중 하나
- HTTP 프로토콜 사용
- 동작 구조
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0a2bea19-2c33-4278-b56d-9b8cc8e0bd85/Untitled.png)
    

### 클라이언트 - 서버 구조

- 클라이언트: 웹 서비스를 이용하는 사용자
- 서버: 웹 서비스를 제공하는 서비스 공급자
- 프론트엔드: 클라이언트 중심의 프로그래밍 영역 (html, css, javascript)
- 백엔드: 서버를 제공하기 위한 서버 쪽 프로그래밍 영역

### HTML, CSS, JavaScript

- HTML
    - hyper text markup language
    - 웹 문서의 구조를 정의하고 콘텐츠를 표현
- CSS
    - HTML 문서에 레이아웃과 디자인을 적용
- JavaScript
    - HTML 문서에서 동적으로 변하는 콘텐츠를 표현하기 위해 이벤트 처리, 서버와 연결 등등

### 백엔드 중심 개발

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1050e3aa-35b6-4cb9-94c6-3ae037fcdcec/Untitled.png)

- 전통적인 웹 개발 모델
- 자바 서블릿, JSP
- 장점
    - 검색 엔진 최적화에 유리
    - 기술이 안정적이고 검증됨
    - 서비스 연동에 필요한 다양한 서버 환경에 대응 가능
- 단점
    - 모바일 네트워크의 속도가 느림
    - 서버에 화면 갱신 요청시 모든 데이터가 다시 전송

### 프론트엔드 중심 개발

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bd76bb85-c0c6-41be-99cb-f8061b084d66/Untitled.png)

- 클라이언트에서 HTML을 가지고 있거나 서버에서 HTML만 받아 화면 구성에 필요한 데이터만 javascript로 받아와 보여줌
- CSR(Client Side Rendering)
- 장점
    - 필요한 부분만 갱신 가능
    - SPA, PWA 등의 구현에 적용 가능
    - 다양한 프레임워크 사용 가능
- 단점
    - 데이터 제공을 위한 서버가 필욯마
    - 검색 엔진 최적화를 위해 SSR을 접목하기도 함

## 자바 웹 프로그래밍

---

### JVM

- 특정 하드웨어나 운영체제의 영향을 받지 않고 동일한 프로그램 개발이 가능

### 서블릿 컨테이너(WAS, Web Application Server)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cce09b59-7dc1-45d9-a356-1b6d1aa9a540/Untitled.png)

- 웹 애플리케이션을 구동하는 서버
- 서버 컴퓨터가 WAS로 동작하려면 서블릿 컨테이너가 필요