package com.yoyo.mapper;

import com.yoyo.pojo.Book;

import java.util.List;


public interface BookMapper {
    List<Book> findAllBooks();
    Book findBookById(int id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
}
