package com.example.details.service;

import com.example.details.domain.entiry.Author;
import com.example.details.domain.entiry.Book;

import java.util.List;

public interface AuthorService {

    List<Author> searchAuthor(String query);

    List<Author[]> searchAllAuthor();

    Author createAuthor(Author author);
}