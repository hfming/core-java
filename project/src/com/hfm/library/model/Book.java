package com.hfm.library.model;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 实体类，书籍
 * @date 2020-04-19 0:43
 */

public class Book {
    private int bookId;
    private String bookName;
    private double price;
    private int number;
    private String author;

    /**
     * 无参构造方法
     */
    public Book() {
        super();
    }

    /**
     * 双参构造方法
     *
     * @param bookId
     * @param bookName
     */
    public Book(int bookId, String bookName) {
        this();
        this.bookId = bookId;
        this.bookName = bookName;
    }

    /**
     * 五参构造方法
     *
     * @param bookId
     * @param bookName
     * @param price
     * @param number
     * @param author
     */
    public Book(int bookId, String bookName, double price, int number, String author) {
        this(bookId, bookName);
        this.price = price;
        this.number = number;
        this.author = author;
    }

    @Override
    /**
     * 重写toString方法
     */
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", number=" + number
                + ", author=" + author + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bookId;
        return result;
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
        Book other = (Book) obj;
        if (bookId != other.bookId) {
            return false;
        }
        return true;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
