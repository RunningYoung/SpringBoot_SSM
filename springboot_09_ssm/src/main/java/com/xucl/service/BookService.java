package com.xucl.service;

import com.xucl.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Book service.
 */
@Transactional
public interface BookService {


    /**
     * Save boolean.
     *
     * @param book the book
     * @return the boolean
     */
    public boolean save(Book book);

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean delete(Integer id);

    /**
     * Update boolean.
     *
     * @param book the book
     * @return the boolean
     */
    public boolean update(Book book);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Book getById(Integer id);

    /**
     * Gets all books.
     *
     * @return the all books
     */
    public List<Book> getAllBooks();
}
