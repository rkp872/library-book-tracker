package com.book.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.manage.model.Book;
import com.book.manage.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found with id : "+id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
       Book book=bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found with id : "+id));

       book.setTitle(bookDetails.getTitle());
       book.setAuthor(bookDetails.getAuthor());
       book.setGenre(bookDetails.getGenre());
       book.setIsbn(bookDetails.getIsbn());
       book.setPublicationDate(bookDetails.getPublicationDate());
       book.setPrice(bookDetails.getPrice());

       return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found with id : "+id));
        bookRepository.delete(book);
    }

}
