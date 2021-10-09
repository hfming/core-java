package com.hfm.safety.account;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-08 15:04
 */
public class WithDrawThreadTest {
    public static void main(String[] args) {
        Account account = new Account("1234567", 10000);
        Thread t1 = new WithDrawThread("小明", account, 8000);
        Thread t2 = new WithDrawThread("小明's wife", account, 2800);
        t1.start();
        t2.start();
    }
}
