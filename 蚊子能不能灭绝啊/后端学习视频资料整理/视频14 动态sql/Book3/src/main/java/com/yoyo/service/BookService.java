package com.yoyo.service;

import com.yoyo.pojo.Book;

import java.util.List;


public interface BookService {

    public List<Book> findAllBooks();

    public Book findById(Integer id);

    public void deleteBook(Integer id);

    public void insertBook(Book book);

    public void updateBook(Book book);
}
