package com.hfm.controlprocess;

/**
 * for 循环语句
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class For {
    public static void main(String[] args) {
        // 需求；想要打印 5 次 helloworld
        for (int x = 0; x < 5; x++) {
            System.out.println("Hello World!");
        }

        int y = 0;
        while (y < 5) {
            System.out.println("hello world");
            y++;
        }
        // 编译错误，解释x为什么会找不到,注意了变量的作用域,也就是变量的作用范围。x只在 for循环的大括号内有效,出了这个区域，就无效了.在内存中就消失了。x消失后,仍要访问它,肯定会报错的。y就不一样了，y是定义在while外的。while循环完毕仍有效 while的初始化 动作在外边，循环结束后 y仍然存在。当定义的 y只作为循环增量存在的话的，循环完毕后y就没有用了，但是 y还是占着一块内存。所以，如果定义的变量只作为循环增量存在的话，就用 for循环可以节约内存。其实 for 和 while是可以互换的。
        // System.out.println(x);
        System.out.println(y);

        // 获取 1-10 的和，并打印。
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 1-100 之间 7 的倍数的个数,并打印
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                result++;
            }
        }
        System.out.println(result);

        // 需求： 在控制台上打印一个矩形。
        // j=0 , j=1 ---> 行数
        for (int j = 0; j < 4; j++) {
            // i=0, 1 ,2 ,3,4,5 . 6 ---> 列数
            for (int i = 0; i < 6; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 需求：打印一个正立的直角三角形。
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 使用 for 循环语句打印一个倒立的直角三角形。
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 需求 2： 打印一个九九乘法。
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }

        // 计算 1~100 偶数的总和
        sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
