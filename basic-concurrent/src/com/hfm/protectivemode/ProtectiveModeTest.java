package com.hfm.protectivemode;

import java.util.concurrent.TimeUnit;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 11:50
 * @Description
 * @date 2021/9/14
 */
public class ProtectiveModeTest {
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        GuardedObjectTimeOut guardedObjectTimeOut = new GuardedObjectTimeOut();

        // 用于接收结果
        new Thread(()->{
            System.out.println("等待结果");
            Object o = guardedObjectTimeOut.get(5000L);
            System.out.println(o);
            System.out.println("已经接收结果");
        },"t1").start();

        // 用于生成结果
        new Thread(()->{
            try {
                System.out.println("4秒后生成结果");
                TimeUnit.SECONDS.sleep(4);
                guardedObjectTimeOut.complete("生成的结果");
                System.out.println("结果生成成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
