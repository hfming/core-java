package com.hfm.controlprocess;

/**
 * @author hfm
 * @version 1.01 2020-04-01 19:58
 * @date 2020/4/1
 */
public class ContinueTest {
    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
