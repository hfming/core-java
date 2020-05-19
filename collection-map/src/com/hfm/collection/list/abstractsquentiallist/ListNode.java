package com.hfm.collection.list.abstractsquentiallist;

public class ListNode {
    int val;
    /**
     * 内部维护了一个该类的对象，但是没有初始化，不能够使用
     */
    ListNode next;

    /**
     * 构造函数
     *
     * @param x
     */
    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l3 = l1.next;
        int i = l1.val;

        System.out.println(i);
    }
}