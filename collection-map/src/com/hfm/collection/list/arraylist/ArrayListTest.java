package com.hfm.collection.list.arraylist;

import com.hfm.entity.Book;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ArrayList 集合练习
 *
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
        ArrayList<Book> books = new ArrayList<Book>(10);
        // 初始长度为10
        System.out.println(books.toArray().length);

        // 容量增加10
        books.addAll(list);
        books.ensureCapacity(10);
        System.out.println(books.size());
        System.out.println(books.toArray().length);

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
        Arrays.asList();
    }

    /**
     * clearRepeat
     *
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

    /**
     * 打印集合方法
     */
    @Test
    public void iteratorRemove() {
        ArrayList<Book> books = new ArrayList<Book>(10);
        books.add(new Book(110, "java 编程思想", 86));
        books.add(new Book(112, "java 核心技术", 64));
        books.add(new Book(110, "java 神书", 86));
        books.add(new Book(119, "深入 javaWeb", 32));

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(books);
    }

    @Test
    public void arrayListRemove() {
        ArrayList<Book> books = new ArrayList<Book>(10);
        books.add(new Book(110, "java 编程思想", 86));
        books.add(new Book(112, "java 核心技术", 64));
        books.add(new Book(110, "java 神书", 86));
        books.add(new Book(119, "深入 javaWeb", 32));

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
             System.out.println(iterator.next());
            // java.util.ConcurrentModificationException
            // books.remove(iterator.next());
        }
        System.out.println(books);
    }

    /**
     * 数值添加到集合
     */
    @Test
    public void addRandom() {
        // 创建Random 对象
        // 创建ArrayList 对象
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        // 添加随机数到集合
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(33) + 1;
            list.add(r);
        }// 遍历集合输出
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    /**
     * ArrayList集合频繁修改造成性能低下的解决方法
     */
    @Test
    public void adddElement2() {
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 100000; i++) {
            books.add(new Book(110, "java 编程思想", 86));
            books.add(new Book(112, "java 核心技术", 64));
            books.add(new Book(110, "java 神书", 86));
            books.add(new Book(119, "深入 javaWeb", 32));
        }
        long begin = 0L;
        long end = 0L;
        begin = System.currentTimeMillis();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        end = System.currentTimeMillis();
        long time1 = end - begin;

        ArrayList<Book> book2s = new ArrayList<Book>(40000);
        for (int i = 0; i < 100000; i++) {
            book2s.add(new Book(110, "java 编程思想", 86));
            book2s.add(new Book(112, "java 核心技术", 64));
            book2s.add(new Book(110, "java 神书", 86));
            book2s.add(new Book(119, "深入 javaWeb", 32));
        }

        begin = System.currentTimeMillis();
        for (int i = 0; i < book2s.size(); i++) {
            System.out.println(book2s.get(i));
        }
        end = System.currentTimeMillis();
        long time2 = end - begin;
//        For 循环10339
        System.out.println("For 循环" + time1);
//        For 循环4700
        System.out.println("For 循环" + time2);
    }

    @Test
    public void randomAccessTest() {
        ArrayList<Book> books = new ArrayList<Book>(10);
        for (int i = 0; i < 10000; i++) {
            books.add(new Book(110, "java 编程思想", 86));
            books.add(new Book(112, "java 核心技术", 64));
            books.add(new Book(110, "java 神书", 86));
            books.add(new Book(119, "深入 javaWeb", 32));
        }

        Iterator<Book> iterator = books.iterator();
        ListIterator<Book> bookListIterator = books.listIterator();
        long begin = 0L;
        long end = 0L;

        begin = System.currentTimeMillis();
        for (Book book : books) {
            System.out.println(book);
        }
        end = System.currentTimeMillis();
        long time2 = end - begin;

        begin = System.currentTimeMillis();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        end = System.currentTimeMillis();
        long time3 = end - begin;

        begin = System.currentTimeMillis();
        while (bookListIterator.hasNext()) {
            System.out.println(bookListIterator.next());
        }
        end = System.currentTimeMillis();
        long time4 = end - begin;

        begin = System.currentTimeMillis();
        while (bookListIterator.hasPrevious()) {
            System.out.println(bookListIterator.previous());
        }
        end = System.currentTimeMillis();
        long time5 = end - begin;

        begin = System.currentTimeMillis();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        end = System.currentTimeMillis();
        long time1 = end - begin;

        System.out.println("For 循环" + time1);
        System.out.println("For-Each 循环" + time2);
        System.out.println("迭代器" + time3);
        System.out.println("特有迭代器" + time4);
        System.out.println("特有迭代器逆序" + time5);
//        For 循环532
//        For-Each 循环2034
//        迭代器2272
//        特有迭代器879
//        特有迭代器逆序625
    }
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private static void updateList(List list) {
        list.remove(2);
    }
}
