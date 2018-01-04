package com.example.demo.Repository;

import com.example.demo.domain.Mapping.Author;
import com.example.demo.domain.Mapping.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by panbingcan on 2018/1/4.
 */
public interface AuthorRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
    Author findByName(String name);

    List<Author> findByNameContaining(String name);
}
