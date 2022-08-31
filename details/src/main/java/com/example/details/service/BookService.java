package com.example.details.service;

import com.example.details.domain.entiry.Book;

import java.util.List;

public interface BookService {
    List<Book> searchBook(String query);
    List<Book[]> searchAllBook();
    Book createBook(Book book);
}