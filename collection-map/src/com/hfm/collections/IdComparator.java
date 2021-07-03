package com.hfm.collections;

import com.hfm.entity.Person3;

import java.util.Comparator;

public class IdComparator implements Comparator<Person3> {
	@Override
	public int compare(Person3 o1, Person3 o2) {
		return o1.getId() - o2.getId();
	}
}
