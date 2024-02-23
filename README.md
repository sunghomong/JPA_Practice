# JPA 공부를 기록하기 위한 레포입니다.

## H2 데이터베이스

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

- 자바 8
- 메이븐 설정
  - groupId: jpa-basic
  - artifactId: ex1-hello-jpa
  - version: 1.0.0
