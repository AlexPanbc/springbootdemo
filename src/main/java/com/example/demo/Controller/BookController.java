package com.example.demo.Controller;

import com.example.demo.Service.BookService;
import com.example.demo.domain.Mapping.Book;
import com.example.demo.domain.Result;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by panbingcan on 2018/1/5.
 */
@RestController
@RequestMapping(value = "book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "getBookPage/{page}/{size}")
    public Result<Page<Book>> getAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) throws Exception {
        return ResultUtil.success(bookService.getBookPage(page, size));
    }

}
