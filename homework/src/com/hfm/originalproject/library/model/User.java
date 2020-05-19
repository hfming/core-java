package com.hfm.originalproject.library.model;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 实体类 用户类的父类
 * @date 2020-04-19 0:49
 */
public class User {
    private static int userId = 0;
    private String userName;
    private String userPassword;
    private String mark;
    private ArrayList<Book> keepBooks;

    /**
     * 无参构造方法
     */
    public User() {
        super();
    }

    public User(String userName, String userPassword) {
        this();
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * 四参构造方法
     *
     * @param userId
     * @param userName
     * @param userPassword
     * @param mark
     */
    public User(int userId, String userName, String userPassword, String mark) {
        this(userName, userPassword);
        User.userId += 1;
        this.mark = mark;
    }

    /**
     * 全参构造方法
     *
     * @param userId
     * @param userName
     * @param userPassword
     * @param mark
     * @param keepBooks
     */
    public User(int userId, String userName, String userPassword, String mark, ArrayList<Book> keepBooks) {
        this(userId, userName, userPassword, mark);
        this.keepBooks = keepBooks;
    }

    @Override
    public int hashCode() {
        return userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (userId != userId) {
            return false;
        }
        return true;
    }

    @Override
    /**
     * 重写toString
     */
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", mark=" + mark
                + ", keepBooks=" + keepBooks + "]";
    }

    public ArrayList<Book> getKeepBooks() {
        return keepBooks;
    }

    public void setKeepBooks(ArrayList<Book> keepBooks) {
        this.keepBooks = keepBooks;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        User.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
