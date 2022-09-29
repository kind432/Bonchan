package com.example.bonchan.comment;

import com.example.bonchan.comment.models.Comment;
import com.example.bonchan.comment.models.CommentsResponse;
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

    @GetMapping(path = "/{themeId}")
    public CommentsResponse getCommentsByThemeId(@PathVariable Long themeId) {
        return new CommentsResponse(commentService.getCommentsByThemeId(themeId));
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
