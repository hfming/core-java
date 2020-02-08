package com.hfming.variable;

/**
 * 变量数据类型 Demo
 *
 * @author hfm
 * @version 1.0.1 2019-09-17
 */
public class Variable {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
         * 整形型变量：byte short int long 四种数据类型
         */

        // byte(字节)
        // 数据大小 8bit
        // 数据容量 2^8=256
        // 数据范围 -128 ~ 127
        byte aByte = 127;
        System.out.println(aByte);

        // short(短整型)
        // 数据大小 16bit
        // 数据容量 2^16=65536
        // 数据范围
        short aShort = 128;
        System.out.println(aShort);

        // int(整型)
        // 数据大小 32bit
        // 数据容量 2^32
        // 数据范围
        int aInt = 65536;
        System.out.println(aInt);

        // long(长整型) 64bit
        // 数据大小 64bit
        // 数据容量 2^64
        // 数据范围
        // 如果一个数据需要表示成一个长整型，那么该数据要以 L结尾
        long aLong = 6557389L;
        System.out.println(aLong);

        /*
         *  小数型变量： float 、double 两种数据类型
         */

        // float(单精度浮点型)  32bit
        // 数据大小 32bit
        // 数据容量 2^32
        // 数据范围
        float aFloat = 3.14F;
        System.out.println(aFloat);

        // double(双精度浮点型) 64bit
        // 数据大小 64bit
        // 数据容量 2^64
        // 数据范围
        double aDouble = 3.14;
        System.out.println(aDouble);

        /*
         * boolean型变量：false、true 两种数据
         */
        // 一个字节或者四个字节，如果boolean用于声明一个基本类型变量时是占四个字节，如果用于声明一个数据类型的时候，那么数组中每个元素占一个字节。
        // 整数值和布尔值之间不能进行相互转换。
        boolean aTrue = true;
        boolean aFlase = false;
        System.out.println(aTrue);
        System.out.println(aFlase);

        /*
         * char型变量
         */
        // 16比特(bit)，16位
        // 两个字节
        // 数据大小 16bit
        // 数据容量 2^16
        // 数据范围
        char aChar = 'i';
        System.out.println(aChar);

        /*
         * 数据范围
         */
        /// 数据范围超过定义的范围会报错
        /// Error:(67, 18) java: 不兼容的类型: 从int转换到byte可能会有损失
        // byte a = 128;
        // System.out.println(a);
    }
}
