package spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.board.entity.Article;

public interface BoardRepository extends JpaRepository<Article, Long> {
}
