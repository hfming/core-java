package com.hfm.originalproject.library.dao;

import com.hfm.originalproject.library.model.Book;
import com.hfm.originalproject.library.model.User;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description用户类接口
 * @date 2020-04-19 0:53
 */

public interface UserInterface {
    /**
     * 还书

     */
    public boolean returnBook(ArrayList<Book> books, Book book, User user);

    /**
     * 借书

     */
    public boolean brrorwBook(ArrayList<Book> books, Book book, User user);

    /**
     * 查书

     */
    public boolean findBook(ArrayList<Book> books, Book book);
}

