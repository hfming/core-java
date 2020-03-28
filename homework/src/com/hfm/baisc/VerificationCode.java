package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习:	生成13位条形码, Ean-13码规则：第十三位数字是前十二位数字经过计算得到的校验码。
 * 例如：690123456789
 * 计算其校验码的过程为：
 * ①	 前十二位的奇数位和6+0+2+4+6+8=26
 * a)	② 前十二位的偶数位和9+1+3+5+7+9=34
 * ②	 将奇数和与偶数和的三倍相加26+34*3=128
 * a)	④ 取结果的个位数：128的个位数为8
 * ⑤ 用10减去这个个位数10-8=2所以校验码为2
 * （注：如果取结果的个位数为0，那么校验码不是为10（10-0=10），而是0）
 * 实现上述代码的功能，计算验证码，输入12位条码，返回带验证码的条码。
 * 例：输入：692223361219输出：6922233612192
 *
 * @author hfm
 * @version 1.01 2020-03-19 12:58
 * @date 2020/3/19
 */
public class VerificationCode {
    public static void main(String[] args) {
        System.out.println("请输入12位长整数");
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        Long temp = num;
        System.out.println("输入的长整数为" + num);
        int oddSum = 0;

        temp /= 10;
        oddSum += temp % 10;
        while (temp > 0) {
            temp /= 100;
            oddSum += (temp % 10);
        }
        System.out.println(oddSum);

        temp = num;
        int evenSum = 0;
        evenSum += temp % 10;
        while (temp > 0) {
            temp /= 100;
            evenSum += (temp % 10);
        }
        System.out.println(evenSum);
        int num13 = 10 - (oddSum * 3 + evenSum) % 10;
        if(num13 ==10){
            num13 = 0;
        }
        System.out.println(num + Integer.valueOf(num13).toString());
    }
}
