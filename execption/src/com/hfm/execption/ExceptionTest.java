package com.hfm.execption;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 异常处理
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            getDivision(1, 0);
            // 捕获的异常类型
        } catch (Exception e) {
            // new NullPointerException(); Exception 之所以可以捕获任意类型的异常，是因为
            // Exception 是所有异常类的父类
            e.printStackTrace();
        }
        // 捕获自定义异常
        try {
            eat(6);
        } catch (NoMoneyException e) {
            e.printStackTrace();
        }
        /*
         * 字符流读文件
         */
        File file = new File("I:/JavaProject/learningDay0012/src/com/edu/cjlu/hfm/throwable/Throwable_1.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String content = null;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }

        } catch (FileNotFoundException e) {
            System.out.println("文件读取错误！");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("文件读取错误！");
            e.printStackTrace();
        } finally { // finally主要用于关闭资源
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            } finally {
                System.out.println("文件关闭成功！");
            }
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

    public static void eat(int money) throws NoMoneyException {
        if (money < 10) {
            throw new NoMoneyException("钱不够");
        } else {
            System.out.println("可以吃饭了");
        }
    }
}
