package com.example.demo.Repository;

import com.alibaba.fastjson.JSON;
import com.example.demo.Service.BookService;
import com.example.demo.domain.Mapping.Author;
import com.example.demo.domain.Mapping.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


/**
 * Created by panbingcan on 2018/1/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    //    @Before(value = "execution(public * com.example.demo.Repository.BookRepositoryTest.*.*(..))")
    public void init() {
//        Author lewis = new Author("Lewis");
//        Author mark = new Author("Mark");
//        Author peter = new Author("Peter");
//
//        Book spring = new Book("Spring in Action");
//        spring.getAuthors().addAll(Arrays.asList(lewis, mark));
//
//        Book springboot = new Book("Spring Boot in Action");
//        springboot.getAuthors().addAll(Arrays.asList(lewis, peter));
//
//        bookRepository.save(Arrays.asList(spring, springboot));
    }

    //    @After(value = "execution(public * com.example.demo.Repository.BookRepositoryTest.*.*(..))")
    public void deleteAll() {
        // 删除所有书籍，级联删除关联的作者，但是没有与书籍关联的作者不会被删掉
        bookRepository.deleteAll();

        // 删除所有作者，只能删除没有与书籍关联的作者，与书籍有关联的作者无法被删除
        authorRepository.deleteAll();
    }

    @Test
    public void add() {
        Author lewis = new Author("Lewis");
        Author mark = new Author("Mark");
        Author peter = new Author("Peter");

        Book spring = new Book("Spring in Action");
        spring.getAuthors().addAll(Arrays.asList(lewis, mark));

        Book springboot = new Book("Spring Boot in Action");
        springboot.getAuthors().addAll(Arrays.asList(lewis, peter));

        bookRepository.save(Arrays.asList(spring, springboot));
    }

    @Test
    public void findAll() {
        System.out.println(authorRepository.findAll().size());
        System.out.println(authorRepository.findAll().size());
    }



    @Test
    public void findByName() {
//        bookRepository.findByName("Spring in Action");
//        authorRepository.findByName("Lewis");
//        System.out.println(authorRepository.findByName("Lewis").getBooks().size());
    }
//
//    @Test
//    public void findByNameContaining() {
//        assertThat(bookRepository.findByNameContaining("Spring")).hasSize(2);
//
//        assertThat(authorRepository.findByNameContaining("e")).hasSize(2);
//    }
//
//    @Test
//    public void margeBook() {
//        Book book = bookRepository.findByName("Spring in Action");
//        assertThat(book).isNotNull();
//
//        book.setName("Spring in Action (4th Edition)");
//        bookRepository.save(book);
//
//        assertThat(bookRepository.findByName("Spring in Action")).isNull();
//        assertThat(bookRepository.findByName("Spring in Action (4th Edition)")).isNotNull();
//    }
//
//    @Test
//    public void deleteBook() {
//        Book book = bookRepository.findByName("Spring Boot in Action");
//        assertThat(book).isNotNull();
//
//        bookRepository.delete(book);
//
//        assertThat(bookRepository.findAll()).hasSize(1);
//        assertThat(bookRepository.findByName("Spring Boot in Action")).isNull();
//
//        assertThat(authorRepository.findAll()).hasSize(2);
//        assertThat(authorRepository.findByName("Peter")).isNull();
//    }
//
//    @Test
//    public void plusAuthor() {
//        Book book = bookRepository.findByName("Spring in Action");
//        assertThat(book).isNotNull();
//
//        Author author = authorRepository.findByName("Jacob");
//        assertThat(author).isNull();
//
//        book.getAuthors().add(new Author("Jacob"));
//        bookRepository.save(book);
//
//        assertThat(bookRepository.findByName("Spring in Action").getAuthors()).hasSize(3);
//
//        assertThat(authorRepository.findAll()).hasSize(4);
//        assertThat(authorRepository.findByName("Jacob")).isNotNull();
//    }
//
//    @Test
//    public void clearAuthor() {
//        Book book = bookRepository.findByName("Spring in Action");
//        assertThat(book).isNotNull();
//
//        book.getAuthors().clear();
//        bookRepository.save(book);
//
//        assertThat(bookRepository.findAll()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring in Action").getAuthors()).isEmpty();
//
//        assertThat(authorRepository.findAll()).hasSize(3);
//    }
//
//    @Test
//    public void removeAuthor() {
//        Book book = bookRepository.findByName("Spring Boot in Action");
//        assertThat(book).isNotNull();
//
//        Author author = authorRepository.findByName("Peter");
//        assertThat(author).isNotNull();
//
//        book.getAuthors().remove(author);
//        bookRepository.save(book);
//
//        assertThat(bookRepository.findAll()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring Boot in Action").getAuthors()).hasSize(1);
//
//        assertThat(authorRepository.findAll()).hasSize(3);
//        assertThat(authorRepository.findByName("Peter")).isNotNull();
//    }
//
//    @Test
//    public void removeAllautors() {
//        Book book = bookRepository.findByName("Spring in Action");
//        assertThat(book).isNotNull();
//
//        book.getAuthors().removeAll(book.getAuthors());
//        bookRepository.save(book);
//
//        assertThat(bookRepository.findAll()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring in Action").getAuthors()).isEmpty();
//
//        assertThat(authorRepository.findAll()).hasSize(3);
//    }
//
//    @Test
//    public void deleteAuthor() {
//        Author author = authorRepository.findByName("Peter");
//        assertThat(author).isNotNull();
//
//        authorRepository.delete(author);
//
//        assertThat(bookRepository.findAll()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring in Action").getAuthors()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring Boot in Action").getAuthors()).hasSize(2);
//
//        assertThat(authorRepository.findAll()).hasSize(3);
//        assertThat(authorRepository.findByName("Peter")).isNotNull();
//    }
//
//    @Test
//    public void deleteAllAuthors() {
//        authorRepository.deleteAll();
//
//        assertThat(bookRepository.findAll()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring in Action").getAuthors()).hasSize(2);
//        assertThat(bookRepository.findByName("Spring Boot in Action").getAuthors()).hasSize(2);
//
//        assertThat(authorRepository.findAll()).hasSize(3);
//    }

}