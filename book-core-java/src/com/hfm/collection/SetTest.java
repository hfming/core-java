package com.hfm.collection;

import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class SetTest {
    public static void main(String[] args) {
        // HashSet implements Set
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
