package spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.board.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
