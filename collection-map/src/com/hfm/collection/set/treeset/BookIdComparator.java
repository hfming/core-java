package com.hfm.collection.set.treeset;

import cn.hfming.entity.Book;
import java.util.Comparator;

public class BookIdComparator implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getId() - o2.getId();
	}
}
