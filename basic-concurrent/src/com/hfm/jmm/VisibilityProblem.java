package com.hfm.jmm;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 19:58
 * @Description
 * @date 2021/9/15
 */
public class VisibilityProblem {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        while (true) {
            if (myThread.isFlag()) {
                System.out.println(myThread.isFlag());
            }
        }
    }

    static class MyThread extends Thread {
        private /**volatile**/ boolean flag = false;

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
    }
}


