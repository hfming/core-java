package com.hfm.function;

import java.util.*;

/**
 * 函数(方法)的定义与使用
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class Function {
    public static void main(String[] args) {
        // 打印99乘法表
        printMultiplicationTables();
        // 判断闰年
        String str = judgeLeapYear(2000);
        System.out.println(str);
        // 打印矩形
        printRectangles();

        int[] arg = new int[10];
        // 初始化
        for (int i = 0; i < arg.length; i++) {
            arg[i] = i;
        }
        System.out.println(Arrays.toString(arg));
        // 排序
        retroposition(arg);
        System.out.println(Arrays.toString(arg));

        // 求最值
        System.out.println(getSecondRate(arg));

        // 求平均分
        int[] arg2 = new int[]{56, 89, 8, 28, 43, 89};
        boolean flag = true;
        while (flag) {
            if (getAverageValue(arg2) > 60) {
                flag = false;
            } else {
                addGreat(arg2);
            }
        }
        System.out.println(Arrays.toString(arg2));

        // 求素数
        int num = 1000000;
        primeNum(num);

        int i = "sdsd".length();
        // char c = 17c;
        System.out.println(i);
        getMax("aaaaaaaaaabbbbbbbbbbsfuudiigjuaggrwyrochnbgdsyugfejrojighdcdkirherue");
        getNum(111);
    }

    /**
     * 求素数
     *
     * @param n
     */
    public static void primeNum(int n) {
        OUT:
        for (int i = 1; i <= n; i++) {
            INNER:
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && j != 1) {
                    continue OUT;
                }
            }
            System.out.print(i + " ");
        }
    }

    /**
     * 5.编写一个方法接受一个用户名与密码，如果输入的用户名不是 admin 密码不是 888，那么继续提示用户“用户名或者密码错误”，否则提示用户输入正确。
     */
    private void register() {
        System.out.println("#################欢迎使用登录系统##############");
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        String passWord = "";
        System.out.print("请输入用户名：");
        userName = scanner.nextLine();
        if ("admin".equals(userName) == true) {
            System.out.print("请输入密码");
            passWord = scanner.nextLine();
            if ("888".equals(passWord) == true) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或密码错误！");
            }
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 排序
     *
     * @param arg
     */
    private static void retroposition(int[] arg) {
        int start = arg[0];
        for (int i = 0; i < arg.length - 1; i++) {
            if (i != arg.length - 1) {
                arg[i] = arg[i + 1];
            }
        }
        arg[arg.length - 1] = start;
    }

    /**
     * 取最大值
     */
    private static int getMax(int[] arg) {
        int max = 0;
        for (int i = 0; i < arg.length; i++) {
            if (max < arg[i]) {
                max = arg[i];
            }
        }
        return max;
    }

    /**
     * 取最小值
     */
    private static int getmin(int[] arg) {
        int min = 0;
        for (int i = 0; i < arg.length; i++) {
            if (min < arg[i]) {
                min = arg[i];
            }
        }
        return min;
    }

    /**
     * 统计奇数个数
     */
    private static int countUnevenNumber(int[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 统计偶数个数
     */
    private static int countEvenNumber(int[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 请编写 1 个程序 求出 1 个整型数组中的最大值和次大值。
     */
    private static int getSecondRate(int[] arg) {
        int max = 0;
        int second = 0;
        for (int i = 0; i < arg.length; i++) {
            if (max < arg[i]) {
                max = arg[i];
            }
        }
        // System.out.println(max);
        for (int i = 0; i < arg.length; i++) {
            if (second < arg[i] && arg[i] < max) {
                second = arg[i];
            }
        }
        return second;
    }

    /**
     * 用户输入班级的人数,然后依次输入每个同学的成绩. 输入完毕之后,如果及格率没有达到 60%， 就为每 1 个没有及格的成绩加 2 分,直到及格率达到60%为止。
     */
    private static double getAverageValue(int[] arg) {
        int sum = 0;
        for (int i = 0; i < arg.length; i++) {
            sum += arg[i];
        }
        return sum / arg.length;
    }

    /**
     * 为没有到60的成绩加2
     *
     * @param arg
     */
    private static void addGreat(int[] arg) {
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] < 60) {
                arg[i] += 2;
            }
        }
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

    /**
     * 获取最大值
     *
     * @param str
     */
    public static void getMax(String str) {
        char[] chars = str.toCharArray();
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int i = 0; i < chars.length; i++) {
            String string = String.valueOf(chars[i]);
            if (hashmap.containsKey(string)) {
                hashmap.put(string, hashmap.get(string) + 1);
            } else {
                hashmap.put(string, 1);
            }
        }
        Collection<Integer> values = hashmap.values();
        System.out.println(values);
        int max = 0;
        //求最大的个数
        for (int i : values) {
            if (max < i) {
                max = i;
            }
        }
        Set<Map.Entry<String, Integer>> outString = hashmap.entrySet();
        for (Map.Entry<String, Integer> i : outString) {
            if (i.getValue() == max) {
                System.out.println(i.getKey() + "=" + max);
            }
        }
    }

    /**
     * @param n
     */
    public static void getNum(int n) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            int j = getDivisor(i);
            // System.out.println("j="+j);
            temp = i;
            for (int x = j; x >= 0; x--) {
                // System.out.println("x="+x);
                // System.out.println("pow="+(int)Math.pow(10, x));
                // System.out.println("/="+(i/(int)Math.pow(10, x)));
                if ((temp / (int) Math.pow(10, x)) == 1) {
                    result = result + 1;
                }
                temp = (i % (int) Math.pow(10, x));
            }
        }
        // System.out.println(result);
    }

    /**
     * @param n
     * @return
     */
    private static int getDivisor(int n) {
        int i = 0;
        do {
            // System.out.println((int)Math.pow(10, i));
            if ((n / (int) Math.pow(10, i)) >= 10) {
                i++;
            } else {
                break;
            }
        } while (true);
        // System.out.println(i);
        return i;
    }

    /**
     * 选择排序/快速排序
     */
    public static void quickSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}