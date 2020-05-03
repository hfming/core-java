package com.hfm.map.sortedmap.treeMap;

		import com.hfm.entity.Person2;

		import java.util.Iterator;
		import java.util.Map.Entry;
		import java.util.Set;
		import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Person2,String> map = new TreeMap<Person2,String>(new IdComparator());
		map.put(new Person2("330327"),"330327");
		map.put(new Person2("330326"),"330326");
		map.put(new Person2("330326"),"330326");
		map.put(new Person2("330322"),"330326");
		map.put(new Person2("330321"),"330326");
		map.put(new Person2("330320"),"330326");

		Set<Entry<Person2, String>> set = map.entrySet();
		Iterator<Entry<Person2, String>>  iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
