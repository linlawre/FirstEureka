package com.example.details.service.serviceImpl;

import com.example.details.domain.entiry.Book;
import com.example.details.exception.ResourceNotFoundException;
import com.example.details.repository.BookRepository;
import com.example.details.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchBook(String query) {
        List<Book> books = bookRepository.searchProductsSQL(query);
        if (books.isEmpty()) {
            throw new ResourceNotFoundException(".....");
        }

        return books;
    }

    @Override
    public List<Book[]> searchAllBook() {
        List<Book[]> books = bookRepository.getAll();
        return books;
    }
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}