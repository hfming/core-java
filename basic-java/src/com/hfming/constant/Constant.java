package com.hfming.constant;

/**
 * 常量 Demo
 *
 * @author hfm
 * @version 1.2 2020-01-14
 */
public class Constant {
    /**
     * 常量通常定于在类之内方法之外
     * 常量是指在程序运行过程中其值不能改变的量
     * 常量都是大写,单词与单词之间用下划线 _ 隔开，并用 final 进行修饰
     */

    // 整数常量
    // byte short int long 四种整数常量
    private final static int INTEGER = 1;
    private final static byte BYTE = 2;
    private final static short SHORT = 3;
    private final static long LONG = 4L;

    // 小数常量
    // float double 两种浮点型常量
    private final static double DECIMALS = 3.14;
    private final static float FLOAT = 4.56f;

    // 布尔(boolean)常量
    // true flase 两种 boolean 型数据
    private final static boolean BOOLEAN1 = true;
    private final static boolean BOOLEAN2 = false;

    // 字符(char)常量
    private final static char CHAR = 'a';

    // 字符串(String)常量
    private final static String STRING = "STRING";

    // null常量
    private final static Object NULL = null;

    public static void main(String[] args) {
        System.out.println(INTEGER);
        System.out.println(BYTE);
        System.out.println(SHORT);
        System.out.println(LONG);

        System.out.println(DECIMALS);
        System.out.println(FLOAT);

        System.out.println(BOOLEAN1);
        System.out.println(BOOLEAN2);

        System.out.println(CHAR);
        System.out.println('\u0008');
        System.out.println('\b');
        System.out.println('\u0009');
        System.out.println('\t');
        System.out.println('\n');
        System.out.println('\u000B');
        System.out.println('\r');
        System.out.println('\\');
        System.out.println('\'');
        System.out.println('\u0022');
        System.out.println('\"');

        System.out.println(STRING);

        System.out.println(NULL);
    }
}
