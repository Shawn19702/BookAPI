package com.book.bookstore.service;

import com.book.bookstore.domain.Book;
import com.book.bookstore.domain.Category;
import com.book.bookstore.repository.BookRepository;
import com.book.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public ResponseEntity<?> getCategory(Long Id) {
        Category p = categoryRepository.findById(Id).orElse(null);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Category>> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    public ResponseEntity<?> updateCategory(Category category, Long category_id) {
        categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> deleteCategory(Long category_id) {
        categoryRepository.deleteById(category_id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
