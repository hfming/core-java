package com.hfm.otherstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 转换流 InputStreamReader 字节向字符转换
 *
 * @author hfm
 */
public class InputStreamReaderTest {
    /**
     * 输入字节流转化位输入字符流
     */
    @Test
    public  void inputByteToChar() {
        File file = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\a.txt");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                // 将字节流转化位字符流,可以指定码表
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
                // 将字节流转化位 缓冲字符流
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 1024 << 8);
        ) {
            // 存储每行读取到的字符
            String line = null;
            // 读取数据
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}