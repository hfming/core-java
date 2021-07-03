package com.hfm.comunication.alternateprint;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-23 11:10
 * @Description 打印偶数
 * @date 2021/6/23
 */
public class EvenNumber implements Runnable {
    private NumberState numberState;

    public EvenNumber(NumberState numberState) {
        this.numberState = numberState;
    }

    @Override
    public void run() {
        while (true) {
            synchronized ("同一把锁") {
                if (numberState.num <= 100) {
                    if (numberState.num % 2 == 0) {
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
