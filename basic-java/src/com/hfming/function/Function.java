package com.hfming.function;

/**
 * 函数(方法)的定义与使用
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class Function {
    /**
     * mian函数
     *
     * @param args
     */
    public static void main(String[] args) {
        printMultiplicationTables();
        String str = judgeLeapYear(2000);
        System.out.println(str);
        printRectangles();
    }

    /**
     * 相加
     *
     * @param a
     * @param b
     * @return
     */
    private int add(int a, int b) {
        return a + b;
    }

    /**
     * 三个数相加
     *
     * @return
     */
    private int add(int... values) {
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }

    /**
     * 案例：获取2个整数中的较大的数
     *
     * @param a
     * @param b
     * @return
     */
    private double getMax(double a, double b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * 定义一个函数把两个 int 类型的参数的最大值打印出来，不需要返回值
     *
     * @param a
     * @param b
     */
    private void printlnMax(double a, double b) {
        if (a >= b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    /**
     * 定义一个函数根据学生的分数，返回成绩对应的等级。
     *
     * @param grande
     * @return
     */
    private char getResult(int grande) {
        if (grande <= 100 && grande >= 90) {
            return 'A';
        } else if (grande < 90 && grande >= 80) {
            return 'B';
        } else {
            return 'C';
        }
    }

    /**
     * 需求：根据学生考试成绩划分 ABCD A90-100 B80-89 C70-79 D60-69 E0-59，建议成绩使用
     * double。将该程序使用函数定义。 函数中只能调用函数，不可以在函数内部定义函数。函数之间是平级的,相互之间是调用的关系.
     *
     * @param score
     * @return
     */
    public static String printGrade(double score) {
        char grade;
        if (score >= 90.0) {
            return "A";
        }
        if (score >= 80.0) {
            return "B";
        }
        if (score >= 70.0) {
            return "C";
        }
        if (score >= 60.0) {
            return "D";
        }
        return "E";
    }

    /**
     * 定义一个函数打印乘法表(不需要返回值)。
     */
    private static void printMultiplicationTables() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 定义一个函数判断一个年份是否是闰年，如果是闰年返回“闰年”，否则返回 “非闰年”.
     *
     * @param year
     * @return
     */
    private static String judgeLeapYear(int year) {
        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
            return "闰年";
        } else {
            return "非闰年";
        }
    }

    /**
     * 定义一个函数打印一个矩形（不需要返回值）。
     */
    private static void printRectangles() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 两个数字对比是否相等
     *
     * @param num1
     * @param num2
     * @return
     */
    private static boolean isSame(int num1, int num2) {
        if (num1 == num2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 比较两数大小
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(int a, int b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * return关键字的作用
     *
     * @param num
     */
    public static void test(int num) {
        if (num == 1) {
            // return 关键字后面如果跟有数据，那么 return 就是把数据返回给调用者。
            return;
            // 如果 return 关键字后面没有任何的数据，那么这时候 return 关键字的作用就是结束一个函数。
        }
        System.out.println("我能执行吗？");
    }
}