package com.hfm.collection.list.arraylist;

import cn.hfming.entity.Book;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 集合练习
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class ArrayListTest {
    /**
     * 练习：去除ArrayList集合中重复元素
     * 1.存入字符串元素
     * 2.存入自定义对象元素（如 Perosn 对象）
     * 原理：循环遍历该集合，每取出一个放置在新的集合中，放置之前先判断新的集合是否以包含了新的元素。
     */
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book(110, "java 编程思想", 86));
        list.add(new Book(112, "java 核心技术", 64));
        list.add(new Book(110, "java 神书", 86));
        list.add(new Book(119, "深入 javaWeb", 32));
        ArrayList<Book> newList = clearRepeat(list);
        System.out.println("新集合的元素是：" + newList);
        list.trimToSize();
        System.out.println(list.toString());

        // ensureCapacity(int minCapacity) 如果需要，增加此 ArrayList实例的容量，以确保它可以至少保存最小容量参数指定的元素数。
        ArrayList<Book> books = new ArrayList<Book>();
        // 初始长度为10
        System.out.println(books.size());
        // 容量增加10
        books.ensureCapacity(10);
        System.out.println(books.size());

        System.out.println(books);
        books.add(new Book(110, "java 编程思想", 86));
        books.add(new Book(112, "java 核心技术", 64));
        books.add(new Book(110, "java 神书", 86));
        books.add(new Book(119, "深入 javaWeb", 32));
        System.out.println(books);

        // removeRange(int fromIndex, int toIndex)	从这个列表中删除所有索引在 fromIndex （含）和 toIndex之间的元素。

        // trimToSize()	修改这个 ArrayList实例的容量是列表的当前大小。
        books.trimToSize();
        System.out.println(books.size());
    }

    /**
     * clearRepeat
     * @param OldList
     * @return
     */
    public static ArrayList<Book> clearRepeat(ArrayList<Book> OldList) {
        // 创建一个新的集合对象
        ArrayList<Book> newList = new ArrayList<Book>();
        // 遍历旧集合的元素
        // 获取迭代器对象
        Iterator it = OldList.iterator();
        while (it.hasNext()) {
            // 从旧集合中取出的元素 , 判断新集合中是否存在该元素
            Book book = (Book) it.next();
            // contains 底层是依赖 euqals 方法，equals 默认比较的是内存地址。
            if (!newList.contains(book)) {
                // 如果不包含该本书籍，则应该添加到新集合中
                newList.add(book);
            }
        }
        return newList;
    }
}
