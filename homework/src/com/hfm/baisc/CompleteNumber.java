package com.hfm.baisc;

/**
 * 练习:一个数如果恰好等于它的因子之和，这个数就称为"完数"（因子：除去这个数本身正的约数）
 * 例如6=1＋2＋3.编程 找出1000以内的所有完数
 *
 * @author hfm
 * @version 1.01 2020-03-19 12:27
 * @date 2020/3/19
 */
public class CompleteNumber {
    static int count;

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            int factor = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    factor += j;
                }
            }
            if (factor == i) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("1-1000之间的完数个数为：" + count);

    }
}
