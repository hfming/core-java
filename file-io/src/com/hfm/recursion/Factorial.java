package com.hfm.recursion;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description n的阶乘：n! = n * (n‐1) *...* 3 * 2 * 1
 * 分析：这与累和类似,只不过换成了乘法运算，学员可以自己练习，需要注意阶乘值符合int类型的范围。
 * 推理得出：n! = n * (n‐1)!
 * @date 2020-05-03 10:58
 */
public class Factorial {
    /**
     * 计算n的阶乘，使用递归完成
     */
    public static void main(String[] args) {
        int n = 3;
        // 调用求阶乘的方法
        int value = getValue(n);
        // 输出结果
        System.out.println("阶乘为:" + value);

        // 不使用递归
        System.out.println("阶乘为:" + getValue2(n));
    }

    /**
     * 通过递归算法实现.
     * 参数列表:int
     * 返回值类型: int
     */
    public static int getValue(int n) {
        // 1的阶乘为1
        if (n == 1) {
            return 1;
        }
        /**
         n不为1时,方法返回 n! = n*(n‐1)!
         递归调用getValue方法
         */
        return n * getValue(n - 1);
    }

    /**
     * 不使递归
     *
     * @param num
     * @return
     */
    public static int getValue2(int num) {
        int sum = 1;
        for (int i = num; i >= 1; i--) {
            sum *= i;
        }
        return sum;
    }
}
