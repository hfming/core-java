package com.hfming.operators;

/**
 * 比较运算符
 * 注意事项：
 * 1. 比较运算符的结果一定是一个boolean值，成立就是true，不成立就是false
 * 2. 如果进行多次判断，不能连着写。
 *
 * @author hfm
 * @version 1.1 2019-09-17
 */
public class ComparisonOperator {
    public static void main(String[] args) {
        int aInt = 10;
        int bInt = 8;
        // 大于
        System.out.println(aInt > bInt);
        // 小于
        System.out.println(aInt < bInt);
        // 等于 = 号为赋值
        System.out.println(aInt == bInt);
        // 大于等于
        System.out.println(aInt >= bInt);
        // 小于等于
        System.out.println(aInt <= bInt);

        System.out.println("相等吗？" + (1 == 2));
        System.out.println("不相等吗？" + (1 != 2));
        // 两个不同数据类型,但是数据类型是兼用的数据在比较的时候，小的数据类型数据会自动转换成大数据类型然后再比较。
        long aLong = 10L;
        int cInt = 9;
        System.out.println("不同数据类型的数据比较：" + (aLong > cInt));
        // 比较运算时,数据类型要一致或者能够进行自动数据类型转换
        // boolean型数据不能强制转化为其他数据
        // System.out.println(true > 1);
    }
}
