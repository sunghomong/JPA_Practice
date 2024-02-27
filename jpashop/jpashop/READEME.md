## GETTER SETTER

실무에서는 GETTER만 사용하는게 좋다.

## MANY TO MANY

MANY TO MANY는 실무에서 사용 X
- 운영하기도 어려움

## 엔티티 설계 주의점

- setter를 사용하지 말자(유지보수 어려워짐)
- 모든 연관관계는 지연로딩으로 설정(LAZY)
  - 즉시 로딩은 예측이 어려움
  - 실무에서 모든 연관관계는 LAZY로 설정
  - JPQL을 실행할때 N + 1 문제 자주 발생
  - fetch join 을 사용한다.
  - ManyToOne은 디폴트 값이 EAGER(즉시 실행) ,OneToMany는 디폴트가 LAZY

### 컬렉션은 필드에서 초기화 하자.

- null 문제에서 안전

### Table

- table의 명을 지정 안할시 default 값이 카멜 케이스에 따라 xx_id 이렇게 작성됨

## 회원 도메인 개발

- 회원 등록
- 회원 목록 조회

### 회원 레포 개발