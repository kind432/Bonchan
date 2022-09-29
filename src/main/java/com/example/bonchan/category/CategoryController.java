package com.example.bonchan.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="categories")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(path ="/")
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path ="/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping(path = "/create")
    public Category createCategory(@RequestBody Category request) {
        return categoryService.createCategory(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping(path = "/update")
    public Category updateCategory(@RequestBody Category request) {
        return categoryService.updateCategory(request);
    }
}
