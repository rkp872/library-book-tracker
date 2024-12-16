package com.book.manage.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.book.manage.model.Book;

public interface BookService {
    Book createBook(Book book); // Add a new book

    Book getBookById(Long id); // Get Book By ID

    Page<Book> getAllBooks(int page,int size, String sortBy);  // Retrieve all books

    Book updateBook(Long id, Book book); // Update book details

    void deleteBook(Long id); // Delete a book by ID

}
