package com.example.details.service.serviceImpl;

import com.example.details.domain.entiry.Author;
import com.example.details.domain.entiry.Book;
import com.example.details.exception.ResourceNotFoundException;
import com.example.details.repository.AuthorRepository;
import com.example.details.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> searchAuthor(String query) {
        List<Author> author = authorRepository.searchProductsSQL(query);
        if(author.isEmpty()){
            throw new ResourceNotFoundException(".....");
        }
        return author;
    }

    @Override
    public List<Author[]> searchAllAuthor() {
        List<Author[]> author = authorRepository.getAll();
        return author;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}