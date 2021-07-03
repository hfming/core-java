package com.hfm.genericity;

import com.hfm.entity.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 泛型上下型
 * @date 2020-04-30 10:07
 */
public class UpAndDownType {
    /**
     * 需求 2： 定义一个方法可以接受任意类型的集合对象， 接收的集合对象只能存储 Number 或者 Number 子类类型的数据。
     */
    public static void show1(Collection<? extends Number> c) {
        System.out.println(c);
    }

    /**
     * 需求 1： 定义一个方法可以接受任意类型的集合对象， 接收的集合对象只能存储 Integer 以及 Integer 父类类型的数据。
     */
    public static void show2(Collection<? super Integer> c) {
        System.out.println(c);
    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     * @return
     */
    public <T extends Integer> T print(T t) {
        return t;
    }

    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        // 只能放Number 及其子类
        show1(list1);
        // show(list2);
        show1(list3);
        // show(list4);

        // 只能放 Integer 及其父类
        show2(list1);
        // print(list2);
        show2(list3);
        show2(list4);
    }

    public static void printCollection3(Collection<? extends Person> coll) {
        //Iterator只能用Iterator<?>或Iterator<? extends Person>.why?
        Iterator<?> iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printCollection4(Collection<? super Person> coll) {
        //Iterator只能用Iterator<?>或Iterator<? super Person>.why?
        Iterator<?> iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void addString(List<? extends Object> arr) {
        // arr.add(new Object());
    }

    public static void addString2(List<? super Book> arr) {
        arr.add(new Book());
        // arr.add(new Object());
    }
}
