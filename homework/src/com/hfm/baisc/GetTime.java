package com.hfm.baisc;

/**
 * 练习: 为抵抗洪水，战士连续作战89小时，编程计算共多少天零多少小时？
 *
 * @author hfm
 * @version 1.01 2020-03-18 20:50
 * @date 2020/3/18
 */
public class GetTime {
    public static void main(String[] args) {
        System.out.println("共计" + (89 / 24) + "天" + " " + (89 % 24) + "小时");
    }
}
