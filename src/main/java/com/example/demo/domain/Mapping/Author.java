package com.example.demo.domain.Mapping;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by panbingcan on 2018/1/4.
 */
@Entity
@Table(name = "Author")
public class Author {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
        super();
    }

    public Author(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return String.format("Author [id=%s, name=%s, books=%s]", id, name, books);
    }
}
