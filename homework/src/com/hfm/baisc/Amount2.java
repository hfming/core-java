package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习 某市的出租车计费标准为：3公里以内10元，3公里以后每加0.5公里加收1元；每等待2.5分钟加收1元；超过15公里的加收原价的50%为空驶费。要求编写程序，对于任意给定的里程数（单位：公里）和等待时间（单位：秒）计算出应付车费，车费直接截去小数位，只取整数。
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class Amount2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入里程数");
        double mileage = scanner.nextDouble();
        System.out.println("请输入等待时间");
        double time = scanner.nextDouble();

        if (mileage <= 3) {
            System.out.println("收费" + Math.floor(time / 2.5 + 10));
        } else if (mileage < 15 && mileage > 3) {
            System.out.println("收费" + Math.floor(10 + (mileage - 3) / 0.5 + time / 2.5));
        } else {
            System.out.println("收费" + Math.floor((10 + (mileage - 3) / 0.5 + time / 2.5)) * 1.5);
        }
    }
}
