package com.hfm.originalproject.library.service;

import com.hfm.originalproject.library.model.Book;

import java.util.Comparator;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:47
 */
public class BookIdCompartor implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getBookId() -o2.getBookId();
    }
}
