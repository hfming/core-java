package com.hfm.function;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 19:33
 * @Description
 * @date 2021/9/14
 */
public class PackAndUnPack {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                LockSupport.park();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
            LockSupport.unpark(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
