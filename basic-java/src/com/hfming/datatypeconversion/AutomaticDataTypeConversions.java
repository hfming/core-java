package com.hfming.datatypeconversion;

/**
 * 自动数据类型转换
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
    }
}