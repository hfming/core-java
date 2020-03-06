package com.hfming.controlprocess;

import java.util.Scanner;

/**
 * if 语句 demo
 *
 * @author hfm
 * @version 1.01 2019-09-17
 */
public class TernaryConditio {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 提示用户输入一个整数。如果该整数是 5 的倍数，打印“5 的倍数”如果是 2 的倍数打印“2 的倍数”
        System.out.println("请输入一个数");
        int i = scanner.nextInt();
        if (i % 5 == 0) {
            System.out.println(i + "是5的倍数");
        } else if (i % 2 == 0) {
            System.out.println(i + "是2的倍数");
        } else {
            System.out.println(i + "即不是5的倍数也不是2的倍数");
        }

        // 需求：招聘工作经验两年或者两年以上的人员，符合条件，电话通知面试。
        int workAge = 2;
        if (workAge >= 2) {
            System.out.println("电话通知明天过来面试...");
        } else {
            System.out.println("电话通知你不要再投我们公司，不要你！！");
        }

        // 判断一个整数是奇数还是偶数
        System.out.println("请再输入一个数");
        int j = scanner.nextInt();
        if (j % 2 == 0) {
            System.out.println(j + "是偶数");
        } else {
            System.out.println(j + "是奇数");
        }

        // 需求： 根据键盘录入一个数字， 然后输出对应的星期。
        System.out.println("请输入一个数字：");
        // 第一步: 创建一个扫描器对象
        // 第二步：调用扫描器扫描是否输入了数据
        // 扫描的是整数
        int num = scanner.nextInt();
        // scanner.next();// 扫描一个字符串
        System.out.println(getWeek(num));

        // 练习 1: 根据用户输入的月份,打印出月份所属的季节.
        int amonth = scanner.nextInt();
        System.out.println(getSeason(amonth));

        // 根据用户输入的成绩，进行评级，根据学生考试成绩划分 ABCD
        System.out.println("请输入考试分数：");
        System.out.println(getGreat());

        // 判断闰年
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        boolean ayear = isLeapYear(year);
        if (ayear) {
            System.out.println(year + "是闰年！");
        } else {
            System.out.println(year + "不是闰年！");
        }
    }

    /**
     * 判断是星期几
     *
     * @param num
     */
    public static String getWeek(int num) {
        if (num == 0) {
            return "星期天";
        }
        if (num == 1) {
            return "星期一";
        }
        if (num == 2) {
            return "星期二";
        }
        if (num == 3) {
            return "星期三";
        }
        if (num == 4) {
            return "星期四";
        }
        if (num == 5) {
            return "星期五";
        }
        if (num == 6) {
            return "星期六";
        }
        return "輸入錯誤...";

    }

    /**
     * 获取季节
     *
     * @param amonth
     * @return
     */
    public static String getSeason(int amonth) {
        if (amonth == 3 || amonth == 4 || amonth == 5) {
            return "spring";
        }
        if (amonth == 6 || amonth == 7 || amonth == 8) {
            return "Summer";
        }
        if (amonth == 9 || amonth == 10 || amonth == 11) {
            return "autumn";
        }
        if (amonth == 12 || amonth == 1 || amonth == 2) {
            return "Winter";
        }
        return "月份不存在";
    }

    /**
     * 判断成绩
     */
    public static char getGreat() {
        double score = scanner.nextDouble();
        char grade;
        // 卫语句
        if (score >= 90.0) {
            return grade = 'A';
        }
        if (score >= 80.0) {
            return grade = 'B';
        }
        if (score >= 70.0) {
            return grade = 'C';
        }
        if (score >= 60.0) {
            return grade = 'D';
        }
        return grade = 'F';
    }

    /**
     * 判断是否为闰年
     *
     * @param year
     */
    public static boolean isLeapYear(int year) {
        // 判断年份能否被 4 整除
        boolean isLeap = (year % 4 == 0);
        // 年份能被 4 整除，并且不能被 100 整除并且使用&&（and）
        isLeap = isLeap && (year % 100 != 0);
        // 年份或者能够被 400 整除
        isLeap = isLeap || (year % 400 == 0);
        return isLeap;
        /// 简写格式
        /*
         * if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
         * System.out.println(year + "是闰年！"); }
         */
    }
}
