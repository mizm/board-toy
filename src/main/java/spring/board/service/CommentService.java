package spring.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.Comment;
import spring.board.repository.CommentRepository;
import spring.board.service.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findOne(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment Not found"));
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
