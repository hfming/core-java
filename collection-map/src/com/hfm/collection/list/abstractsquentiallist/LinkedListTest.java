package com.hfm.collection.list.abstractsquentiallist;

import com.hfm.entity.Book;
import com.hfm.entity.User;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * LinkedList集合测试
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<User> list = new LinkedList<User>();
        list.add(new User(1, "hhd", "0001"));
        stack(list);
        quene(list);
        // 清空
        list.clear();
        // addFirst() 把元素添加到集合的首位置
        list.addFirst(new User(7, "hhd", "0007"));
        // getFirst() 获取集合的首位置元素
        System.out.println(list.getFirst());
        // addFirst() 把元素添加到集合的末尾处。
        list.addLast(new User(8, "hhd", "0008"));
        // getLast() 获取集合的末尾元素
        System.out.println(list.getLast());
        // 删除集合的首元素
        list.removeFirst();
        System.out.println(list);
        // 删除集合的末尾元素：如果集合中没有元素，获取或者删除元素抛：NoSuchElementException
        list.removeLast();
        System.out.println(list);

        list.add(new User(7, "hhd", "0007"));
        list.add(new User(8, "hhd", "0008"));
        list.add(new User(9, "hhd", "0009"));
        list.add(new User(7, "hhd", "0007"));
        // 删除该列表中指定元素的第一次出现(当遍历列表从头到尾时)。如果列表中不包含元素，那么它是不变的。
        System.out.println(list);
        list.removeFirstOccurrence(new User(7, "hhd", "0007"));
        System.out.println(list);

        // 删除该列表中指定元素的最后一次出现(从头部到尾部遍历列表)
        list.removeLastOccurrence(new User(7, "hhd", "0007"));
        System.out.println(list);

        // offerFirst() 在这个列表的前面插入指定的元素。
        list.offerFirst(new User(7, "hhd", "0007"));
        System.out.println(list);
        // offerLast()	在列表的末尾插入指定的元素
        list.offerLast(new User(7, "hhd", "0007"));
        System.out.println(list);
        // pollFirst()	检索并删除该列表的第一个元素，如果该列表为空，则返回null
        list.pollFirst();
        System.out.println(list);
        // pollLast()	检索并删除该列表的最后一个元素，如果该列表为空，则返回null。
        list.pollLast();

        System.out.println(list);
        // peek()	检索，但是不删除，这个列表的头(第一个元素)。
		System.out.println(list.peek());
		// peekFirst()		检索，但不删除，该列表的第一个元素，如果该列表为空，则返回null。
		System.out.println(list.peekFirst());
		// peekLast()	检索，但不删除，该列表的最后一个元素，如果该列表为空，则返回null。
		System.out.println(list.peekLast());

		System.out.println(list);
		Iterator<User> descendingIterator = list.descendingIterator();
		Iterator<User> iterator = list.iterator();
		System.out.println("迭代器");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("逆序迭代器");
		while (descendingIterator.hasNext()) {
			System.out.println(descendingIterator.next());
		}
		AbstractSequentialList abstractSequentialList = new AbstractSequentialList() {
			@Override
			public ListIterator listIterator(int i) {
				return null;
			}

			@Override
			public int size() {
				return 0;
			}
		};
	}

    /**
     * 堆栈，先进后出
     *
     * @param list
     */
    public static void stack(LinkedList<User> list) {
        // push 入栈
        list.push(new User(2, "hhd", "0002"));
        System.out.println(list.toString());
        // pop 出栈
        System.out.println(list.pop());
        System.out.println(list.pop());
    }

    /**
     * 队列，先进先出
     *
     * @param list
     */
    public static void quene(LinkedList<User> list) {
        System.out.println(list.toString());
        // 入队
        list.offer(new User(3, "hhd", "0003"));
        list.offer(new User(4, "hhd", "0004"));
        System.out.println(list.toString());
        // 出队
        System.out.println(list.poll());
        System.out.println(list.poll());
    }

    @Test
    public void randomAccessTest() {
        LinkedList<Book> books = new LinkedList<Book>();
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
//        For 循环5163
//        For-Each 循环1342
//        迭代器780
//        特有迭代器648
//        特有迭代器逆序766
    }
}
