# JPA 공부를 기록하기 위한 레포입니다.

## H2 데이터베이스 테스트

- https://www.h2database.com/html/main.html
- 최고의 실습용 DB
- 가벼움
- 웹용 쿼리 제공
- MySQL, Oracle 데이터베이스 시물레이션 가능
- 시퀀스, AUTO INCREMENT 기능 지원

H2 다운 -> 명령프롬프트 -> cd 로 해당 파일 h2/bin으로 들어가 h2.bat 실행 -> 서버 연결 완료
서버 연결 안될시 URI 127.0.0.1:8082로도 연결 가능

## 메이븐

- 자바 라이브러리, 빌드 관리
- 라이브러리 자동 다운로드 및 의존성 관리

## 프로젝트 생성

- 자바 17
- 메이븐 설정
  - groupId: jpa-basic
  - artifactId: ex1-hello-jpa
  - version: 1.0.0

## pom.xml

JPA 하이버네이트 - 5.3.10.Final ver

h2 데이터 베이스 - 2.2.224 ver

## JPA 설정 - persistence.xml

- JPA 설정 파일
- /META-INF/persistence.xml 위치
- persistence-unit name으로 이름 지정
- javax.persistence로 시작 : JPA 표준 속성
- hibernate로 시작 : 하이버네이트 전용 속성

resources 폴더 안에 META-INF 디렉토리 생성 -> persistence.xml 생성 및 설정

## 데이터베이스 방언

- JPA는 특정 데이터베이스에 종속 X
- 각각의 데이터베이스가 제공하는 SQL 문법과 함수는 조금씩 다름
  - 가변 문자: MySQL은 VARCHAR, Oracle은 VARCHAR2
  - 문자열을 자르는 함수 : SQL 표준은 SUBSTRING(), Oracle은 SUBSTR()
  - 페이징 : MySQL은 LIMIT, Oracle은 ROWNUM
- 방언: SQL 표준을 지키지 않는 특정 데이터베이스만의 고유한 기능
- hibernate.dialect 속성에 지정
  - H2 : org.hibernate.dialect.H2Dialect
  - Oracle 10g : org.hibernate.dialect.Oracle10gDialect
  - MySQL : org.hibernate.dialect.MySQL5lnnoDBDialect
- 하이버네이트는 40가지 이상의 데이터베이스 방언 지원

