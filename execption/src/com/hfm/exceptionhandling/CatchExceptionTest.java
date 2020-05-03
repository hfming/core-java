package com.hfm.exceptionhandling;

import java.io.*;

/**
 * 捕获异常测试
 *
 * @author hfm
 * @version 1.01 2020-03-28 16:55
 * @date 2020/3/28
 */
public class CatchExceptionTest {
    int x;
    public static void main(String[] args) {
        fileExecption();
        indexOutOfExecption();
        divideByZero();
    }

    private static void divideByZero() {
        int y;
        CatchExceptionTest c = new CatchExceptionTest();
        try {
            y = 3 / c.x;
        } catch (ArithmeticException e) {
            System.out.println("divide by zero error!");
        }
        System.out.println("program ends ok!");
    }

    private static void indexOutOfExecption() {
        String friends[] = {"lisa", "bily", "kessy"};
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(friends[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index err");
        }
        System.out.println("\nthis is the end");
    }

    private static void fileExecption() {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        // 捕获异常
        try {
            file = new File("D:/Code/core-java-simple/execption/src/com/hfm/execption/ExceptionTest.java");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String content = null;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取错误！");
            e.printStackTrace();
        }
    }
}
