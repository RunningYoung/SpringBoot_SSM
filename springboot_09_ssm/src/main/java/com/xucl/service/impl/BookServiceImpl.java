package com.xucl.service.impl;

import com.xucl.controller.Code;
import com.xucl.dao.BookDao;
import com.xucl.domain.Book;
import com.xucl.exception.BusinessException;
import com.xucl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xucl
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        System.out.println(book);
        return bookDao.save(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    public Book getById(Integer id) {

        // 将可能出现的异常进行包装，转换成自定义异常
        if (id == 1) {
            throw new BusinessException(Code.BUSINESS_ERROR, "请不要使用你的技术挑战我的耐心");
        }

        // try {
        //     int i = 1 / 0;
        // } catch (Exception e) {
        //     throw new SystemException(Code.SYSTEM_TIMEOUT, "服务器访问超时，请重试", e);
        // }

        return bookDao.getById(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
