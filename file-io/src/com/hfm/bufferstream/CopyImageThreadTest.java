package com.hfm.bufferstream;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-01 17:58
 */
public class CopyImageThreadTest extends Thread{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new CopyImageThreadTest().run();
        }
    }

    @Override
    public void run() {
        CopyImage.main(null);
    }
}
