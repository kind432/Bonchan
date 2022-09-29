package com.example.bonchan.comment;

import com.example.bonchan.comment.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findByThemeId(Long themeId);
}
