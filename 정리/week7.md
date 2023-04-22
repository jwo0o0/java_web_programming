# 7주차 - JDBC를 이용한 데이터베이스 연동

## 데이터베이스 프로그래밍

---

- 프로그래밍: 프로그램을 설계하고 소스코드를 작성해 디버깅
- **데이터베이스 프로그래밍**: DBMS에 데이터를 정의하고 저장된 데이터를 읽어와 데이터를 변경하는 프로그램을 작성

### 방법

- SQL 전용 언어 사용
- 일반 프로그래밍 언어에 SQL을 삽입해 사용
- 웹 프로그래밍 언어에 SQL을 삽입해 사용

### DBMS 플랫폼과 데이터베이스 프로그래밍 유형

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d1ebd634-3c14-4101-a4a7-78805e8befc3/Untitled.png)

### MySQL 특징

- 운영체제 기반: 윈도우, 유닉스, 리눅스
- 소용량 데이터베이스를 위한 응용

### 데이터베이스와 자바의 연결 관계

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/079624a2-69c6-4d06-8f70-890bc438dfdc/Untitled.png)

## 환경 구축

---

### MySQL 서버 설정

```sql
mysql -u root -p 
show databases;
create database jdbctest;
use jdbctest;
```

## 데이터베이스 연동 JAVA 프로그래밍

---

### 데이터 베이스 접속 JAVA 클래스

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c58ef87a-965b-4ae0-97c9-a89f8a938925/Untitled.png)

## 테이블을 반환하는 질의문 처리

---

- `**executeQuery()**`
- 표준 SQL 명령 중 결과를 테이블 형태로 반환하는 `SELECT` 문을 처리하는 메서드
- 질의 결과 → `ResultSet` 객체로 반환

### ResultSet 클래스

- `first()`: 맨 처음 튜플의 정보 가져옴
- `next()`: 다음 번 튜플의 정보 가져옴
    
    ⇒ 모두 boolean형 리턴
    
- 튜플에서 속성값 추출
    - 숫자형: getInt(index), getLong(index), getShort(index) ..
    - 소수점 숫자형: getDouble(index), getBigDecimal(index) ..
    - 문자열: getString(index) ..
    - 날짜/시간: getTime(index) ..
    - *index는 1부터 시작! (컬럼 식별 번호임)

### MySQL 데이터형과 JAVA 데이터형 대응

- 모든 데이터형 - `java.lang.String`으로 변환 가능
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/43e95433-bd8c-4e93-8b4d-6a5fc183124a/Untitled.png)
    

```java
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
System.out.println("BOOK ID \tBOOK NAME \tPUBLISHER \t PRICE");

while(rs.next()) {
	System.out.println(rs.getInt(1)) + 
	"\t" + rs.getString(2) + 
	"\t" + rs.getString(3) + 
	"\t" + rs.getInt(4))
}
```

## 반환값이 없는 질의문 처리

---

- `**executeUpdate()**`
- 표준 SQL 명령 중 `INSERT`, `UPDATE`, `DELETE` 문 처리
- 질의 결과: int형으로 반환 (대부분 적용된 행의 개수)

```java
String query = "SELECT * FROM Book";
String query2 = "UPDATE Book SET price=10000 WHERE bookname='야구의 추억'";
...
try {
	Statement stmt = con.createStatement();
	int result = stmt.executeUpdate(query2);
	ResultSet rs = stmt.executeQuery(query);
	System.out.println(">>" + result + " 개의 행에 적용됨");
	
	while(rs.next()) {
	System.out.println(rs.getInt(1)) + 
	"\t" + rs.getString(2) + 
	"\t" + rs.getString(3) + 
	"\t" + rs.getInt(4))
} catch(...) {
	...
}
```