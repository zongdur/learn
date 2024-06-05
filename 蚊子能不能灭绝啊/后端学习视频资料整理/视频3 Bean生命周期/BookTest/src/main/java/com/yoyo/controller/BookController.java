package com.yoyo.controller;

import com.yoyo.pojo.Book;
import com.yoyo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "listBooks"; // 对应的JSP页面名
    }
}
