package com.hfm.book.basic;

/**
 * 这个程序向读者显示问候语。
 *
 * @author Cay Horstmann
 * @version 1.30 2014-02-27
 */
public class Welcome {
    public static void main(String[] args) {
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
