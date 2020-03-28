package com.hfm.map;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest3 {
	public static void main(String[] args) {
		TreeMap<Person,String> map = new TreeMap<Person,String>(new IdComparator());
		map.put(new Person("330327"),"330327");
		map.put(new Person("330326"),"330326");
		map.put(new Person("330326"),"330326");

		Set<Entry<Person, String>> set = map.entrySet();
		Iterator<Entry<Person, String>>  iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}

	}
}
