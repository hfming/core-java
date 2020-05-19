package com.hfm.genericity;

import com.hfm.entity.Book;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 泛型格式
 * @date 2020-04-30 9:31
 */
public class GenericityTest {
    public static void main(String[] args) {
        // true  两边都加入泛型格式，并且泛型的数据类型一致
        ArrayList<Book> list1 = new ArrayList<Book>();
        // false	泛型没有多态
        // ArrayList<Object> list2 = new ArrayList<Book>();
        // False
        // ArrayList<Book> list3 = new ArrayList<Object>();
        // true 单边定义泛型格式也可以，为了新老系统的兼用性
        ArrayList list4 = new ArrayList<Book>();
        // true
        ArrayList<Book> list5 = new ArrayList();
    }
}
