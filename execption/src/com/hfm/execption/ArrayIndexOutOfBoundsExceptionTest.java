package com.hfm.execption;

/**
 * @author hfm
 * @version 1.01 2020-04-07 22:05
 * @date 2020/4/7
 */
public class ArrayIndexOutOfBoundsExceptionTest {
    public static void main(String[] args) {
        String friends[] = {"lisa", "bily", "kessy"};
        for (int i = 0; i < 5; i++) {
            // friends[4]?
            System.out.println(friends[i]);
        }
        System.out.println("\nthis is the end");
    }
}
