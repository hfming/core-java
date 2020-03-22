package com.hfm.operators;

/**
 * 移位运算符
 *
 * @author hfm
 * @version 1.1 2019-09-17
 */
public class ShiftOperator {
    public static void main(String[] args) {
        // 00000000  00000000  00000000  00000011      3
        // 00000000  00000000  00000000  000011        移位
        // 00000000  00000000  00000000  00001100      低位补 0
        // 12 6*2(1) = 12
        System.out.println(6 << 1);
        // 24 6*2(2) = 24
        System.out.println(6 << 2);
        // 48 6*2(3) = 48
        System.out.println(6 << 3);
        // 3 6/2(1) = 3
        System.out.println(6 >> 1);
        // 00000000  00000000  00000000  00000110  6
        //   000000  00000000  00000000  00000001  右移10被砍掉
        // 00000000  00000000  00000000  00000001  高位补0
        // 1 6/2(2) = 1
        System.out.println(6 >> 2);
        // 0 6/2(3) = 0
        System.out.println(6 >> 3);

        // 那么使用>> 后原来是最高位 1 的那么空出来的最高位还是 1 的，是 0 的还是 0.如果使用>>> 无论最高位是 0 还是 1 空余最高位都拿 0 补,这就是无符号右移。
        // -1 >> 右移时高位补什么要按照原有数据的最高位来决定。
        System.out.println(-6 >> 3);
        // -48
        System.out.println(-6 << 3);
        // 536870911 使用>>> 无论最高位是 0 还是 1 空余最高位都拿 0 补,这就是无符号右移。
        System.out.println(-6 >>> 3);
        // 0
        System.out.println(6 >>> 3);
        // 0
        System.out.println(6 >> 3);
        // 48
        System.out.println(6 << 3);
    }
}
