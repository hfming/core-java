package com.hfm.constant;

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
    /**
     * 常量的分类：
     * 1. 字符串常量：凡是用双引号引起来的部分，叫做字符串常量。例如："abc"、"Hello"、"123"
     * 2. 整数常量：直接写上的数字，没有小数点。例如：100、200、0、-250
     * 3. 浮点数常量：直接写上的数字，有小数点。例如：2.5、-3.14、0.0
     * 4. 字符常量：凡是用单引号引起来的单个字符，就做字符常量。例如：'A'、'b'、'9'、'中'
     * 5. 布尔常量：只有量中取值。true、false。
     * 6. 空常量：null。代表没有任何数据。
     */

    /**
     * 整数常量
     * byte short int long 四种整数常量
     */

    private final static int INTEGER = 1;
    private final static byte BYTE = 2;
    private final static short SHORT = 3;
    private final static long LONG = 4L;

    /**
     * 小数常量
     * float double 两种浮点型常量
     */
    private final static double DECIMALS = 3.14;
    private final static float FLOAT = 4.56f;

    /**
     * 布尔(boolean)常量
     * true flase 两种 boolean 型数据
     */
    private final static boolean BOOLEAN1 = true;
    private final static boolean BOOLEAN2 = false;

    /**
     * 字符(char)常量
     */
    private final static char CHAR = 'a';

    /**
     * 字符串(String)常量
     */
    private final static String STRING = "STRING";

    /**
     * null常量
     */
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
        // System.out.println(''); // 两个单引号中间必须有且仅有一个字符，没有不行。
        // System.out.println('AB'); // 两个单引号中间必须有且仅有一个字符，有两个不行。

        System.out.println(STRING);

        // 空常量。空常量不能直接用来打印输出。
        System.out.println(NULL);
    }
}
