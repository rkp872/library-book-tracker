package com.book.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.book.manage.model.Book;
import com.book.manage.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found with id : "+id));
    }

    @Override
    public Page<Book> getAllBooks(int page,int size, String sortBy) {
        return bookRepository.findAll(PageRequest.of(page,size,Sort.by(sortBy)));
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

    @Override
    public String fetchBookDetails(String query) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;
        String response=restTemplate.getForObject(url, String.class);

        return response;
    }

}
