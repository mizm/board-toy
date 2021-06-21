package spring.board.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import spring.board.entity.Article;
import spring.board.entity.User;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

/*
@DataJpaTest 어노테이션은 JPA 관련 테스트 설정만 로드합니다. DataSource의 설정이 정상적인지, JPA를 사용하여 데이터를 제대로 생성, 수정, 삭제하는지 등의 테스트가 가능합니다.
그리고 가장 좋은점은.. 무려 내장형 데이터베이스를 사용하여 실제 데이터베이스를 사용하지 않고 테스트 데이터베이스로 테스트할 수 있는.. 개꿀같은 장점이 있습니다.

@DataJpaTest는 기본적으로 @Entity 어노테이션이 적용된 클래스를 스캔하여 스프링 데이터 JPA 저장소를 구성합니다.
만약 최적하한 별도의 데이터소스를 사용하여 테스트하고 싶다면 기본 설정된 데이터소스를 사용하지 않도록 아래와 같이 설정해도 됩니다.
 */
@DataJpaTest
class ArticleRepositoryTest {
    User user;
    String content;
    String title;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    void beforeEach() {
        user = user.builder()
                .username("test")
                .email("test@test.com")
                .password("test")
                .build();

        content = "content";
        title = "title";
    }
    @Test
    void 제목최대길이실패테스트(){
        title = "testtesttesttesttesttesttesttesttesttesttesttesttesttesttest";

        /*
        DataAccessException의 서브클래스인 세분화 된 예외 클래스를 정의
        BadSqlGrammarException : SQL 문법 오류
        DataAccessResourceFailureException : DB 커넥션을 가져오지 못함
        DataIntegrityViolationException : 제약조건 위반
        DuplicateKeyException : 중복 키
         */
        Article article = Article.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
        assertThrows(DataIntegrityViolationException.class, () -> {
            boardRepository.save(article);
        });

    }

    @Test
    void 생성_성공테스트() {
        Article article = Article.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
        boardRepository.save(article);

        //@DataJpaTest에서는 Auditing이 찍히지 않는다.
    }


}