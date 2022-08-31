package com.example.details.controller;

import com.example.details.domain.dto.EmployeeResponseDTO;
import com.example.details.domain.entiry.Author;
import com.example.details.exception.CommonErrorResponse;
import com.example.details.exception.ResourceNotFoundException;
import com.example.details.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Author>> searchAuthor(@RequestParam("id") String query){
//        return ResponseEntity.ok(authorService.searchAuthor(query));
//    }
    @GetMapping("/author/{id}")
    public ResponseEntity<List<Author>> searchBooks(@PathVariable String id){
        return new ResponseEntity<>(authorService.searchAuthor(id), HttpStatus.OK);
    }
//    @GetMapping("/author/{id}")
//    public ResponseEntity<EmployeeResponseDTO> getEmpById(@PathVariable String id) {
//        return new ResponseEntity<>(authorService.getById(id), HttpStatus.OK);
//    }
    @GetMapping("/author")
    public ResponseEntity<List<Author[]>> searchBooks(){
        return new ResponseEntity<>(authorService.searchAllAuthor(), HttpStatus.OK);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNoutFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("cannot find that resource"), HttpStatus.NOT_FOUND);
    }
}