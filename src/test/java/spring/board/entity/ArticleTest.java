package spring.board.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

    User user;
    String content;
    String title;



    @BeforeEach
    void beforeEach() {
        user = user.builder()
                .name("test")
                .email("test@test.com")
                .password("test")
                .build();

        content = "content";
        title = "title";
    }
//
//    @Test
//    void 게시판생성성공테스트() {
//        Article article = Article.builder()
//                .content(content)
//                .title(title)
//                .user(user)
//                .build();
//
//        assertThat(article.getContent()).isEqualTo(content);
//        assertThat(article.getTitle()).isEqualTo(title);
//        assertThat(article.getUser()).isEqualTo(user);
//    }
//    @Test
//    void 게시판제목없은실패테스트() {
//        title = "";
//
//        assertThrows(IllegalArgumentException.class, () ->
//        {
//            Article article = Article.builder()
//                    .content(content)
//                    .title(title)
//                    .user(user)
//                    .build();
//        });
//        assertThrows(IllegalArgumentException.class, () ->
//        {
//            Article article = Article.builder()
//                    .content(content)
//                    .title(null)
//                    .user(user)
//                    .build();
//        });
//    }
//    @Test
//    void 게시판내용없음실패테스트() {
//        content = "";
//
//        assertThrows(IllegalArgumentException.class, () ->
//        {
//            Article article = Article.builder()
//                    .content(content)
//                    .title(title)
//                    .user(user)
//                    .build();
//        });
//        assertThrows(IllegalArgumentException.class, () ->
//        {
//            Article article = Article.builder()
//                    .content(null)
//                    .title(title)
//                    .user(user)
//                    .build();
//        });
//    }
//
//    @Test
//    void 게시판유저없음실패테스트() {
//        content = "";
//
//        assertThrows(IllegalArgumentException.class, () ->
//        {
//            Article article = Article.builder()
//                    .content(content)
//                    .title(title)
//                    .user(user)
//                    .build();
//        });
//        assertThrows(IllegalArgumentException.class, () ->
//        {
//            Article article = Article.builder()
//                    .content(content)
//                    .title(title)
//                    .user(null)
//                    .build();
//        });
//    }

}
