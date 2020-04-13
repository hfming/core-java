package com.hfm.execption;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 抛出异常
 *
 * @author hfm
 * @version 1.01 2020-03-28 17:28
 * @date 2020/3/28
 */
public class ThrowExceptionTest {
    public static void main(String[] args) {
        // 捕获自定义异常
        try {
            eat(6);
        } catch (NoMoneyException e) {
            e.printStackTrace();
        }

        try {
            getDivision(1, 0);
            // 捕获的异常类型B
        } catch (Exception e) {
            // new NullPointerException(); Exception 之所以可以捕获任意类型的异常，是因为 Exception 是所有异常类的父类
            e.printStackTrace();
        }

        ThrowExceptionTest t = new ThrowExceptionTest();
        try {
            t.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常处理，抛出异常
     *
     * @param a
     * @param b
     * @return
     */
    public static double getDivision(int a, int b) throws Exception {
        return a / b;
    }

    /**
     * 抛出异常
     *
     * @param money
     * @throws NoMoneyException
     */
    public static void eat(int money) throws NoMoneyException {
        if (money < 10) {
            throw new NoMoneyException("钱不够");
        } else {
            System.out.println("可以吃饭了");
        }
    }

    public void readFile() throws IOException {
        FileInputStream in = new FileInputStream("atguigushk.txt");
        int b;
        b = in.read();
        while (b != -1) {
            System.out.print((char) b);
            b = in.read();
        }
        in.close();
    }
}
