package com.example.demo.Service;

import com.example.demo.Repository.BookRepository;
import com.example.demo.domain.Mapping.Author;
import com.example.demo.domain.Mapping.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

/**
 * Created by panbingcan on 2018/1/4.
 */
@Service
public class BookService {
    @Autowired
    private BookRepository articleRepository;

    public Page<Book> getBookPage(Integer page, Integer size) throws Exception {
        Specification<Book> specification = new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = cb.gt(root.get("id"), 1);
                return cb.and(p1);
            }
        };
        return articleRepository.findAll(new PageRequest(page, size, Sort.Direction.DESC, "id"));
    }
}
