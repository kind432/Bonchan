package com.example.bonchan.subcategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {
    Iterable<Subcategory> findByCategoryId(Long categoryId);
}
