package com.hfm.collection.list.vector;

import com.hfm.entity.User;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<User> vector = new  Vector<User>();
		vector.addElement(new User(1,"sa","0001"));
		vector.addElement(new User(2,"sad","0002"));

		System.out.println(vector.capacity());	//Object [] 数组的长度
		
		System.out.println(vector.elementAt(0));
		System.out.println(vector.firstElement());
		System.out.println(vector.lastElement());
		
		vector.ensureCapacity(10);
		System.out.println(vector.capacity());
	}
}
