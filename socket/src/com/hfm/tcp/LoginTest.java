package com.hfm.tcp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 登陆服务器
 *
 * @author 26554
 */
public class LoginTest {
    /**
     * 服务端
     */
    @Test
    public void service() {
        try (
                // 1.创建服务端类
                ServerSocket serverSocket = new ServerSocket(9090);
                // 2.创建接收的服务端对象
                Socket socket = serverSocket.accept();
                // 3.获取客户端输入及输出通道
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
        ) {
            // 创建缓冲字节数组，用于存储数据
            byte[] b = new byte[1024 << 3];
            // 记录字节个数
            int length = -1;
            // 获取客户端信息
            while ((length = inputStream.read(b)) != -1) {
                System.out.println(new String(b, 0, length));
            }
            outputStream.write("登陆成功！".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 客户端
     */
    @Test
    public void client() {
        try (
                // 1.创建客户端类
                Socket socket = new Socket("127.0.0.1", 9090);
                // 2.获取客户端输入与输出通道
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
        ) {
            // 向服务端传递数据
            outputStream.write("登陆用户名及密码".getBytes());
            // 创建缓冲字节数组，用于存储数据
            byte[] b = new byte[1024 << 3];
            // 记录字节个数
            int length = -1;
            // 接收服务端信息
            while ((length = inputStream.read(b)) != -1) {
                System.out.println(new String(b, 0, length));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
