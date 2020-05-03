package com.hfm.map.sortedmap.treeMap;

import com.hfm.entity.Person2;

import java.util.Comparator;

public class IdComparator implements Comparator<Person2> {
	@Override
	public int compare(Person2 o1, Person2 o2) {
		return o1.getGmsfhm_dm() - o2.getGmsfhm_dm();
	}
}
