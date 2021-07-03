package com.hfm.comunication.alternateprint;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-23 11:10
 * @Description 打印偶数
 * @date 2021/6/23
 */
public class EvenNumber2 implements Runnable {
    private int num;

    public EvenNumber2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized ("同一把锁") {
            for (int i = 0; i < num; i++) {
                if (i <= 100) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "\t" + i);
                        // 必须使用锁对象的 wait() notify() notifyAll() 方法
                        // 默认使用 this
                        i++;
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
