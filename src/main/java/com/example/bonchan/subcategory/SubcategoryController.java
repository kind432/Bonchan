package com.example.bonchan.subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "subcategories")
public class SubcategoryController {
    private SubcategoryService subcategoryService;
    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping(path = "/{categoryId}")
    public Iterable<Subcategory> getSubcategoriesByCategoryId(@PathVariable Long categoryId) {
        return subcategoryService.getSubcategoriesByCategoryId(categoryId);
    }

    @PostMapping(path = "/create")
    public Subcategory createSubcategory(@RequestBody Subcategory request) {
        return subcategoryService.createSubcategory(request);
    }

    @PutMapping(path = "/update")
    public Subcategory updateSubcategory(@RequestBody Subcategory request){
        return subcategoryService.updateSubcategory(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
    }

}
