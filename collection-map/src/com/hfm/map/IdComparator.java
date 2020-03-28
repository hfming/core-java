package com.hfm.map;

import java.util.Comparator;

public class IdComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getGmsfhm_dm() - o2.getGmsfhm_dm();
	}
}
