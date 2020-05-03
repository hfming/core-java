package com.hfm.recursion;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 计算1 ~ n的和
 * 分析：num的累和 = num + (num-1)的累和，所以可以把累和的操作定义成一个方法，递归调用。
 * @date 2020-05-03 10:49
 */
public class RecurusionAdd {
    public static void main(String[] args) {
        // 计算1~num的和，使用递归完成
        int num = 5;
        // 调用求和的方法
        int sum = getSum(num);
        // 输出结果
        System.out.println(sum);
        // 不用递归的算法
        System.out.println(getSum2(num));
    }

    /**
     * 通过递归算法实现.
     * 参数列表:int
     * 返回值类型: int
     */
    public static int getSum(int num) {
        /**
         num为1时,方法返回1,
         相当于是方法的出口,num总有是1的情况
         */
        if (num == 1) {
            return 1;
        }
        /**
         num不为1时,方法返回 num +(num‐1)的累和
         递归调用getSum方法
         */
        return num + getSum(num - 1);
    }

    public static int getSum2(int num) {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}
