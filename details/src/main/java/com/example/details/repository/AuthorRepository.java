package com.example.details.repository;

import com.example.details.domain.entiry.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query(value = "SELECT * FROM search_api.author" , nativeQuery = true)
    List<Author[]> getAll();
    @Query(value = "SELECT * FROM Author p WHERE " +
            "p.author_id LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    List<Author> searchProductsSQL(String query);
}