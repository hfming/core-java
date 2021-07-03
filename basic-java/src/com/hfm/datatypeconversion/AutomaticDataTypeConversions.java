package com.hfm.datatypeconversion;

/**
 * 自动类型转换（隐式）
 * 特点：代码不需要进行特殊处理，自动完成。
 * 小数据类型可以自动转换位大数据类型，其条件是
 * （1）两种类型彼此兼容。
 * （2）目标类型取值范围必须大于源类型，数据范围从小到大（float 数据范围待遇 弄）
 *
 * @author hfm
 * @version 1.2 2019-09-17
 */
public class AutomaticDataTypeConversions {
    public static void main(String[] args) {
        /// 整形变量自动数据类型转换

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

        /// 小数型数据自动数据类型转换

        float aFloat = 1.0F;
        System.out.println(aFloat);
        // float 型数据自动转换为 double 型数据
        // 左边是double类型，右边是float类型，左右不一样
        // float --> double，符合从小到大的规则
        // 也发生了自动类型转换
        double bDouble = aFloat;
        System.out.println(bDouble);

        /// 整形与小数型数据自动数据类型转换

        // int 型数据自动转换为 float 型数据
        aFloat = aInt;
        System.out.println(aFloat);
        // long 类型可以转化成 float 类型，long 8个字节，float 4个字节，float 数据范围 long 大
        aFloat = aLong;
        System.out.println(aFloat);
        // long 型数据自动转换为 double 型数据
        bDouble = aLong;
        System.out.println(bDouble);

        // 编译错误，小数型数据不能够自动转换位整形数据
        // aInt = aFloat;

        // 左边是 float 类型，右边是 long 类型，左右不一样
        // long --> float，范围是 float 更大一些，符合从小到大的规则
        // 也发生了自动类型转换
        float num3 = 30L;
        // 30.0
        System.out.println(num3);
    }
}