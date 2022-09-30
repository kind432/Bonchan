package com.example.bonchan.comment;

import com.example.bonchan.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, TopicRepository topicRepository) {
        this.commentRepository = commentRepository;
        this.topicRepository = topicRepository;
    }

    public Iterable<Comment> getCommentsByTopicId(Long topicId) {
        return commentRepository.findByTopicId(topicId);
    }

    public Comment createComment(Comment comment) {
        var topic = topicRepository.findById(comment.getTopic().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        commentRepository.deleteById(id);
    }

    public Comment updateComment(Comment comment) {
        var topic = topicRepository.findById(comment.getTopic().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var com = commentRepository.findById(comment.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return commentRepository.save(comment);
    }
}
