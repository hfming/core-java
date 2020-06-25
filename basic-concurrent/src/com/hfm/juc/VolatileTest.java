package com.hfm.juc;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-14 20:53
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();

        myThread.start();
        while (true) {
            if (myThread.isFlag()) {
                System.out.println(myThread.isFlag());
            }
        }
    }
}

class MyThread extends Thread {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class MyThread2 extends Thread {
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}