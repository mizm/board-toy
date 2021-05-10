package spring.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50)
    private String username;

    private String password;

    private String email;

    @Builder
    public User(String username, String password, String email) {
        Assert.hasText(username, "username is Not null");
        Assert.hasText(password, "password is Not null");
        Assert.hasText(email, "email is Not null");

        this.username = username;
        this.password = password;
        this.email = email;
    }
}
