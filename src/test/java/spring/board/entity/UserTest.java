package spring.board.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

//    @Test
//    void 유저빌더성공테스트() {
//
//        String name = "test";
//        String email = "test@mail.com";
//        String password = "test";
//        User user = User.builder()
//                .username(name)
//                .email(email)
//                .password(password)
//                .build();
//
//        assertThat(user.getEmail()).isEqualTo(email);
//        assertThat(user.getUsername()).isEqualTo(name);
//        assertThat(user.getPassword()).isEqualTo(password);
//
//    }
    @Test
    void 유저빌더_이름없음실패테스트() {

        String name = "";
        String email = "test@mail.com";
        String password = "test";
        assertThrows(IllegalArgumentException.class, () -> {
            User user = User.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .build();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            User user = User.builder()
                    .name(null)
                    .email(email)
                    .password(password)
                    .build();
        });
    }
//
//    @Test
//    void 유저빌더_메일없음실패테스트() {
//
//        String name = "test";
//        String email = "";
//        String password = "test";
//        assertThrows(IllegalArgumentException.class, () -> {
//            User user = User.builder()
//                    .username(name)
//                    .email(email)
//                    .password(password)
//                    .build();
//        });
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            User user = User.builder()
//                    .username(name)
//                    .email(null)
//                    .password(password)
//                    .build();
//        });
//    }
//
//    @Test
//    void 유저빌더_비밀번호없음실패테스트() {
//
//        String name = "test";
//        String email = "test@test.com";
//        String password = "";
//        assertThrows(IllegalArgumentException.class, () -> {
//            User user = User.builder()
//                    .username(name)
//                    .email(email)
//                    .password(password)
//                    .build();
//        });
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            User user = User.builder()
//                    .username(name)
//                    .email(email)
//                    .password(null)
//                    .build();
//        });
//    }
}