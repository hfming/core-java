package com.hfm.library.dao;

import com.hfm.library.model.Book;
import com.hfm.library.model.User;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:54
 */
public interface RootUserInterface {
    /**
     * 添加书籍
     */
    public boolean addBook(ArrayList<Book> books, Book book);

    /**
     * 删除书籍
     */
    public boolean delectBook(ArrayList<Book> books, Book book);

    /**
     * 改变书籍信息
     */
    public boolean changeBook(ArrayList<Book> books, Book book);

    /**
     * 查看所有用户
     */
    public void showUsers(ArrayList<User> users);
}
