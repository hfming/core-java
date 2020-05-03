package com.hfm.collection.queue;

import java.util.*;

/**
 * 这个程序演示了优先队列的使用。
 *
 * @author Cay Horstmann
 * @version 1.01 2012-01-26
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        // G. Hopper
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
        // A. Lovelace
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
        // J. von Neumann
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
        // K. Zuse
        pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));

        System.out.println("Iterating over elements...");
        for (GregorianCalendar date : pq) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Removing elements...");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().get(Calendar.YEAR));
        }
    }
}
