package com.hfm.decorator;

import java.io.*;

/**
 * 装饰者设计模式
 * 相互装饰
 *
 * @author hfm
 */
public class DecoratorTest2 {
    public static void main(String[] args) {
        File file = new File("file-io\\Resources\\CharacterStream_4.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        BufferedReaderNum bufferedReaderNum = null;
        BufferedReaderSemi bufferedReaderSemi = null;
        BufferedReaderNumAndSem bufferedReaderNumAndSem = null;

        // 相互装饰方法1 创建相互装饰类
        bufferedNumAndSemTest(file, bufferedReaderNumAndSem, bufferedReaderNum);

        // 没有创建新的相互装饰对象，推荐使用这种方法
        bufferedNumAndSemTest2(file, bufferedReaderNum, bufferedReaderSemi);
    }

    /**
     * 相互装饰方法1
     *
     * @param file
     * @param bufferedReaderNumAndSem
     * @param bufferedReaderNum
     */
    public static void bufferedNumAndSemTest(File file, BufferedReaderNumAndSem bufferedReaderNumAndSem, BufferedReaderNum bufferedReaderNum) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReaderNum = new BufferedReaderNum(bufferedReader);
            bufferedReaderNumAndSem = new BufferedReaderNumAndSem(bufferedReaderNum);
            String content = null;
            while ((content = bufferedReaderNumAndSem.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 相互装饰方法2
     *
     * @param file
     * @param bufferedReaderNum
     * @param bufferedReaderSemi
     */
    public static void bufferedNumAndSemTest2(File file, BufferedReaderNum bufferedReaderNum, BufferedReaderSemi bufferedReaderSemi) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReaderNum = new BufferedReaderNum(bufferedReader);
            // BufferedReaderSemi 可以接受 BufferedReader 及其子类对象
            bufferedReaderSemi = new BufferedReaderSemi(bufferedReaderNum);
            String content = null;
            while ((content = bufferedReaderSemi.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
