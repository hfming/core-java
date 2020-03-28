package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习 某电信公司的市内通话费计算标准如下：三分钟内0.2元，三分钟后每增加一分钟增加0.1元，不足一分钟的按一分钟计算。要求编写程序，给定一个通话时间（单位：秒），计算出应收费金额。
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class Amount {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入通话时间");
        double time = scanner.nextDouble();
        if (time <= 3.0) {
            System.out.println("收费0.2元");
        } else if (time > 3) {
            System.out.println("收费" + (0.2 + Math.floor(time - 3) * 0.1));
        }
    }
}
