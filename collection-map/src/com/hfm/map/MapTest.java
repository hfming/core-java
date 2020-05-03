package com.hfm.map;

import java.util.*;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		// put 加入map 集合中
		map.put("霆锋", "张柏芝");
		map.put("文章", "马伊琍");
		map.put("汪峰", "章子怡");
		map.put("奥巴马", "凤姐");
		System.out.println(map);

		Map<String,String> map2 = new HashMap<String, String>();
		map2.put("习总", "彭丽媛");
		map2.put("奥巴马", "凤姐");
		System.out.println(map2);
		map.putAll(map2);
		System.out.println(map);

		// 如果指定的键还没有与一个值相关联，那么将它与给定的值关联起来。
		map.putIfAbsent("hfm", "hfm");
		System.out.println(map);

		//清除 map 集合中所有
		 map2.clear();
		System.out.println(map2);

		// 根据键删除一条数据， 返回是该键对应的值
		System.out.println("被删除的数据："+ map.remove("奥巴马"));
		System.out.println(map);
		//判断
		System.out.println("判断是否存在指定的键："+ map.containsKey("奥巴马"));
		System.out.println("判断是否存在指定的值："+ map.containsValue("凤姐"));
		System.out.println("判断集合是否为空元素："+ map.isEmpty());
		//获取
		System.out.println("根据值获取对应的值："+ map.get("霆锋"));
		System.out.println("查看 map 集合的元素个数："+ map.size());
		/**
		 * 迭代
		 */
		//对key进行遍历
		Set set =  map.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		//对value进行迭代遍历
		Collection  list = map.values();
		Iterator iterator2 = list.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next().toString());
		}
		//entrySet
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator iterator3 = entrySet.iterator();
		while(iterator3.hasNext()){
			System.out.println(iterator3.next().toString());
		}

		// 根据已有 map 集合创建新map 集合
		HashMap<String, String> user = new HashMap<>(map);
		System.out.println(user);
	}
}
