package com.hfm.datatypeconversion;

/**
 * 强制数据类型转化：容量大的数据类型转化为容量小的数据类型为强制数据类型转化
 * 特点：代码需要进行特殊的格式处理，不能自动完成。
 * 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;

 * 强制数据类型转换要注意精度损失
 * float 数据类型的容量大于 long 数据类型的容量
 *
 * @author hfm
 * @version 1.1 2019-09-17
 */
public class ForceDataTypeConversion {
    public static void main(String[] args) {
        /// 强制数据类型转化

        byte aByte = 100;
        // b+2 遇到了加法运算，2 默认是 int类型，byte类型 b变量存储的值自动类型提升为了 int类型。执行完加法运算后的结果就是 int类型，想要将 int的类型值放入到 byte类型变量 b中，无法放入，编译报错。
        aByte = (byte) (aByte + 2);
        System.out.println(aByte);

        /// 编译器符号优化
        byte cByte = 123;
        // 不会报错，编译器进行符号优化，只进行一次运算 byte cByte = (byte)(123+1)
        cByte +=1;
        System.out.println(cByte);

        // 当两种类型彼此不兼容，或者目标类型取值范围小于源类型（目标是byte源是 int）无法自动转换，此时就需要进行强制类型转换。
        int aInt = 128;
        byte bByte = (byte) aInt;
        // -128 此时的强转已经造成了数值的不准确
        System.out.println(bByte);

        /// 编译器的常量优化

        short a = 30;
        short b = 40;
        // 编译错误，a 与 b 在进行运算时会进行自动数据类型转换 int
        // short c = a + b;
        // 都是常量时编译器会对常量进行优化
        short c = 30 + 40;
        System.out.println(c);

        // 左边是int类型，右边是long类型，不一样
        // long --> int，不是从小到大
        // 不能发生自动类型转换！
        // 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
        int num = (int) 100L;
        System.out.println(num);

        /// 精度损失,数据溢出

        // long强制转换成为int类型,强制数据类型转换会造成精度损失,数据溢出
        int num2 = (int) 6000000000L;
        // 1705032704
        System.out.println(num2);
        // 没有超出数据范围不会有精度损失
        int a1 = 123;
        byte b1 = (byte) a1;
        System.out.println(b1);

        // double --> int，强制类型转换
        int num3 = (int) 3.99;
        // 这并不是四舍五入，所有的小数位都会被舍弃掉
        System.out.println(num3);

        /// 自动数据类型转化与强制数据类型转换的对比

        // 注意！右侧的数值大小不能超过左侧的类型范围
        byte num4 = 40;
        byte num5 = 50;
        // byte + byte --> int + int --> int
        int result1 = num4 + num5;
        System.out.println(result1);

        short num6 = 60;
        // byte + short --> int + int --> int
        // int强制转换为short：注意必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
        short result2 = (short) (num4 + num6);
        System.out.println(result2);
    }
}
