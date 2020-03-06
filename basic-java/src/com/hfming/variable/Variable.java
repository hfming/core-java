package com.hfming.variable;

/**
 * 变量数据类型 Demo
 *
 * @author hfm
 * @version 1.0.1 2019-09-17
 */
public class Variable {
    /**
     * 变量：程序运行期间，内容可以发生改变的量。
     * <p>
     * 使用变量的时候，有一些注意事项：
     * 1. 如果创建多个变量，那么变量之间的名称不可以重复。
     * 2. 对于float和long类型来说，字母后缀F和L不要丢掉。
     * 3. 如果使用byte或者short类型的变量，那么右侧的数据值不能超过左侧类型的范围。
     * 4. 没有进行赋值的变量，不能直接使用；一定要赋值之后，才能使用。
     * 5. 变量使用不能超过作用域的范围。【作用域】：从定义变量的一行开始，一直到直接所属的大括号结束为止。
     * 6. 可以通过一个语句来创建多个变量，但是一般情况不推荐这么写。
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
        System.out.println(aChar + 1);

        /*
         * 数据范围
         */
        /// 数据范围超过定义的范围会报错
        /// Error:(67, 18) java: 不兼容的类型: 从int转换到byte可能会有损失
        // byte a = 128;
        // System.out.println(a);

        /*
         * 数据传递
         */
        // 将一个变量的数据内容，赋值交给另一个变量
        // 右侧的变量名称var1已经存在，里面装的是false布尔值
        // 将右侧变量里面的false值，向左交给var2变量进行存储
        boolean var1 = true;
        boolean var2 = var1;
        System.out.println(var2);
    }
}
