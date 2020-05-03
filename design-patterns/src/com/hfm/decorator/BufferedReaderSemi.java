package com.hfm.decorator;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 装饰者设计模式
 * 对BufferedReader的readLine方法进行加强，添加 ;
 */
public class BufferedReaderSemi extends BufferedReader {
    /**
     * 1.在装饰者类的内部维护一个被被装饰者类的引用。
     */
    BufferedReader bufferedReader;

    /**
     * 2.在装饰者类的构造方法中初始化被装饰者类的引用
     *
     * @param bufferedReader
     */
    public BufferedReaderSemi(BufferedReader bufferedReader) {
        super(bufferedReader);
        // 多态的方式，可以传递更多子类对象
        this.bufferedReader = bufferedReader;
    }

    /**
     * 3.在装饰者类中定义与被装饰者类的同名方法，在同名方法中使用被装饰者类的方法并对其方法进行扩展
     *
     * @return
     * @throws IOException
     */
    @Override
    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        if (line == null) {
            return null;
        }
        line = line + ";";
        return line;
    }
}
