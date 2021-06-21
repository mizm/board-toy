package spring.board.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.board.repository.BoardRepository;
import spring.board.repository.CommentRepository;
import spring.board.repository.UserRepository;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class AuditingTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    EntityManager em;

//    @Test
//    void 유저_Auditing() {
//        User user = User.builder()
//                .username("test")
//                .email("test@email.com")
//                .password("test")
//                .build();
//
//        User saveUser = userRepository.save(user);
//
//        assertThat(saveUser.getCreatedDate()).isNotNull();
//        assertThat(saveUser.getModifiedDate()).isNotNull();
//    }
//    @Test
//    void 게시판_Auditing() {
//        User user = User.builder()
//                .username("test")
//                .email("test@email.com")
//                .password("test")
//                .build();
//
//        Article article = Article.builder()
//                .content("test")
//                .title("title")
//                .user(user)
//                .build();
//        User saveUser = userRepository.save(user);
//        Article saveArticle = boardRepository.save(article);
//        assertThat(saveArticle.getCreatedDate()).isNotNull();
//        assertThat(saveArticle.getModifiedDate()).isNotNull();
//        assertThat(saveArticle.getCreatedBy()).isNotNull();
//        assertThat(saveArticle.getUpdatedBy()).isNotNull();
//
//    }
//
//    @Test
//    void comment_Auditing() {
//        User user = User.builder()
//                .username("test")
//                .email("test@email.com")
//                .password("test")
//                .build();
//
//        Article article = Article.builder()
//                .content("test")
//                .title("title")
//                .user(user)
//                .build();
//
//        Comment comment = Comment.builder()
//                .board(article)
//                .user(user)
//                .content("test")
//                .build();
//        User saveUser = userRepository.save(user);
//        Article saveArticle = boardRepository.save(article);
//        Comment saveComment = commentRepository.save(comment);
//        assertThat(saveComment.getCreatedDate()).isNotNull();
//        assertThat(saveComment.getModifiedDate()).isNotNull();
//        assertThat(saveComment.getCreatedBy()).isNotNull();
//        assertThat(saveComment.getUpdatedBy()).isNotNull();
//
//    }
}
