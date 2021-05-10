package spring.board.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.board.repository.BoardRepository;
import spring.board.repository.CommentRepository;
import spring.board.repository.UserRepository;

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

    @Test
    void 유저_Auditing() {
        User user = User.builder()
                .username("test")
                .email("test@email.com")
                .password("test")
                .build();
        
        User saveUser = userRepository.save(user);
        
        assertThat(saveUser.getCreatedDate()).isNotNull();
        assertThat(saveUser.getModifiedDate()).isNotNull();
    }
    @Test
    void 게시판_Auditing() {
        User user = User.builder()
                .username("test")
                .email("test@email.com")
                .password("test")
                .build();

        Board board = Board.builder()
                .content("test")
                .title("title")
                .user(user)
                .build();
        User saveUser = userRepository.save(user);
        Board saveBoard = boardRepository.save(board);
        assertThat(saveBoard.getCreatedDate()).isNotNull();
        assertThat(saveBoard.getModifiedDate()).isNotNull();
        assertThat(saveBoard.getCreatedBy()).isNotNull();
        assertThat(saveBoard.getUpdatedBy()).isNotNull();

    }

    @Test
    void comment_Auditing() {
        User user = User.builder()
                .username("test")
                .email("test@email.com")
                .password("test")
                .build();

        Board board = Board.builder()
                .content("test")
                .title("title")
                .user(user)
                .build();

        Comment comment = Comment.builder()
                .board(board)
                .user(user)
                .content("test")
                .build();
        User saveUser = userRepository.save(user);
        Board saveBoard = boardRepository.save(board);
        Comment saveComment = commentRepository.save(comment);
        assertThat(saveComment.getCreatedDate()).isNotNull();
        assertThat(saveComment.getModifiedDate()).isNotNull();
        assertThat(saveComment.getCreatedBy()).isNotNull();
        assertThat(saveComment.getUpdatedBy()).isNotNull();

    }
}
