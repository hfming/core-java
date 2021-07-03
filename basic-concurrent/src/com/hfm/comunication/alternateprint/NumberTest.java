package com.hfm.comunication.alternateprint;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-23 11:14
 * @Description
 * @date 2021/6/23
 */
public class NumberTest {
    public static void main(String[] args) {
//        NumberState numberState = new NumberState();
//        OddNumber oddNumber = new OddNumber(numberState);
//        EvenNumber evenNumber = new EvenNumber(numberState);
//
//        new Thread(oddNumber,"打印奇数").start();
//        new Thread(evenNumber,"打印偶数").start();

        Integer num = new Integer(100);
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i;
        }

        OddNumber2 oddNumber2 = new OddNumber2(num);
        EvenNumber2 evenNumber2 = new EvenNumber2(num);

        new Thread(oddNumber2,"打印奇数").start();
        new Thread(evenNumber2,"打印偶数").start();
    }
}
