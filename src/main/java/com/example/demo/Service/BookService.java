package com.example.demo.Service;

import com.example.demo.Repository.BookRepository;
//import com.example.demo.domain.Mapping.Author;
//import com.example.demo.domain.Mapping.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panbingcan on 2018/1/4.
 */
@Service
public class BookService {
    @Autowired
    private BookRepository articleRepository;

//    public Page<Book> getArticePage(Integer page, Integer size) {
//        Specification<Book> specification = new Specification<Book>() {
//            @Override
//            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Join<Book, Author> articleArticleLabelJoin = root.join("articleLabels", JoinType.LEFT);
//                Join<Label, Author> labelArticleLabelJoin = root.join("articleLabel", JoinType.INNER);
//                Predicate p1 = cb.gt(articleArticleLabelJoin.get("id"), 1);
//                Predicate p2 = cb.gt(labelArticleLabelJoin.get("id"), 1);
//                return cb.and(p1, p2);
//            }
//        };
//        return articleRepository.findAll(specification, new PageRequest(page, size, Sort.Direction.DESC, "id"));
//
//    }
}
