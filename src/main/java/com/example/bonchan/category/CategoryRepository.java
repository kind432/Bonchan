package com.example.bonchan.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
