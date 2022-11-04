package com.book.bookstore.controller;

import com.book.bookstore.domain.Category;
import com.book.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public Category createCategory(@Validated @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<?> getCategory(@PathVariable Long category_id) {
        return categoryService.getCategory(category_id);

    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        return categoryService.getAllCategories();


    }

    @PutMapping("/category/{category_id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long category_id) {
        return categoryService.updateCategory(category, category_id);
    }

    @DeleteMapping("/category/{category_id}")
    public ResponseEntity<?> deletePoll(@PathVariable Long category_id) {
return categoryService.deleteCategory(category_id);

    }
}
