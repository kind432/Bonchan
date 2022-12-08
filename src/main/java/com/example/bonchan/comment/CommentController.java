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
    public Iterable<Comment> GetCommentsByTopicId(@PathVariable Long topicId) {
        return commentService.getCommentsByTopicId(topicId);
    }

    @PostMapping(path = "/create")
    public Comment CreateComment(@RequestBody Comment request) {
        return commentService.createComment(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void DeleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @PutMapping(path = "/update")
    public Comment UpdateComment(@RequestBody Comment request) {
        return commentService.updateComment(request);
    }
}
