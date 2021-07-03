package com.hfm.otherstream;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-14 19:19
 * @Description 标准输入输出流
 * @date 2021/6/14
 */
public class SystemOutInTest {
    /**
     * System.in 标准输入流，默认键盘输入
     * System.out 标准键盘输出流，默认控制台输出
     */
    public static void main(String[] args) {
        try (
                InputStream in = System.in;
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String content;
            while (true) {
                System.out.print("输入数据：");
                content = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(content) || "exit".equalsIgnoreCase(content)) {
                    break;
                }
                // 转换成大写输出
                System.out.println(content.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
