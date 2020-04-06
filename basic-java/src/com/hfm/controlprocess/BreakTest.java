package com.hfm.controlprocess;

/**
 * @author hfm
 * @version 1.01 2020-04-01 19:53
 * @date 2020/4/1
 */
public class BreakTest {
    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(" i =" + i);
        }
        System.out.println("Game Over!");
    }
}
