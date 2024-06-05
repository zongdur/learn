package com.yoyo.service.impl;

import com.yoyo.mapper.BookMapper;
import com.yoyo.pojo.Book;
import com.yoyo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }
}
