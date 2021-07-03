package com.hfm.valuepass;

/**
 * 值传递练习
 *
 * @author hfm
 * @version 1.01 2020-04-03 12:23
 * @date 2020/4/3
 */
public class ObjectExchangeValueTest1 {
    public static void main(String[] args) {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        // 10 20
        System.out.println(data.m + " " + data.n);
        // 交换成功，传递变量的内存地址
        swap(data);
        // 20 10
        System.out.println(data.m + " " + data.n);
    }

    public static void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data {
    int m;
    int n;
}