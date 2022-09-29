package com.example.bonchan.comment;

import com.example.bonchan.theme.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ThemeRepository themeRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, ThemeRepository themeRepository) {
        this.commentRepository = commentRepository;
        this.themeRepository = themeRepository;
    }

    public Iterable<Comment> getCommentsByThemeId(Long themeId) {
        return commentRepository.findByThemeId(themeId);
    }

    public Comment createComment(Comment comment) {
        var theme = themeRepository.findById(comment.getTheme().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        commentRepository.deleteById(id);
    }

    public Comment updateComment(Comment comment) {
        var theme = themeRepository.findById(comment.getTheme().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var com = commentRepository.findById(comment.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return commentRepository.save(comment);
    }
}
