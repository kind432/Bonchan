package com.example.bonchan.forum;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ForumRepository extends CrudRepository<Forum, Long> {
    Iterable<Forum> findBySubcategoryId(Long subcategoryId);
}
