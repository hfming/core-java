package com.hfm.collection.list.abstractsquentiallist;

import cn.hfming.entity.User;
import java.util.LinkedList;

/**
 * LinkedList集合测试
 * 
 * @author hfm
 *@version 1.01 2019-10-18
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<User> list = new LinkedList<User>();
		list.add(new User(1, "hhd", "0001"));
		stack(list);
		quene(list);
		System.out.println(list.toString());
		list.addFirst(new User(7, "hhd", "0007"));
		System.out.println(list.getFirst());
		list.addLast(new User(8, "hhd", "0008"));
		System.out.println(list.getLast());
	}

	/**
	 * 堆栈，先进后出
	 * 
	 * @param list
	 */
	public static void stack(LinkedList<User> list) {
		list.push(new User(2, "hhd", "0002"));
		System.out.println(list.toString());
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
		list.offer(new User(3, "hhd", "0003"));
		list.offer(new User(4, "hhd", "0004"));
		System.out.println(list.toString());
		System.out.println(list.poll());
		System.out.println(list.poll());
	}
}
