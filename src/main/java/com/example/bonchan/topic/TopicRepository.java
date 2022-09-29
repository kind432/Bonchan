package com.example.bonchan.topic;

import com.example.bonchan.topic.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    Iterable<Topic> findByCategoryId(Long categoryId);
}
