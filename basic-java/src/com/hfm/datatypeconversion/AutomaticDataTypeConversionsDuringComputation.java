package com.hfm.datatypeconversion;

/**
 * 运算时自动数据类型转化
 * 注意事项：
 * 1. 强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出。
 * 2. byte/short/char这三种类型都可以发生数学运算，例如加法“+”.
 * 3. byte/short/char这三种类型在运算的时候，都会被首先提升成为int类型，然后再计算。
 * 4. boolean类型不能发生数据类型转换
 * @author hfm
 * @version 1.01 2020-04-10 17:09
 * @date 2020/4/10
 */
public class AutomaticDataTypeConversionsDuringComputation {
    public static void main(String[] args) {
        /// char 型数据在运算是也会进行自动数据类型转换
        // char 型数据在运算时自动主动转化为 int 数据，不会转化为其他数据类型
        char zifu1 = '1';
        // 49
        System.out.println(zifu1 + 0);
        // 其实底层保存的是65数字
        char zifu2 = 'A';
        char zifu3 = 'c';
        // 左侧是int类型，右边是char类型，
        // char --> int，确实是从小到大
        // 发生了自动类型转换
        int num = zifu3;
        // 99
        System.out.println(num);
        // 正确写法
        char zifu4 = '中';
        // 20013
        System.out.println(zifu4 + 0);

        char c1 = 'a';
        short s1 = 123;
        short s2 = 10;
        byte b1 = 2;
        byte b2 = 10;

        // char c2 = c1+s2; // 编译不通过
        // char c2 = c1+b2; // 编译不通过
        // short s3 = b2+s2; // 编译不通过
        // short s3 = b1+b2; // 编译不通过

        /// byte, short 数据类型运算时自动转换为 int 数据类型
        byte abyte = 125;
        // 编译错误，byte 数据类型自动转化为 int 数据类型，需要进行强制数据类型转换才能够赋值该byte 数据类型
        // byte byte1 = abyte +1;

        /// 其他数据类型与String 数据类型连接时自动转化为 String 数据类型
        // + 作为字符串拼接符号
        int no = 10;
        String str = "abcdef";
        System.out.println("str = " + str);
        String str1 = str + "xyz" + no;
        System.out.println("str = " + str1);
        str1 = str1 + "123";
        System.out.println("str1 = " + str1);

        char c = '国';
        double pi = 3.1416;
        str1 = str1 + pi;
        System.out.println("str1 = " + str1);

        boolean b = false;
        str1 = str1 + b;
        System.out.println("str1 = " + str1);
        str1 = str1 + c;
        System.out.println("str1 = " + str1);
    }
}
