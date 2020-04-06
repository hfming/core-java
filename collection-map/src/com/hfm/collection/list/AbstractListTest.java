package com.hfm.collection.list;

import com.hfm.entity.User;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * list集合特有方法
 * @author hfm
 * @version 1=2019-10-18
 */
public class AbstractListTest {

	public static void main(String[] args) {
		/**
		 * 添加
		 * 		void add(int index, E element) 指定位置添加元素
		 * 		boolean addAll(int index, Collection c) 指定位置添加集合
		 */
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(0001,"hfm","0001"));
		users.add(new User(0002,"trt","0002"));
		users.add(new User(0003,"dsd","0003"));
		System.out.println(users.toString());

		User user = new User(0004, "trt", "0004");

		//add(int index, E element) 指定位置添加元素
		users.add(2, user);
		System.out.println(users.toString());

		ArrayList<User> users2 = new ArrayList<User>();
		users2.add(new User(0005,"yfg","0005"));

		//  addAll(int index, Collection<? extends E> c) 将指定集合中的所有元素插入到此列表中的指定位置（可选操作）。
		users.addAll(1,users2);
		System.out.println(users.toString());

		/**
		 * 删除
		 * 		E remove(int index) 删除指定位置元素
		 * 		retainAll(Collect ) 只保留该列表中包含在指定集合中的元素(可选操作)。
		 */
		// E remove(int index) 删除指定位置元素
		users.remove(1);
		System.out.println(users.toString());

		// retainAll(Collect ) 只保留该列表中包含在指定集合中的元素(可选操作)。
		users.retainAll(users);
		System.out.println(users.toString());
		/**
		 * 	修改
		 * 		E set(int index, E element)返回的是需要替换的集合中的元素
		 */
		// E set(int index, E element)返回的是需要替换的集合中的元素
		//users.set(0, new User(0006,"fsd","0006"));
		//System.out.println(users);
		/**
		 *	查找
		 * 		E get(int index) 注意： IndexOutOfBoundsException
		 * 		int indexOf(Object o) // 找不到返回-1
		 * 		lastIndexOf(Object o)
		 */
		users.add(new User(0001,"hfm","0001"));
		users.add(new User(0002,"trt","0002"));
		users.add(new User(0003,"dsd","0003"));

		// E get(int index) 注意： IndexOutOfBoundsException
		System.out.println(users.get(0).toString());
		// 首次出现的位置
		System.out.println(users.indexOf(new User(0002,"trt","0002")));
		// 最后出现的位置
		System.out.println(users.lastIndexOf(new User(0002,"trt","0002")));

		// subList(int fromIndex, int toIndex)	返回此列表中指定的 fromIndex（含）和 toIndex之间的视图。
		//ArrayList newUsers = (ArrayList) users.subList(0,2);
		//System.out.println(newUsers);


		// 迭代器listIterator
		ListIterator iterator = users.listIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		// 逆序迭代
		while(iterator.hasPrevious()){
			System.out.println(iterator.previous().toString());
		}
	}
}
