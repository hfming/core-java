package com.hfm.comunication.alternateprint;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-23 11:09
 * @Description 打印奇数
 * @date 2021/6/23
 */
public class OddNumber implements Runnable {
    private NumberState numberState;

    public OddNumber(NumberState numberState) {
        this.numberState = numberState;
    }

    @Override
    public void run() {
        while (true) {
            synchronized ("同一把锁") {
                if (numberState.num <= 100) {
                    if (numberState.num % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "\t" + numberState.num);
                        numberState.num++;
                        // 必须使用锁对象的 wait() notify() notifyAll() 方法
                        // 默认使用 this
                        "同一把锁".notify();
                    }
                    try {
                        // 必须使用锁对象的 wait() notify() notifyAll() 方法
                        // 默认使用 this
                        "同一把锁".wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
