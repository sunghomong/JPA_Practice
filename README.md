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

## JPA 구동 방식

1. persistence.xml 설정 정보 조회
2. persistence -> 생성 -> EntityManagerFactory
3. EntityManagerFactory -> 생성 -> EntityManager,EntityManager,EntityManager

## 실습 - JPA 동작 확인

- jpaMain 클래스 생성
- JPA 동작 확인

## 객체와 테이블 생성 후 매핑

- @Entity : JPA가 관리할 객체
- @id = 데이터베이스 PK와 매핑
- @Table(name = "테이블 이름")
- @Column(name = "컬럼 이름")

```SQL
CREATE TABLE MEMBER (
    id bigint not null,
    name varchar(255),
    primary key (id)
);
```

## 실습 - 회원 저장

- 회원 등록
- 회원 수정
- 회원 삭제
- 회원 단 건 조회

## 주의

- 엔티티 메니저 펙토리는 하나만 생성해서 애플리케이션 전체에서 공유
- 엔티티 메니저는 쓰레드간에 공유X (사용하고 버려야 한다).
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행

## JPQL 소개

- 가장 단순한 조회 방법
  - EntityManager.find()
  - 객체 그래프 탐색(a.getB().getC())
- 나이가 18살 이상인 회원을 모두 검색하고 싶다면?

## 실습 - JPQL 소개

- JPQL로 전체 회원 검색
- JPQL로 ID가 2 이상인 회원만 검색
- JPQL로 이름이 같은 회원만 검색
- JPQL에 대해 자세한 내용은 객체지향 쿼리에서 학습

## JPQL

- .setFirstResult(1) = 조회 값 1번부터
- .setMaxResults(4) = 조회 값 4번까지
- .getResultList(); = 결과 값 가져와
- JPA를 사용하면 엔티티 객체를 중심으로 개발
- 문제는 검색 쿼리
- 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색
- 모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능
- 애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요
- JPA는 SQL을 추상화한 JPQL 이라는 객체 지향 쿼리 언어 제공
- SQL과 문법 유사, SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원
- JPQL은 엔티티 객체를 대상으로 쿼리
- SQL은 데이터베이스 테이블을 대상으로 쿼리
- 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
- SQL을 추상화해서 특정 데이터베이스 SQL에 의존X
- JPQL을 한마디로 정의하면 객체 지향 SQL