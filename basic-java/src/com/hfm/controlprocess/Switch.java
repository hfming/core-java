package com.hfm.controlprocess;

import java.util.Scanner;

/**
 * switch语句的使用
 *  JDK 1.7 时支持 String 与 enum 型数据
 * @author hfm
 * @version 1.01 2019-09-19
 */
public class Switch {
    public static void main(String[] args) {
        // 案例1
        int x = 3;
        switch (x) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("ok");
                break;
        }

        // 需求：使用程序模拟该选择题判断一下那个不是计算机语言（ C ）A。 java B. php C.windows D. javascript
        // option 是用于存储你的选择的
        int option = 1;
        switch (option) {
            default:
                System.out.println("你的选择有误");
            case 1:
                System.out.println("你选择了 java");
            case 2:
                System.out.println("你选择了 php");
            case 3:
                System.out.println("你选择了 windows");
            case 4:
                System.out.println("你选择了 javascript");
        }

        // 需求 2:根据用于指定的月份,打印该月份所属的季节.
        /*
         * 选用 if 语句与 switch 语句的判断条件： switch 语句的优点： switch 的结构清晰。 switch 语句的缺点： case
         * 后面只能跟常量，不能跟判断表达式，那么如果条件是一个范围的话，那么使用 switch 语句就非常的麻烦。
         */
        System.out.println("请输入一个月份:");
        // 创建一个扫描器
        Scanner scanner = new Scanner(System.in);
        // 调用扫描器的扫描方法获取一个月份
        int month = scanner.nextInt();
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("没有该月份！");
                break;
        }

        // 练习：char 类型在 switch 中的使用.
        int x1 = 1, y = 2;
        char ch = '*';
        switch (ch) {
            case '+':
                System.out.println("x*y=" + (x1 + y));
                break;
            case '-':
                System.out.println("x-y=" + (x1 - y));
                break;
            case '*':
                System.out.println("x*y=" + (x1 * y));
                break;
            case '/':
                System.out.println("x/y=" + (x1 / y));
                break;
            default:
                System.out.println("不靠谱");
        }
    }
}
