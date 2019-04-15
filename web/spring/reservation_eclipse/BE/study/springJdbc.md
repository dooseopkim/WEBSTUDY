## Spring JDBC

- JDBC 프로그래밍을 보면 반복되는 개발 요소가 있습니다.
- 이러한 반복적인 요소는 개발자를 지루하게 만듭니다.
- 개발하기 지루한 JDBC의 모든 저수준 세부사항을 스프링 프레임워크가 처리해줍니다.
- 개발자는 필요한 부분만 개발하면 됩니다.

#### 개발자
- 연결 파라미터 정의
- SQL문 작성
- 파라미터 선언 , 값 제공
- 이터레이션 작업 수행

#### 스프링
- 연결 오픈
- 스테이트먼트 준비 , 실행
- 결과 반복하는 루프 설정
- 예외 처리 (Good)
- 트랜잭션 제어 (Good)
- 자원 반납(Good)!

### Spring JDBC 패키지

- org.springframework.jdbc.core
JdbcTemplate 및 관련 Helper 객체 제공

- org.springframework.jdbc.datasource
DataSource를 쉽게 접근하기 위한 유틸 클래스, 트랜젝션매니져 및 다양한 DataSource 구현을 제공

- org.springframework.jdbc.object
RDBMS 조회, 갱신, 저장등을 안전하고 재사용 가능한 객제 제공

- org.springframework.jdbc.support
jdbc.core 및 jdbc.object를 사용하는 JDBC 프레임워크를 지원

### JDBC Template
- org.springframework.jdbc.core에서 가장 중요한 클래스입니다.
**리소스 생성, 해지를 처리**해서 연결을 닫는 것을 잊어 발생하는 문제 등을 피할 수 있도록 합니다.
- 스테이먼트(Statement)의 생성과 실행을 처리합니다.
- SQL 조회, 업데이트, 저장 프로시저 호출, ResultSet 반복호출 등을 실행합니다.
- **JDBC 예외가 발생할 경우 org.springframework.dao패키지에 정의되어 있는 일반적인 예외로 변환**시킵니다.

이터레이션과같은 순환, 자원 반납 관련 작업은 JdbcTemplate에서 처리해줍니다.
따라서 프로그래머는 DB에서 조회할 Row의 형태에 대한 정의만 프로그래밍하면 됩니다.(RowMapper)

```java
List<Actor> actors = this.jdbcTemplate.query(

  "select first_name, last_name from t_actor",

  new RowMapper<Actor>() {

    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

      Actor actor = new Actor();

      actor.setFirstName(rs.getString("first_name"));

      actor.setLastName(rs.getString("last_name"));

      return actor;

    }

  });
```
### JdbcTemplate외의 접근방법

- NamedParameterJdbcTemplate
JdbcTemplate에서 JDBC statement 인자를 ?를 사용하는 대신 파라미터명을 사용하여 작성하는 것을 지원


### DAO란? (@Repository)

DAO란 Data Access Object의 약자로 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체입니다.
보통 데이터베이스를 조작하는 기능을 전담하는 목적으로 만들어집니다.


### ConnectionPool 이란?

DB연결은 비용이 많이 듭니다.
커넥션 풀은 미리 커넥션을 여러 개 맺어 둡니다.
커넥션이 필요하면 커넥션 풀에게 빌려서 사용한 후 반납합니다.
커넥션을 반납하지 않으면 어떻게 될까요?

### DataSource란?

**DataSource는 커넥션 풀을 관리하는 목적**으로 사용되는 객체입니다.
DataSource를 이용해 커넥션을 얻어오고 반납하는 등의 작업을 수행합니다.
 