package com.example.bonchan.comment.models;

public class CommentsResponse {
    private Iterable<Comment> comments;

    public CommentsResponse(Iterable<Comment> comments) {
        this.comments = comments;
    }

    public Iterable<Comment> getComments() {
        return comments;
    }

    public void setComments(Iterable<Comment> comments) {
        this.comments = comments;
    }
}
