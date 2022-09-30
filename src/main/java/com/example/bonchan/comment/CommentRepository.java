package com.example.bonchan.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findByTopicId(Long topicId);
}
