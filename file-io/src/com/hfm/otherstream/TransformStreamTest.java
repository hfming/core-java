package com.hfm.otherstream;

import java.io.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 将GBK编码的文本文件，转换为UTF-8编码的文本文件。
 * @date 2020-05-03 17:33
 */
public class TransformStreamTest {
    public static void main(String[] args) {
        // 1.定义文件路径
        String srcFile = "file_gbk.txt";
        String destFile = "file_utf8.txt";
        // 2.创建流对象
        // JDK 7 自动释放资源
        try (
                // 2.1 转换输入流,指定GBK编码
                InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "GBK");
                // 2.2 转换输出流,默认utf8编码
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destFile));
        ) {
            // 3.读写数据
            // 3.1 定义数组
            char[] cbuf = new char[1024];
            // 3.2 定义长度
            int len;
            // 3.3 循环读取
            while ((len = isr.read(cbuf)) != -1) {
                // 循环写出
                osw.write(cbuf, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
