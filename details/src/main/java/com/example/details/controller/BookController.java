package com.example.details.controller;

import com.example.details.domain.entiry.Book;
import com.example.details.exception.CommonErrorResponse;
import com.example.details.exception.ResourceNotFoundException;
import com.example.details.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Book>> searchBooks(@PathVariable String id){
        return new ResponseEntity<>(bookService.searchBook(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Book[]>> searchBooks(){
        return new ResponseEntity<>(bookService.searchAllBook(), HttpStatus.OK);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNoutFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("cannot find that resource"), HttpStatus.NOT_FOUND);
    }
}