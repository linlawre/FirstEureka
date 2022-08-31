package com.example.details.repository;


import com.example.details.domain.entiry.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query(value = "SELECT p FROM Book p WHERE " +
//            "p.book_name LIKE CONCAT('%',:query, '%')", nativeQuery = true)
//
//    List<Book> searchProductsSQL(String query);
// entity manager customer
    @Query(value = "SELECT * FROM search_api.book" , nativeQuery = true)
    List<Book[]> getAll();


    @Query(value = "SELECT * FROM Book b WHERE " +
            "b.book_id LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    List<Book> searchProductsSQL(String query);



}