package com.hfm.collection.list.vector;

import com.hfm.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<User> vector = new  Vector<User>();
		/**
		 * 添加方法
		 */
		// addElement() 添加element元素
		vector.addElement(new User(1,"sa","0001"));
		vector.addElement(new User(2,"sad","0002"));
		// add方法
		vector.add(new User(1, "sa", "0001"));
		// add(index,object)
		vector.add(1,new User(1,"sa","0001"));

		Vector<User> vector2 = new  Vector<User>();
		vector2.add(0,new User(1,"sa","0001"));

		// add(index,collection) 在指定位置添加集合
		vector.addAll(1, vector2);
		System.out.println(vector);

		vector.insertElementAt( new User(0, "sa", "0001"),0);
		System.out.println(vector);

		/**
		 * 获取方法
		 */
		// capacity:Object [] 数组的长度
		System.out.println(vector.capacity());
		// elementAt：指定位置的元素
		System.out.println(vector.elementAt(0));
		// firstElement：第一个元素
		System.out.println(vector.firstElement());
		// lastElement：最后一个元素
		System.out.println(vector.lastElement());
		// get:获取指定位置元素
		System.out.println(vector.get(1));
		// indexOf:第一次出现的位置
		System.out.println(vector.indexOf(new User(0, "sa", "0001")));
		// indexOf(Object o, int index) 返回此矢量中指定元素的第一次出现的索引，从index 中向前搜索，如果找不到该元素，则返回 -1。
		System.out.println(vector.indexOf(new User(0, "sa", "0001"),2));
		// lastIndexOf 最后出现的位置
		System.out.println(vector.lastIndexOf(new User(1, "sa", "0001")));
		// lastIndexOf(Object o, int index)	返回此矢量中指定元素的最后一次出现的索引，从index 向后搜索，如果找不到该元素，则返回 -1。
		System.out.println(vector.lastIndexOf(new User(1, "sa", "0001"),2));
		/**
		 * 修改方法
		 */
		// ensureCapacity：数组底层数组长度
		vector.ensureCapacity(20);
		System.out.println(vector.capacity());
		// setElementAt(E obj, int index)在此矢量的指定index处将组件设为指定对象。
		vector.setElementAt(new User(1, "sa", "0001"),0);
		System.out.println(vector);
		// set(int index, E element)将此矢量中指定位置的元素替换为指定元素。
		vector.set(0,new User(1, "sa", "0001"));
		System.out.println(vector);
		// setSize(int newSize)设置此矢量的大小。
		vector.setSize(30);
		System.out.println(vector.capacity());

		/**
		 * 删除方法
		 */
		vector.remove(new User(1, "sa", "0001"));
		System.out.println(vector);
		// remove(int index)删除此矢量中指定位置的元素。
		vector.remove(0);
		System.out.println(vector);
		// removeElement(Object obj)从此矢量中删除参数的第一个（索引最低的）发生。
		vector.removeElement(new User(1, "sa", "0001"));
		System.out.println(vector);
		// removeElementAt(int index)删除指定索引处的组件。
		vector.removeElementAt(1);
		System.out.println(vector);
		// removeAllElements()从此矢量中删除所有组件并将其大小设置为零。
		vector.removeAllElements();
		System.out.println(vector);

		/**
		 * 迭代器
		 */
		vector.addElement(new User(1,"sa","0001"));
		vector.addElement(new User(2,"sad","0002"));
		ListIterator<User> userListIterator = vector.listIterator();
		while (userListIterator.hasNext()) {
			System.out.println(userListIterator.next());
		}
		while (userListIterator.hasPrevious()) {
			System.out.println(userListIterator.previous());
		}
	}
	private static Vector<Integer> vector=new Vector();
	@Test
	public  void main2() {
		while (true) {
			for (int i = 0; i < 10; i++) {
				//往vector中添加元素
				vector.add(i);
			}
			Thread removeThread = new Thread(() -> {
				//获取vector的大小
				for (int i = 0; i < vector.size(); i++) {
					//当前线程让出CPU,使例子中的错误更快出现
					Thread.yield();
					//移除第i个数据
					vector.remove(i);
				}
			});
			Thread printThread = new Thread(() -> {
				//获取vector的大小
				for (int i = 0; i < vector.size(); i++) {
					//当前线程让出CPU,使例子中的错误更快出现
					Thread.yield();
					//获取第i个数据并打印
					System.out.println(vector.get(i));
				}
			});
			removeThread.start();
			printThread.start();
			//避免同时产生过多线程
			while (Thread.activeCount() > 20) {
			}
		}
	}
}
