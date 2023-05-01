## 스프링 프레임워크

---

- 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크

### 스프링의 특징

- 경량 컨테이너로서 자바 객체를 직접 관리: 각 객체의 생성, 소멸과 같은 라이프 사이클을 관리함
- 제어 반전(IoC: Inversion of Control) 지원:
    
    컨트롤의 제어권이 사용자가 아니라 프레임워크에 있음
    
- 의존성 주입(DI: Dependency Injection) 지원:
    
    각각의 계층이나 서비스들 간에 의존성이 존재할 경우 프레임워크가 연결시킴
    
- 관점 지향 프로그래밍(AOP: Aspect-Oriented Programming) 지원:
    
    트랜잭션이나 로깅, 보안과 같이 여러 모듈에서 공통적으로 사용하는 기능은 해당 기능을 분리해서 관리
    
- 영속성과 관련된 다양한 서비스 지원:
    
    하이버네이트 등 완성도가 높은 데이터베이스 처리 라이브러리와 연결할 수 있는 인터페이스 지원
    
- 확장성이 높음

### 사용되는 주요 모듈

- 제어 반전 컨테이너
- 관점 지향 프로그래밍 프레임워크
- 데이터 액세스 프레임워크
- 트랜잭션 관리 프레임워크
- MVC 패턴
- 배치 프레임워크

## 인터페이스와 객체 조립

---

### 인터페이스(Interface)

- 개발 코드와 객체가 서로 통신하는 접점

    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/626b71b8-efcd-4215-a709-95624cbec419/Untitled.png)
   
- 역할
    - 개발 코드가 객체에 종속되지 않도록 해 객체를 교체할 수 있도록 함
    - 개발 코드의 변경 없이 반환값 또는 실행 내용이 다양해질 수 있음(다형성)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bf26a58c-0b4b-4d6b-ac8c-f0ae4a17fed6/Untitled.png)
    

### 인터페이스 선언

```java
interface anInterface {
	//public static final 속성의 상수로 컴파일시 값 생성
	int ATTR = 123; 
	
	//abstract 메서드
	int job1(); 
	
	//인터페이스 구현 클래스에서 따로 구현하지 않아도 기본으로 구현
	//오버라이딩해서 재정의 가능
	default void predefinedJob() {
		System.out.println("predefined job");
	}

	//정적 메서드
	//오버라이딩 불가
	static void printInterfaceName() {
		System.out.println("this is anInterface");
	}
}
```

### 구현 객체와 구현 클래스

- **구현 객체**:
    
    인터페이스의 추상 메서드에 대한 실체 메서드를 가진 객체
    
- **구현 클래스**:
    
    구현 객체를 생성하는 클래스
    
    ```java
    public class 구현클래스명 implements 인터페이스명 {
    	//인터페이스에서 선성낳 추상 메서드의 실체 메서드 정의
    }
    ```
    

### 인터페이스 사용

- 디폴트 메서드 → 구현 객체를 통해 사용해야 함
- 정적 메서드 → 인터페이스로 바로 호출 가능

### 인터페이스 측면에서 타입 변환과 다형성

- 다형성 구현 기술
    - 상속 또는 인터페이스의 자동 타입 변환
    - 오버라이딩(디폴트 메서드의 경우)
- 효과
    - 다양한 실행 결과
    - 객체를 부품화 → 유지보수 용이

```java
public class MainClass {
	public static void main(String args[]) {
		X objectX;
		X1 a1 = new X1();
		X2 a2 = new X2();
		
		objectX = a1;
		System.out.println(objectX.job1());
		
		objectX = a2;
		System.out.println(objectX.job1());
```

### 인터페이스 상수와 정적 메서드 사용

- 인터페이스 상수: `public static final` 속성의 상수로 컴파일시 값 생성
- 인터페이스 정적 메서드
    - 인터페이스를 구현하는 모든 구현 클래스에 적용
    - 오버라이딩 불가
- 사용법
    - 인터페이스명.상수명
    - 인터페이스명.메서드명

## 스프링 프레임워크의 주요 특성

---

