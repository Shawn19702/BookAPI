package com.book.bookstore.controller;

import com.book.bookstore.domain.Book;
import com.book.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books/{category_id}/books")
    public Optional<Book> createBook(@PathVariable(value = "category_id") Long category_id, @Validated @RequestBody Book book) {

        return bookService.createBook(category_id, book);
    }

    //    @GetMapping("/books/{id}")
//    public ResponseEntity<?> getPoll(@PathVariable Long id) {
//        return bookService.getBook(id);
//    }
    @GetMapping("/books")
    public Iterable<Book> getAllbooks() {
        return bookService.getAllbooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PutMapping("/books/{category_id}/books")
    public Optional<Book> updateBook(@PathVariable(value = "category_id") Long category_id, @Validated @RequestBody Book book) {

        return bookService.updateBook(category_id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);

    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Book> findCategorybyId(@PathVariable Long categoryId){
        return bookService.findCategorybyId(categoryId);
    }
    @GetMapping("/searchbooks")
    public Iterable<Book> searchBooks(@RequestParam("query") String query){
        return bookService.searchBooks(query);
    }


//    @GetMapping("/books/{category_id}/books")
//    public Page<Book> getAllCommentsByBookID(@PathVariable (value = "category_id") Long category_id, Pageable pageable) {
//        return bookService.getAllCategoriesByBookId(category_id, pageable);
//    }


//    @GetMapping("/book")
//    public ResponseEntity<Iterable<Book>> getAllBooks() {
//        return bookService.getAllbooks();
//    }
//
//
//    @GetMapping("/book/{Id}")
//    public ResponseEntity<?> getBook(@PathVariable Long bookId) {
//        return bookService.getBook(bookId);
//    }
//
//
//    @PutMapping("/book{id}")
//    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable Long bookId) {
//        return bookService.updateBook(book, bookId);
//    }
//
//
//    @DeleteMapping("/book/{id}")
//    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
//        return bookService.deleteBook(bookId);
//    }



}

