package com.hfm.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-10 21:01
 */
public class BrowserRunnable implements Runnable {
    private Socket accept;
    private byte[] bytes;
    private int length;

    public BrowserRunnable(Socket accept, byte[] bytes, int length) {
        this.accept = accept;
        this.bytes = bytes;
        this.length = length;
    }

    @Override
    public void run() {
        FileInputStream fis = null;
        try (
                // 1.获取 客户端 socket 的输出流通道
                OutputStream out = accept.getOutputStream();
                InputStream inputStream = accept.getInputStream();
                // 转换流读取浏览器的请求消息
                BufferedReader readWb = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            // 注意编码格式
            byte[] bytes = new byte[1024 << 4];
            int len;

            String requst = readWb.readLine();
            // 取出请求资源的路径
            String[] strArr = requst.split(" ");
            System.out.println(Arrays.toString(strArr));
            // 去掉web前面的/
            String path = strArr[1].substring(1);
            System.out.println( path);
            // 读取客户端请求的资源文件
            fis = new FileInputStream(path);

            // 2.向浏览器传递数据
            // 写入HTTP协议响应头,固定写法
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("Content‐Type:text/html\r\n".getBytes());

            // 必须要写入空行,否则浏览器不解析
            out.write("\r\n".getBytes());

            while ((len = fis.read(bytes)) != -1) {
                out.write(bytes, 0, len);
                accept.shutdownOutput();
            }
        } catch (IOException ignored) {
            throw new RuntimeException(ignored);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (accept != null) {
                        try {
                            accept.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
