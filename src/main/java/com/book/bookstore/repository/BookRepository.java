package com.book.bookstore.repository;

import com.book.bookstore.domain.Book;
import org.hibernate.annotations.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)

    Iterable<Book> searchBooks(String query);

    Iterable<Book> findByCategoryId(Long categoryId);





}
