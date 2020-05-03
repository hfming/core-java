package com.hfm.decorator;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 相互装饰
 * 需要实现同一个接口，或继承同一个父类
 */
public class BufferedReaderNumAndSem extends BufferedReader {
    /**
     * 1.在装饰者类的内部维护一个被被装饰者类的引用。
     */
    BufferedReaderNum bufferedReaderNum;

    /**
     * * 2.在装饰者类的构造方法中初始化被装饰者类的引用
     *
     * @param bufferedReaderNum
     */
    public BufferedReaderNumAndSem(BufferedReader bufferedReaderNum) {
        super(bufferedReaderNum);
        // 多态的方式，能够传递更多的子类对象
        this.bufferedReaderNum = (BufferedReaderNum) bufferedReaderNum;
    }

    /**
     * 3.在装饰者类中定义与被装饰者类的同名方法，在同名方法中使用被装饰者类的方法并对其方法进行扩展
     *
     * @return
     * @throws IOException
     */
    @Override
    public String readLine() throws IOException {
        String line = bufferedReaderNum.readLine();
        if (line == null) {
            return null;
        }
        line = line + ";";
        return line;
    }
}

