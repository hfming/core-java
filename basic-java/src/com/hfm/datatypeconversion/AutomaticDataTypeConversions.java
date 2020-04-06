package com.hfm.datatypeconversion;

/**
 * 自动类型转换（隐式）
 * 1. 特点：代码不需要进行特殊处理，自动完成。
 * 2. 规则：数据范围从小到大
 *
 * @author hfm
 * @version 1.2 2019-09-17
 */
public class AutomaticDataTypeConversions {
    /**
     * 小数据类型可以自动转换位大数据类型，其条件是
     * （1）两种类型彼此兼容。
     * （2）目标类型取值范围必须大于源类型。
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
         * 整形变量自动数据类型转换
         */
        // 00000001
        byte aByte = 1;
        System.out.println(aByte);
        // 00000000 00000001 byte 数据类型自动转化为 short 数据类型
        short aShort = aByte;
        System.out.println(aShort);
        // short 数据类型自动转化为 int 数据类型
        int aInt = aShort;
        System.out.println(aInt);
        // Int 数据类型自动转化为 Long 数据类型
        // 左边是long类型，右边是默认的int类型，左右不一样
        // 一个等号代表赋值，将右侧的int常量，交给左侧的long变量进行存储
        // int --> long，符合了数据范围从小到大的要求
        // 这一行代码发生了自动类型转换。
        long aLong = aInt;
        System.out.println(aLong);

        // 在赋值时 long 数据类型自动转化为 Double 数据类型
        double aDouble = aLong;
        System.out.println(aDouble);

        /*
         * 小数型数据自动数据类型转换
         */
        float aFloat = 1.0F;
        System.out.println(aFloat);
        // float 型数据自动转换为 double 型数据
        // 左边是double类型，右边是float类型，左右不一样
        // float --> double，符合从小到大的规则
        // 也发生了自动类型转换
        double bDouble = aFloat;
        System.out.println(bDouble);

        /*
         * 整形与小数型数据自动数据类型转换
         */
        // int 型数据自动转换为 float 型数据
        aFloat = aInt;
        System.out.println(aFloat);
        // long 型数据自动转换为 double 型数据
        bDouble = aLong;
        System.out.println(bDouble);

        // 小数型数据不能够自动转换位整形数据
        // aInt = aFloat;

        // 左边是float类型，右边是long类型，左右不一样
        // long --> float，范围是float更大一些，符合从小到大的规则
        // 也发生了自动类型转换
        float num3 = 30L;
        // 30.0
        System.out.println(num3);

        /**
         * 数字和字符的对照关系表（编码表）：
         * ASCII码表：American Standard Code for Information Interchange，美国信息交换标准代码。
         * Unicode码表：万国码。也是数字和符号的对照关系，开头0-127部分和ASCII完全一样，但是从128开始包含有更多字符。
         * 48 - '0'
         * 65 - 'A'
         * 97 - 'a'
         */
        // char 型数据在运算是也会进行自动数据类型转换
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

        // 其他数据类型与String 数据类型连接时自动转化为 String数据类型
        int no = 10;
        String str = "abcdef";
        String str1 = str + "xyz" + no;

        str1 = str1 + "123";
        char c = '国';
        double pi = 3.1416;
        str1 = str1 + pi;
        boolean b = false;
        str1 = str1 + b;
        str1 = str1 + c;
        System.out.println("str1 = " + str1);
    }
}