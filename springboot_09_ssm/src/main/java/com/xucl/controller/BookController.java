package com.xucl.controller;

import com.xucl.domain.Book;
import com.xucl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean result = bookService.save(book);
        return new Result(result ? Code.SAVE_OK : Code.SAVE_ERR, result);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = bookService.delete(id);
        return new Result(result ? Code.DELETE_OK : Code.DELETE_ERR, result);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean result = bookService.update(book);
        return new Result(result ? Code.UPDATE_OK : Code.UPDATE_ERR, result);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String message = book != null ? "" : "数据查询失败，请重试";
        return new Result(code, book, message);
    }

    @GetMapping
    public Result getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        Integer code = allBooks != null ? Code.GET_OK : Code.GET_ERR;
        String message = allBooks != null ? "" : "数据查询失败，请重试";
        return new Result(code, allBooks, message);
    }
}
