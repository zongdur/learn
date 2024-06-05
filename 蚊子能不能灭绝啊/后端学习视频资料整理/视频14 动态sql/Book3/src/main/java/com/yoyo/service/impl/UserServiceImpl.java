package com.yoyo.service.impl;

import com.yoyo.mapper.BookMapper;
import com.yoyo.mapper.BorrowBookMapper;
import com.yoyo.mapper.UserMapper;
import com.yoyo.pojo.Book;
import com.yoyo.pojo.BorrowBook;
import com.yoyo.pojo.User;
import com.yoyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BorrowBookMapper borrowBookMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        BorrowBook borrowBook=new BorrowBook();
        borrowBook.setUserId(userId);
        LocalDate defaultDate = LocalDate.of(1000, 1, 1);
        Date date=java.sql.Date.valueOf(defaultDate);
        borrowBook.setReturnDate(date);
//        List<Integer> bookIdList=borrowBookMapper.selectByCondition1(borrowBook);
//        bookIdList.forEach(oneBorrow->bookMapper.returnBook(oneBorrow));

        List<Integer> bookIdList=borrowBookMapper.selectByCondition(borrowBook);
        bookMapper.returnBooks(bookIdList);

        borrowBookMapper.deleteByUserId(userId);
        userMapper.deleteUser(userId);
//        bookIdList.forEach(bookId->bookMapper.returnBook(bookId));
        }
}
