package spring.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.Article;
import spring.board.repository.BoardRepository;
import spring.board.service.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Article add(Article article) {
        return boardRepository.save(article);
    }

    public Article findOne(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new ResourceNotFoundException("board not found"));
    }

    public List<Article> findAll() {
        return boardRepository.findAll();
    }
}
