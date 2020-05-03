package com.hfm.library.dao;

import com.hfm.library.model.Book;
import com.hfm.library.model.User;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:51
 */
public class UserDao implements UserInterface {
    ArrayList<User> users = null;

    /**
     * 无参构造方法
     */
    public UserDao() {
        super();
    }

    /**
     * 全参构造方法
     *
     * @param users
     */
    public UserDao(ArrayList<User> users) {
        this();
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    /**
     * 还书，用户已经登录，书库中书增加1，用户中的书删除(同一本书一个用户只要借一本)
     */
    public boolean returnBook(ArrayList<Book> books, Book book, User user) {
        if (books.contains(book)) {
            user.getKeepBooks().remove(book);
            books.get(book.getBookId()).setNumber(books.get(book.getBookId()).getNumber() + 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 借书，用户已经登录，书库中的书减1，用户持有该书
     */
    @Override
    public boolean brrorwBook(ArrayList<Book> books, Book book, User user) {
        if (books.contains(book)) {
            if (books.get(book.getBookId() - 1).getNumber() == 0) {
                return false;
            } else {
                books.get(book.getBookId() - 1).setNumber(books.get(book.getBookId() - 1).getNumber() - 1);
                if (user.getKeepBooks() != null) {
                    user.getKeepBooks().add(book);
                } else {
                    ArrayList<Book> keepBooks = user.getKeepBooks();
                    keepBooks = new ArrayList<Book>();
                    keepBooks.add(book);
                }
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    /**
     * 找书，用户可以不登录
     */
    public boolean findBook(ArrayList<Book> books, Book book) {
        if (books.contains(book)) {
            System.out.println(books.get(book.getBookId() - 1).toString());
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加用户
     *
     * @param users
     */
    public boolean addUser(ArrayList<User> users, User user) {
        if (users.contains(user) == false) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    ;

    /**
     * 删除用户
     *
     * @param users
     * @param user
     */
    public boolean delectUser(ArrayList<User> users, User user) {
        if (users.contains(user)) {
            users.remove(user);
            return true;
        } else {
            return false;
        }
    }

    ;

    /**
     * 改变用户
     *
     * @param users
     * @param user
     */
    public boolean changeUser(ArrayList<User> users, User user) {
        if (users.contains(user)) {
            users.set(users.indexOf(user), user);
            return true;
        } else {
            return false;
        }
    }

    ;

    /**
     * 展示用户
     *
     * @param users
     * @param user
     */
    public boolean showUser(ArrayList<User> users, User user) {
        if (users.contains(user)) {
            System.out.println(user.toString());
            return true;
        } else {
            return false;
        }
    }
}
