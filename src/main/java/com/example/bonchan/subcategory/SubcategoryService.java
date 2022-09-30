package com.example.bonchan.subcategory;

import com.example.bonchan.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    public Iterable<Subcategory> getSubcategoriesByCategoryId(Long categoryId) {
        return subcategoryRepository.findByCategoryId(categoryId);
    }

    public Subcategory createSubcategory(Subcategory subcategory) {
        var category = categoryRepository.findById(subcategory.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory updateSubcategory(Subcategory subcategory) {
        var category = categoryRepository.findById(subcategory.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var subcateg = subcategoryRepository.findById(subcategory.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(Long id) {
        var subcategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        subcategoryRepository.deleteById(id);
    }
}
