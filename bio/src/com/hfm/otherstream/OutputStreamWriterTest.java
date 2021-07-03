package com.hfm.otherstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description OutputStreamWriter 字符向字节转换 字符转换成字节然后通过字符流写入硬盘
 * @date 2020-05-03 17:21
 */
public class OutputStreamWriterTest {
    /**
     * 需求：要把输出字节流转换成输出字符流.
     */
    @Test
    public  void writeTest1() {
        File file = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\a.txt");
        String data = "hello world，中文";

        try (
                FileWriter fileWriter = new FileWriter(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                // 字符转为字节？ 不能转换
                // writer = new OutputStreamWriter(fileWriter, "GBK");
                // 字节流向文件输出数据的时候需要借助 String 类的 getbyte 功能，我想使用字符流.
                // 只能将字节流转换为字符流
                OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "GBK");
        ) {
            // 写出数据
            writer.write(data);
            // 刷新流
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
