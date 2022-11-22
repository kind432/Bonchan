package com.example.bonchan.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path ="categories")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path ="/")
    public Iterable<Category> GetAllCategories() {
        return categoryService.GetAllCategories();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path ="/{id}")
    public Optional<Category> GetCategoryById(@PathVariable Long id) {
        return categoryService.GetCategoryById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/")
    public Category CreateCategory(@RequestBody Category request) {
        return categoryService.CreateCategory(request);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void DeleteCategoryById(@PathVariable Long id) {
        categoryService.DeleteCategory(id);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/")
    public Category UpdateCategory(@RequestBody Category request) {
        return categoryService.UpdateCategory(request);
    }
}
