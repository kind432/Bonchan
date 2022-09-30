package com.example.bonchan.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "comments")
public class CommentController {
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/{topicId}")
    public Iterable<Comment> getCommentsByTopicId(@PathVariable Long topicId) {
        return commentService.getCommentsByTopicId(topicId);
    }

    @PostMapping(path = "/create")
    public Comment createComment(@RequestBody Comment request) {
        return commentService.createComment(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @PutMapping(path = "/update")
    public Comment updateComment(@RequestBody Comment request) {
        return commentService.updateComment(request);
    }
}
