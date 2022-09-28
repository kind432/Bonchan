package com.example.bonchan.category.models;

public class CategoriesResponse {
    private Iterable<Category> categories;

    public CategoriesResponse(Iterable<Category> categories) {
        this.categories = categories;
    }

    public Iterable<Category> getCategories() {
        return categories;
    }

    public void setCategories(Iterable<Category> categories) {
        this.categories = categories;
    }
}