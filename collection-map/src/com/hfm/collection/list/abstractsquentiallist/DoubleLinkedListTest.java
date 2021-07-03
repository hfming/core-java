package com.hfm.collection.list.abstractsquentiallist;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-11 11:07
 * @Description 双向链表
 * @date 2021/6/11
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        // 添加
        doubleLinkedList.add(10);
        doubleLinkedList.add(20);
        doubleLinkedList.add(30);
        doubleLinkedList.add(40);
        doubleLinkedList.add(0,1111);
        doubleLinkedList.add(5, 99999);

        System.out.println(doubleLinkedList);

        // 删除
        doubleLinkedList.remove(2);
        doubleLinkedList.remove(0);
        doubleLinkedList.remove(3);
        System.out.println(doubleLinkedList);

        // 设置
        doubleLinkedList.set(1, 333333);
        System.out.println(doubleLinkedList);

        // 查询
        System.out.println(doubleLinkedList.indexOf(333333));

        // 清空
        doubleLinkedList.clean();
        System.out.println(doubleLinkedList);
    }
}