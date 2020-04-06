package com.hfm.object;

import java.util.Random;

/**
 * 数学类方法
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class MathTest {

    public static void main(String[] args) {
        System.out.println("绝对值：" + Math.abs(-3.14));
        System.out.println("向上取整：" + Math.ceil(-3.14));
        System.out.println("向下取整：" + Math.floor(3.14));
        System.out.println("四舍五入：" + Math.round(3.55));
        // 随即范围： 0.0 ~ 1.0 不包括1.0
        System.out.println("随机数：" + Math.random());
        Random random = new Random();
        // 随机数范围是0-10
        System.out.println("随机数：" + random.nextInt(11));
        char[] arr = {'a', 'A', '中', '雨', '共', 'W', 'O', '1', '9', '4'};
        //创建一个字符串缓冲区类
        StringBuilder sb = new StringBuilder();
        //产生四个随即的索引值。
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(arr.length);
            char temp = arr[index];
            sb.append(temp);
        }
        System.out.println("验证码：" + sb);

        // 定义最小值
        double min = -10.8;
        // 定义最大值
        double max = 5.9;
        // 定义变量计数
        int count = 0;
        // 范围内循环
        for (double i = Math.ceil(min); i <= max; i++) {
            // 获取绝对值并判断
            if (Math.abs(i) > 6 || Math.abs(i) < 2.1) {
                // 计数
                count++;
            }
        }
        System.out.println("个数为: " + count + " 个");
    }
}
