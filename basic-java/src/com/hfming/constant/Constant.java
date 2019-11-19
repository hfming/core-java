package com.hfming.constant;

/**
 * 常量
 *
 * @author hfm
 * @version 1.2 2019-09-17
 */
public class Constant {
    // 常量都是大写
    // 整数常量
    private final static int INTEGER = 1;
    private final static byte BYTE = 2;
    private final static short SHORT = 3;
    private final static long LONG = 4L;

    // 小数常量
    private final static double DECIMALS = 3.14;
    private final static float FLOAT = 4.56f;

    // 布尔常量 
    private final static boolean BOOLEAN1 = true;
    private final static boolean BOOLEAN2 = false;

    // 字符常量
    private final static char CHAR = 'a';

    // 字符串常量
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
