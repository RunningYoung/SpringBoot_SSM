package com.xucl;

import com.xucl.domain.Book;
import com.xucl.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xucl
 * @apiNote
 * @date 2023/2/23 16:16
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetBookById() {
        Book book = bookService.getById(2);
        System.out.println(book);
    }

    @Test
    public void testGetAllBook() {
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println(allBooks);
    }
}
