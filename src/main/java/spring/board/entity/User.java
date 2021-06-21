package spring.board.entity;

import com.mysema.commons.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotNull
    private String name;

    @Column(length = 1024)
    private String bio;

    @Column(length = 1024)
    private String image;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @Builder
    private User(String name, String bio, String image, String email, String password) {
        Assert.hasText(name, "name is provided");
        Assert.hasText(email, "email is provided");
        Assert.hasText(password, "password is provided");

        this.name = name;
        this.bio = bio;
        this.image = image;
        this.email = email;
        this.password = password;
    }


}
