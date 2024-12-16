package com.book.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.manage.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    
    // Custom query methods
    Book findByIsbn(String isbn);

}
