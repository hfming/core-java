package com.hfm.collection.set.treeset;

import cn.hfming.entity.People;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<People> treeSet = new TreeSet<People>();
		treeSet.add(new People("001", "fs", 12));
		System.out.println(treeSet.toString());
		treeSet.add(new People("001", "fs", 12));
		System.out.println(treeSet.toString());
		treeSet.add(new People("002", "fs", 12));
		System.out.println(treeSet.toString());

		//自定义比较器，再传入比较器给集合
		TreeSet ts = new TreeSet(new IdComparator());

		ts.add(new People("001", "fs", 12));
		ts.add(new People("001", "fs", 12));
		System.out.println(ts.toString());

		TreeSet tree = new TreeSet();
		tree.add("abaaaa");
		tree.add("ac");
		tree.add("cab");
		System.out.println(tree);
		System.out.println("aba".compareTo("ab"));
		System.out.println("aab".compareTo("aa"));
		TreeSet tree1 = new TreeSet();
		tree1.add("10");
		tree1.add("2");
		tree1.add("19");
		System.out.println(tree1);

	}
	public static String sortString(String str){
		TreeSet tree = new TreeSet();
		//切割字符串得到字符串的数字
		String[] datas = str.split(" ");
		for(int i = 0 ; i<datas.length ; i++){
			//把字符串转成 int 类型的数字，添加到 treeset 集合中,让 TreeSet 集合自动帮我们进行排序。
			int num = Integer.parseInt(datas[i]);
			tree.add(num);
		}
		//遍历 TreeSet 的元素,具有自然属性，可以进行比较
		StringBuilder sb = new StringBuilder();
		Iterator it = tree.iterator();
		while(it.hasNext()){
			sb.append(it.next()+" ");
		}
		return sb.toString();
	}
}
