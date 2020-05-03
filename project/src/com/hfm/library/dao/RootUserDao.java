package com.hfm.library.dao;

import com.hfm.library.model.Book;
import com.hfm.library.model.User;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:52
 */
public class RootUserDao extends UserDao implements RootUserInterface {
    public RootUserDao(ArrayList<User> users) {
        super(users);
    }

    @Override
    public boolean addBook(ArrayList<Book> books, Book book) {
        if (books.contains(book)) {
            return false;
        } else {
            books.add(book);
            return true;
        }
    }

    @Override
    public boolean delectBook(ArrayList<Book> books, Book book) {
        if (books.contains(book) == false) {
            return false;
        } else {
            books.remove(book);
            return true;
        }
    }

    @Override
    public boolean changeBook(ArrayList<Book> books, Book book) {
        if (books.contains(book) == false) {
            return false;
        } else {
            int id = book.getBookId();
            books.get(id).setBookName(book.getBookName());
            books.get(id).setBookId(book.getBookId());
            books.get(id).setNumber(book.getNumber());
            books.get(id).setPrice(book.getPrice());
            return true;
        }
    }

    @Override
    public void showUsers(ArrayList<User> users) {

    }
}
