package com.hfm.baisc;

/**
 * 练习:自增运算
 *
 * @author hfm
 * @version 1.01 2020-03-18 21:19
 * @date 2020/3/18
 */
public class AutoincrementTest {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
    }

    private static void test4() {
        int a = 3, b = 8;
        int c = (a > b) ? a++ : b++;
        System.out.println("a=" + a + "\tb=" + b + "\tc=" + c);

        int d = (a > b) ? ++a : ++b;
        System.out.println("a=" + a + "\tb=" + b + "\td=" + d);

        int e = (a < b) ? a++ : b++;
        System.out.println("a=" + a + "\tb=" + b + "\te=" + e);

        int f = (a < b) ? ++a : ++b;
        System.out.println("a=" + a + "\tb=" + b + "\tf=" + f);
    }

    private static void test3() {
        int x = 0, y = 1;
        if (++x == y-- & x++ == 1 || --y == 0) {
            // x = 2,y = 0;
            System.out.println("x=" + x + ",y=" + y);
        } else {
            System.out.println("y=" + y + ",x=" + x);
        }
    }

    private static void test2() {
        int i1 = 10;
        int i2 = 20;
        int i = i1++;
        System.out.print("i=" + i);
        System.out.println("i=" + i1);
        i = ++i1;
        System.out.print("i=" + i);
        System.out.println("i=" + i1);
        i = i2--;
        System.out.print("i=" + i);
        System.out.println("i2=" + i2);
        i = --i2;
        System.out.print("i=" + i);
        System.out.println("i2=" + i2);
    }

    private static void test1() {
        int i = 0;
        System.out.println("自增之前i=" + i);
        i++;
        System.out.println("自增第一次之后i=" + i);
        ++i;
        System.out.println("自增第二次之后i=" + i);
        // 把i自增1，然后结果赋值给j，或者说，先算++i，然后再赋值
        int j = ++i;
        System.out.println("自增第三次之后i=" + i);
        System.out.println("j=" + j);
        // 先算赋值，把i的值赋值给k，i原来是3，把3赋值给k，然后i在自增1，i变成4
        int k = i++;
        System.out.println("自增第四次之后i=" + i);
        System.out.println("k=" + k);

        // 面试题：陷阱题
        // 先赋值，把i原来的值重新赋值给i，不变，然后i自增，但是这个自增后的值没有在放回变量i的位置
        i = i++;
        System.out.println("自增第五次之后i=" + i);
    }
}
