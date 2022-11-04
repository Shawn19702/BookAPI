package com.book.bookstore.service;

import com.book.bookstore.repository.BookRepository;
import com.book.bookstore.domain.Book;
import com.book.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class BookService{
//    @Autowired
//    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public Optional<Book> createBook(Long categoryid, Book book)  {
        return categoryRepository.findById(categoryid).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });//.orElseThrow(() -> new ResourceNotFoundException("categoryid " + categoryid + " not found"));

    }



    public Iterable<Book> getAllbooks() {

        return bookRepository.findAll();

    }

    public ResponseEntity<?> getBook(Long category_id) {
        Book p = bookRepository.findById(category_id).orElse(null);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }



    public Optional<Book> updateBook(Long category_id, Book book)  {
        return categoryRepository.findById(category_id).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });//.orElseThrow(() -> new ResourceNotFoundException("categoryid " + categoryid + " not found"));

    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    public Iterable<Book> findCategorybyId(Long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }

    public Iterable<Book> searchBooks(String query){
        return bookRepository.searchBooks(query);
    }
}











//    public ResponseEntity<?> getBook( Long id) {
//        Book p = bookRepository.findById(id).orElse(null);
//
//        return new ResponseEntity<>(p, HttpStatus.OK);
//
//    }

//    public Page<Book> getAllCategoriesByBookId( Long categoryid, Pageable pageable) {
//        return bookRepository.findByBookID(categoryid, pageable);
//    }




//    public ResponseEntity<Iterable<Book>> getAllbooks() {
//        Iterable<Book> allBooks = bookRepository.findAll();
//        return new ResponseEntity<>(allBooks, HttpStatus.OK);
//        // response entity is the http response we return it in the controller class
//
//
//    }



//
//    @PostMapping("/posts/{postId}/comments")
//    public Comment createComment(@PathVariable (value = "postId") Long postId, @Valid @RequestBody Comment comment) {
//        return postRepository.findById(postId).map(post -> {
//            comment.setPost(post);
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }



//
//
//
//
//    public ResponseEntity<?> getBook(Long pollId) {
//        Book p = bookRepository.findById(pollId).orElse(null);
//
//        return new ResponseEntity<>(p, HttpStatus.OK);
//    }
//
//
//    public ResponseEntity<?> updateBook(Book book, Long pollId) {
//
//        // Save the response entity of the updated poll
//        Book p = bookRepository.save(book);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    public ResponseEntity<?> deleteBook(Long pollId) {
//        // deletes the polls id
//        bookRepository.deleteById(pollId);
//        return new ResponseEntity<>(HttpStatus.OK);

//    public Optional<Poll> getPoll(Long pollId) throws Exception {
//        Optional<Poll> p = pollRepository.findById(pollId);
//        if (p.isEmpty()) {
//throw new Exception();
//            System.out.println();
//            }
//        return p;
//    }


//        Optional<Poll> p = pollRepository.findById(pollId);
//        if(p == null) {
//            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
//        }
//        return new ResponseEntity<> (p, HttpStatus.OK);



