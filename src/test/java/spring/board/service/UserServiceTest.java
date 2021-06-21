package spring.board.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.User;
import spring.board.service.exceptions.ResourceNotFoundException;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    EntityManager em;

    User user;
    User user2;

    @BeforeEach
    void beforeEach() {
        user = User.builder()
                .name("test")
                .email("test@test.com")
                .password("holiy")
                .build();
        user2 = User.builder()
                .name("test2")
                .email("test2@test.com")
                .password("holiy")
                .build();
    }

    @Test
    @DisplayName("유저 생성 성공 테스트")
    void save() {
        User saveUser = userService.join(user);

        checkUser(saveUser,user);
    }

    @Test
    @DisplayName("유저 단일 조회 테스트")
    void find() {
        User saveUser = userService.join(user);
        em.flush();
        em.clear();

        Long userId = saveUser.getId();
        User findUser = userService.findOne(userId);

       checkUser(findUser, saveUser);
    }

    @Test
    @DisplayName("유저 단일 조회 실패 테스트")
    void findFail() {
        Long userId = 3L;

        assertThrows(ResourceNotFoundException.class, () -> {
            userService.findOne(userId);
        });
    }

    @Test
    @DisplayName("유저 전체 조회")
    void findAll() {
        userService.join(user);
        userService.join(user2);

        List<User> users = userService.findAll();

        assertThat(users).contains(user,user2);
    }

    private void checkUser(User user1, User user2) {
        assertThat(user1.getName()).isEqualTo(user2.getName());
        assertThat(user1.getEmail()).isEqualTo(user2.getEmail());
        assertThat(user1.getPassword()).isEqualTo(user2.getPassword());
    }


}