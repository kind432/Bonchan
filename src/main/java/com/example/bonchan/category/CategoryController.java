package com.example.bonchan.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="cat/v1")
public class CategoryController {

    private CategoryService catserv;

    @Autowired
    public CategoryController(CategoryService catserv) {
        this.catserv = catserv;
    }

    @RequestMapping(path="/cat")
    public Category me() {
        return catserv.getCategoryById(1);
    }
}
