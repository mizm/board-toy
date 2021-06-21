package spring.board.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.Article;
import spring.board.entity.User;
import spring.board.repository.UserRepository;
import spring.board.service.exceptions.ResourceNotFoundException;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ArticleServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager em;

    Article article1;
    Article article2;

//    @BeforeEach
//    void beforeEach() {
//        User user = new User("test","pass","email");
//        userRepository.save(user);
//        article1 = Article.builder()
//                .title("test")
//                .content("test")
//                .user(user)
//                .build();
//        article2 = Article.builder()
//                .title("test2")
//                .content("test2")
//                .user(user)
//                .build();
//    }
//
//    @Test
//    @DisplayName("게시글 생성 성공 테스트")
//    void save() {
//        Article saveArticle = boardService.add(article1);
//
//        checkBoard(saveArticle, article1);
//    }
//
//    @Test
//    @DisplayName("게시글 단일 조회 테스트")
//    void find() {
//        Article saveArticle = boardService.add(article1);
//        em.flush();
//        em.clear();
//
//        Long boardId = saveArticle.getId();
//        Article findArticle = boardService.findOne(boardId);
//
//        checkBoard(findArticle, saveArticle);
//    }
//
//    @Test
//    @DisplayName("유저 단일 조회 실패 테스트")
//    void findFail() {
//        Long boardId = 3L;
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            boardService.findOne(boardId);
//        });
//    }
//
//    @Test
//    @DisplayName("게시글 전체 조회")
//    void findAll() {
//        boardService.add(article1);
//        boardService.add(article2);
//
//        List<Article> articles = boardService.findAll();
//
//        assertThat(articles).contains(article1, article2);
//    }
//
//
//    private void checkBoard(Article article1, Article article2) {
//        assertThat(article1.getTitle()).isEqualTo(article2.getTitle());
//        assertThat(article1.getContent()).isEqualTo(article2.getContent());
//
//        // 영속성 컨텍스트에서는 동일성이 보장된다.
//        assertThat(article1.getModifiedDate()).isEqualTo(article2.getModifiedDate());
//        assertThat(article1.getCreatedDate()).isEqualTo(article2.getCreatedDate());
//        assertThat(article1.getUpdatedBy()).isEqualTo(article2.getUpdatedBy());
//        assertThat(article1.getCreatedBy()).isEqualTo(article2.getCreatedBy());
//    }
}