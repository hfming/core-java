package com.hfm.operators;

/**
 * 赋值运算符
 * 注意事项：
 * 1. 只有变量才能使用赋值运算符，常量不能进行赋值。
 * 2. 复合赋值运算符其中隐含了一个强制类型转换。
 *
 * @author hfm
 * @version 1.1 2019-09-17
 */
public class AssigningOperator {
    public static void main(String[] args) {
        int aInt = 10;
        // 加等于
        System.out.println(aInt += 10);
        // 减等于
        System.out.println(aInt -= 10);
        // 赋值
        System.out.println(aInt = 10);
        // 除等于
        System.out.println(aInt /= 10);
        // 乘等于
        System.out.println(aInt *= 10);
        // 模等于
        System.out.println(aInt %= 3);

        // 比较 == 号与 赋值运算符 = 号的不同
        // 基本数据类型 = 传递数值
        System.out.println(aInt = 1);
        // 引用数据类型 = 传递内存地址
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(arr = new int[]{4, 5, 6, 7});

        // 基本数据类型 == 号比较大小
        System.out.println(aInt == 0);
        // 引用数据类型== 号 比较内存地址
        System.out.println(arr == new int[]{4, 5, 6, 7});

        // 练习
        int m = 2;
        int n = 3;
        // n = n * m++;
        n *= m++;
        // 3
        System.out.println("m=" + m);
        // 6
        System.out.println("n=" + n);

        // 练习
        int n1 = 10;
        n1 += (n1++) + (++n1);
        // 32
        System.out.println(n1);

        int n2 = 10;
        n2 += n2++;
        // 20
        System.out.println(n2);

        int n3 = 10;
        n3 += (++n3);
        // 21
        System.out.println(n3);

        int n4 = 10;
        n4 += (++n4) + (n4++);
        // 32
        System.out.println(n4);
    }
}
