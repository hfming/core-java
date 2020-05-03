package com.hfm.collection.set.sortedset.treeset;

import com.hfm.entity.Item;

import java.util.*;

/**
 * @author Cay Horstmann
 * @version 1.12 2012-01-26
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>((a, b) -> {
            String descrA = a.getDescription();
            String descrB = b.getDescription();
            return descrA.compareTo(descrB);
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}