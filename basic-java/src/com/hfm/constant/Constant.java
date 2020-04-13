package com.hfm.constant;

/**
 * 常量 Demo
 * 常量通常定于在类之内方法之外
 * 常量是指在程序运行过程中其值不能改变的量
 * 常量都是大写,单词与单词之间用下划线 _ 隔开，并用 final 进行修饰
 *
 * @author hfm
 * @version 1.2 2020-01-14
 */
public class Constant {
    /**
     * 整数常量：直接写上的数字，没有小数点。例如：100、200、0、-250
     * byte short int long 四种整数常量
     */
    private final static byte BYTE = 2;
    private final static short SHORT = 3;
    private final static int INT = 1;
    private final static long LONG = 4L;
    /**
     * 浮点数常量：直接写上的数字，有小数点。例如：2.5、-3.14、0.0
     * float double 两种浮点型常量
     */
    private final static double DOUBLE = 3.14;
    private final static float FLOAT = 4.56f;
    /**
     * 布尔(boolean)常量：只有量中取值 true、false。
     */
    private final static boolean TRUE = true;
    private final static boolean FALSE = false;
    /**
     * 字符(char)常量：凡是用单引号引起来的单个字符，就做字符常量。例如：'A'、'b'、'9'、'中'
     */
    private final static char CHAR = 'a';
    /**
     * 字符串(String)常量 ：凡是用双引号引起来的部分，叫做字符串常量。例如："abc"、"Hello"、"123"
     */
    private final static String STRING = "STRING";
    /**
     * 空(null)常量：null。代表没有任何数据。
     */
    private final static Object NULL = null;

    public static void main(String[] args) {
        // 整形
        System.out.println(INT);
        System.out.println(BYTE);
        System.out.println(SHORT);
        System.out.println(LONG);
        // 浮点型
        System.out.println(DOUBLE);
        System.out.println(FLOAT);
        // Boolean 型
        System.out.println(TRUE);
        System.out.println(FALSE);

        // 字符型
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
        // System.out.println(''); // 两个单引号中间必须有且仅有一个字符，没有不行。
        // System.out.println('AB'); // 两个单引号中间必须有且仅有一个字符，有两个不行。

        // 字符串型
        System.out.println(STRING);

        // 空常量 不能直接用来打印输出。
        System.out.println(NULL);
        System.out.println("");
    }
}
