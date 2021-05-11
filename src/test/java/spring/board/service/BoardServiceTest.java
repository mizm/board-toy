package spring.board.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.Board;
import spring.board.entity.User;
import spring.board.repository.UserRepository;
import spring.board.service.exceptions.ResourceNotFoundException;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager em;

    Board board1;
    Board board2;

    @BeforeEach
    void beforeEach() {
        User user = new User("test","pass","email");
        userRepository.save(user);
        board1 = Board.builder()
                .title("test")
                .content("test")
                .user(user)
                .build();
        board2 = Board.builder()
                .title("test2")
                .content("test2")
                .user(user)
                .build();
    }

    @Test
    @DisplayName("게시글 생성 성공 테스트")
    void save() {
        Board saveBoard = boardService.add(board1);

        checkBoard(saveBoard,board1);
    }

    @Test
    @DisplayName("게시글 단일 조회 테스트")
    void find() {
        Board saveBoard = boardService.add(board1);
        em.flush();
        em.clear();

        Long boardId = saveBoard.getId();
        Board findBoard = boardService.findOne(boardId);

        checkBoard(findBoard, saveBoard);
    }

    @Test
    @DisplayName("유저 단일 조회 실패 테스트")
    void findFail() {
        Long boardId = 3L;

        assertThrows(ResourceNotFoundException.class, () -> {
            boardService.findOne(boardId);
        });
    }

    @Test
    @DisplayName("게시글 전체 조회")
    void findAll() {
        boardService.add(board1);
        boardService.add(board2);

        List<Board> boards = boardService.findAll();

        assertThat(boards).contains(board1,board2);
    }


    private void checkBoard(Board board1, Board board2) {
        assertThat(board1.getTitle()).isEqualTo(board2.getTitle());
        assertThat(board1.getContent()).isEqualTo(board2.getContent());

        // 영속성 컨텍스트에서는 동일성이 보장된다.
        assertThat(board1.getModifiedDate()).isEqualTo(board2.getModifiedDate());
        assertThat(board1.getCreatedDate()).isEqualTo(board2.getCreatedDate());
        assertThat(board1.getUpdatedBy()).isEqualTo(board2.getUpdatedBy());
        assertThat(board1.getCreatedBy()).isEqualTo(board2.getCreatedBy());
    }
}