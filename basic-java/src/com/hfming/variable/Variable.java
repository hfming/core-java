package com.hfming.variable;

/**
 * 变量
 *
 * @author hfm
 * @version 1.0.1 2019-09-17
 */
public class Variable {
    public static void main(String[] args) {
        /**
         * 整形
         */
        // byte(字节) 8bit 2^8=256 -128 ~ 127
        byte aByte = 127;
        System.out.println(aByte);
        // short(短整型) 16bit 2^16=65536
        short aShort = 128;
        System.out.println(aShort);
        // int(整型) 32bit
        int aInt = 65536;
        System.out.println(aInt);
        // long(长整型) 64bit
        // 如果一个数据需要表示成一个长整型，那么该数据要以 L结尾
        long aLong = 6557389L;
        System.out.println(aLong);

        /**
         *  小数
         */
        // float(单精度浮点型)  32bit
        float aFloat = 3.14F;
        System.out.println(aFloat);
        // double(双精度浮点型) 64bit
        double aDouble = 3.14;
        System.out.println(aDouble);

        /**
         * boolean
         */
        boolean aTrue = true;
        boolean aFlase = false;
        System.out.println(aTrue);
        System.out.println(aFlase);

        /**
         * char
         */
        char aChar = 'i';
        System.out.println(aChar);

        /**
         *  两种初始化方法
         */
        // 静态初始化
        int way1 = 15;
        // 动态初始胡
        int way2;
        way2 = 16;
        System.out.println(way1);
        System.out.println(way2);

        /**
         * 数据范围
         */
        // 数据范围超过定义的范围会报错
        // Error:(67, 18) java: 不兼容的类型: 从int转换到byte可能会有损失
        //byte a = 128;
        //System.out.println(a);
    }
}
