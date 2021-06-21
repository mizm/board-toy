package spring.board.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.Article;
import spring.board.entity.Comment;
import spring.board.entity.User;
import spring.board.repository.BoardRepository;
import spring.board.repository.UserRepository;
import spring.board.service.exceptions.ResourceNotFoundException;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    EntityManager em;

    Comment comment1;
    Comment comment2;

    @BeforeEach
    void beforeEach() {
        User user = new User("test","pass","email");
        userRepository.save(user);
        Article article = Article.builder()
                .title("test")
                .content("test")
                .user(user)
                .build();
        boardRepository.save(article);

        comment1 = Comment.builder()
                .user(user)
                .board(article)
                .content("test1")
                .build();
        comment2 = Comment.builder()
                .user(user)
                .board(article)
                .content("test2")
                .build();
    }

    @Test
    @DisplayName("댓글 생성 성공 테스트")
    void save() {
        Comment saveComment = commentService.add(comment1);

        checkBoard(saveComment,comment1);
    }

    @Test
    @DisplayName("댓글 단일 조회 테스트")
    void find() {
        Comment saveComment = commentService.add(comment1);
        em.flush();
        em.clear();

        Long commentId = saveComment.getId();
        Comment findComment = commentService.findOne(commentId);

        checkBoard(findComment, saveComment);
    }

    @Test
    @DisplayName("댓글 단일 조회 실패 테스트")
    void findFail() {
        Long commendId = 3L;

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.findOne(commendId);
        });
    }

    @Test
    @DisplayName("댓글 전체 조회")
    void findAll() {
        commentService.add(comment1);
        commentService.add(comment2);

        List<Comment> comments = commentService.findAll();

        assertThat(comments).contains(comment1,comment2);
    }


    private void checkBoard(Comment comment1, Comment comment2) {
        assertThat(comment1.getContent()).isEqualTo(comment2.getContent());

        // 영속성 컨텍스트에서는 동일성이 보장된다.
        assertThat(comment1.getModifiedDate()).isEqualTo(comment2.getModifiedDate());
        assertThat(comment1.getCreatedDate()).isEqualTo(comment2.getCreatedDate());
        assertThat(comment1.getUpdatedBy()).isEqualTo(comment2.getUpdatedBy());
        assertThat(comment1.getCreatedBy()).isEqualTo(comment2.getCreatedBy());
    }
}