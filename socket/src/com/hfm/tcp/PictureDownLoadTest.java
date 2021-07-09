package com.hfm.tcp;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 图片访问服务端,单例设计模式
 *
 * @author hfm
 */
public class PictureDownLoadTest {
    /**
     * 优化服务端
     */
    @Test
    public void service() {
        System.out.println("服务器 启动.....  ");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        byte[] b = new byte[1024 << 3];
        int len = 0;
        try (
                // 1. 创建服务端ServerSocket
                ServerSocket serverSocket = new ServerSocket(9090)
        ) {
            // 2. 循环接收,建立连接
            while (true) {
                Socket accept = serverSocket.accept();
                // 每次提交任务
                threadPoolExecutor.submit(new PictureRunnable(accept, b, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void client() {
        System.out.println("客户端 - 获取服务端图片！");
        try (
                // 1.创建客户端对象
                Socket socket = new Socket("127.0.0.1", 9090);
                // 2.创建IO流对象(输出流对象)
                OutputStream outputStream = new FileOutputStream("D:\\Code\\core-java-simple\\socket\\Resources\\" + System.currentTimeMillis() + ".jpg");
                // 客户端接收服务端数据
                InputStream inputStream = socket.getInputStream();
        ) {
            // 创建缓冲字节数组，用于存储数据
            byte[] b = new byte[1024 << 3];
            // 记录字节个数
            int length;
            // 从服务端接收数据
            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }
            outputStream.flush();

            // 告诉服务器文件接收完毕
            socket.shutdownInput();

            String str = "文件接收完成";
            // 3.将数据写出
            outputStream.write(str.getBytes());
            System.out.println("客户端 - 文件接收成功！");

            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


