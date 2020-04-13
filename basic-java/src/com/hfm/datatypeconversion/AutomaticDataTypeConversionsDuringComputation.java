package com.hfm.datatypeconversion;

/**
 * 运算时东数据类型转化
 *
 * @author hfm
 * @version 1.01 2020-04-10 17:09
 * @date 2020/4/10
 */
public class AutomaticDataTypeConversionsDuringComputation {
    public static void main(String[] args) {
        /// char 型数据在运算是也会进行自动数据类型转换
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

        /// byte, short 数据类型运算时东转换为 int 数据类型
        byte abyte = 125;
        // 编译错误，byte 数据类型自动转化为 int 数据类型，需要进行强制数据类型转换才能够赋值该byte 数据类型
        // byte byte1 = abyte +1;

        /// 其他数据类型与String 数据类型连接时自动转化为 String 数据类型
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
