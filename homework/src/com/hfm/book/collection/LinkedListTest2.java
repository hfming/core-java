package com.hfm.book.collection;

import java.util.*;

/**
 * 这个程序演示了链表上的操作。
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class LinkedListTest2 {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        // 把b和a合并
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);
        // 删除b中的每两个单词
        bIter = b.iterator();
        while (bIter.hasNext()) {
            // 跳过一个元素
            bIter.next();
            if (bIter.hasNext()) {
                // 跳过一个元素
                bIter.next();
                // 删除元素
                bIter.remove();
            }
        }
        System.out.println(b);
        // 批量操作:从a中删除b中的所有单词
        a.removeAll(b);
        System.out.println(a);
    }
}
