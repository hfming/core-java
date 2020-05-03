package com.hfm.decorator;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 装饰者设计模式
 * 对BufferedReader的readLine方法进行加强，添加行号
 */
public class BufferedReaderNum extends BufferedReader {
    /**
     * 1.在装饰者类的内部维护一个被被装饰者类的引用。
     */
    BufferedReader bufferedReader;
    private static int count = 0;

    /**
     * 2.在装饰者类的构造方法中初始化被装饰者类的引用
     *
     * @param bufferedReader
     */
    public BufferedReaderNum(BufferedReader bufferedReader) {
        super(bufferedReader);
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
        // 解决方案：如果这里的 readLine 方法是
        // BufferedSemi 的 readline
        // 方法那么该问题解决了。
        String line = bufferedReader.readLine();
        if (line == null) {
            return null;
        }
        line = count + ":" + line;
        count++;
        return line;
    }
}