### 객체 간의 의존성

- 강한 의존성
    
    ```java
    public class A {
    	private B b;
    	//A가 B에 의존하게 됨
    
    	public A() {
    		b = new B():
    	}
    }
    ```
    
- 약한 의존성
    
    ```java
    public class A {
    	private B b; //A가 B에 의존하게 됨
    	
    	//A를 초기화할 때 B의 인스턴스를 매개변수로 주입
    	public A(B b) {
    		this.b = b;
    	}
    	//setter를 통해 B의 인스턴스 주입
    	public void setB(B b) {
    		this.b = b;
    	}
    }
    ```
    

## 의존성 주입(Dependency Injection)

> 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉
> 
> 
> ex) 객체 A가 B 객체를 필요로 한다면 → A는 B에 의존한다
> 
- 객체의 생성과 사용의 관심을 분리 → 가독성과 코드 재사용성을 높임
    - A 객체가 B 객체를 직접 생성해 사용하면? B의 내용 변경시 A의 코드도 변경해야 함
    - 외부에서 생성된 B를 A에 제공(대입)하는 것을 ‘**B를 A에 주입한다**’

### 의존성 주입 방법

1. **생성자 사용방식**
    
    ```java
    public class A {
    	private B b;
    	
    	//A를 초기화할 때 B의 인스턴스를 매개변수로 주입
    	public A(B b) {
    		this.b = b;
    	}
    }
    ```
    
2. **setter 사용방식**
    
    ```java
    public class A {
    	private B b;
    	
    	//A를 초기화할 때 setter를 통해 B의 인스턴스 주입
    	public void setB(B b) {
    		this.b = b;
    	}
    }
    ```
    

## 제어 반전(IoC: Inversion of Control)

---

> 프로그래머가 작성한 프로그램이 재사용 라이브러리의 흐름 제어를 받게되는 소프트웨어 디자인 패턴
> 
- 제어 반전이 적용된 구조: 외부 라이브러리의 코드가 프로그래머가 작성한 코드를 호출함
- 제어 반전의 목적
    - 작업 구현 방식과 작업 수행 자체를 분리
    - 모듈을 제작할 때 모듈과 외부 프로그램의 결합에 대해 고민할 필요 없이 모듈의 목적에 집중 가능
    - 다른 시스템의 동작에 대해 고민할 필요 없이 미리 정해진 협약대로만 동작하게 하면 됨

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/646211c8-5455-4b7e-b6ad-e5e897b7f56f/Untitled.png)

## 관점 지향 프로그래밍(AOP: Aspect Objective Programming)

---

> **횡단 관심사**(다른 관심사에 영향을 끼치는 관심사 ex. 로깅, 트랜잭션, 보안)**의 분리를 허용** → 모듈성을 증가시키는 것이 목적인 프로그래밍 패턴
> 
> - 코드 자체를 수정 X, 대신 기존의 코드에 추가 동작을 추가
> - 비즈니스 로직에 핵심적이지 않은 동작을 프로그램에 추가
- 소스 코드 레벨에서 관심사들의 모듈화를 지원하는 프로그래밍 메서드들과 도구들을 포함
- 프로그램 로직을 명확한 부분(관심사)들로 나누는 것을 수반함
1. 횡단 관심사를 분리하지 않은 경우
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ad20d4a5-6e12-4463-819d-0f338904d97a/Untitled.png)
    
    - 프로그래머가 구현한 모듈 안에 보안, 로깅, 트랜잭션 루틴이 엉킴
2. 횡단 관심사를 분리한 경우
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a92eb04e-cd87-464f-ae48-59b7b919c1fc/Untitled.png)
    
    - 프로그래머가 구현한 내용 → 추상화된 모듈에 주입
    - 횡단 관심사 → 독립된 모듈리 분리됨
    
    ## 스프링 프레임워크의 역할
    
    ---
    
    - 의존성 관계만 설정해주면 자동으로 의존성 주입 작업을 진행
    - 제어 반전 컨테이너를 제공하고 이에 대한 지시서를 작성하면 알아서 조립해줌
