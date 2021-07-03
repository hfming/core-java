package com.hfm.collection.list.abstractsquentiallist;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-11 14:59
 * @Description
 * @date 2021/6/11
 */
public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // 增加
        singlyLinkedList.add(10);
        singlyLinkedList.add(20);
        singlyLinkedList.add(30);
        singlyLinkedList.add(40);
        singlyLinkedList.add(50);
        singlyLinkedList.add(60);
        singlyLinkedList.add(0, 1111);
        singlyLinkedList.add(7,9999);

        System.out.println(singlyLinkedList);

        // 删除
        singlyLinkedList.remove(0);
        singlyLinkedList.remove(4);
        System.out.println(singlyLinkedList);

        // 查找
        System.out.println(singlyLinkedList.indexOf(50));

        // 修改
        singlyLinkedList.set(2, 110);
        System.out.println(singlyLinkedList);

        // 清空
        singlyLinkedList.clean();
        System.out.println(singlyLinkedList);
    }
}
