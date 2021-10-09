# QueryDSL demo

> Spring Data JPA를 활용하던 중에 다음과 같은 메소드 인터페이스를 작성한다고 생각해보자.<br>findByFirstNameIngoreCaseAndLastNameStartsWithIgnoreCase(String firstName, String lastName)
> <br>위의 길이 정도만 되더라도, 한글로 주석을 달아 두는 게 낫겠다는 생각이 들 정도이다.
> <br> target\generated-sources\ 하위에 생성되는 코드를 활용하여 복잡한 쿼리를 Type-Safe하게 작성할 수 있다.

여러 쿼리 메소드는 대부분 두 가지 중 하나이다.

- Optional<T> findOne(**Predicate**): **이런 저런 조건**으로 무언가 하나를 찾는다.
- List<T>|Page<T>|.. findAll(**Predicate**): **이런 저런 조건**으로 무언가 여러개를 찾는다.

QueryDSL

- http://www.querydsl.com/
- 타입 세이프한 쿼리 만들 수 있게 도와주는 라이브러리
  - findByFirstNameIngoreCaseAndLastNameStartsWithIgnoreCase 이런 방식으로 입력하다 보면 오탈자가 발생할 수 있다.
- JPA, SQL, MongoDB, JDO, Lucene, Collection 지원
- [QueryDSL JPA 연동 가이드](http://www.querydsl.com/static/querydsl/4.1.3/reference/html_single/#jpa_integration)

스프링 데이터 JPA + QueryDSL

- 인터페이스: QuerydslPredicateExecutor<T>
- 구현체: QuerydslPredicateExecutor<T>

연동 방법

- 기본 리포지토리 커스터마이징 안 했을 때.
- 기본 리포지토리 커스타마이징 했을 때.

의존성 추가

```xml
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-apt</artifactId>
</dependency>
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-jpa</artifactId>
</dependency>
```

...

```xml
<plugin>
    <groupId>com.mysema.maven</groupId>
    <artifactId>apt-maven-plugin</artifactId>
    <version>1.1.3</version>
    <executions>
        <execution>
            <goals>
                <goal>process</goal>
            </goals>
            <configuration>
                <outputDirectory>target/generated-sources/java</outputDirectory>
                <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
            </configuration>
        </execution>
    </executions>
</plugin>
```

인터페이스 생성 예시

```javascript
public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account> {
}
```

