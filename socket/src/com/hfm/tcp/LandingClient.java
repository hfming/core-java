package com.hfm.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * 使用 tcp 协议编写一个服务端完成注册登录功能。(支持多用户同时注册于登录)
 * 要求：
 * 1. 用户注册的数据必须要保存到服务端的文件上面。
 * 2. 客户端登录的时候，客户端输入的数据需要与服务端的文件校验，如果存在该用户名与密码，才允许登录成功。使用字符流写出数据的时候,数据是写入了其内部维护的缓冲字符数组中，需要调用 flush 或者是 close 方法数据才会真正的写出去。 或者字符数组已经存储满了，数据也一样会写出去。
 */
public class LandingClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (
                // 建立 tcp 客户端的服务
                Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
                // 获取 socket 的输入、输出通道。
                BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStreamWriter socketWriter = new OutputStreamWriter(socket.getOutputStream());
        ) {
            // 用户选择的功能
            while (true) {
                System.out.println("请选择功能： A(注册) B(登录)");
                String option = scanner.next();
                if ("a".equalsIgnoreCase(option)) {
                    System.out.println("你选择了注册功能");
                    // 注册
                    getInfo(scanner, socketReader, socketWriter, option);
                } else if ("b".equalsIgnoreCase(option)) {
                    // 登录
                    System.out.println("你选择了登录功能");
                    getInfo(scanner, socketReader, socketWriter, option);
                } else {
                    System.out.println("你的选择有误,请重新选择!!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getInfo(Scanner scanner, BufferedReader socketReader, OutputStreamWriter socketWriter, String option) {
        System.out.println("请输入用户名：");
        String userName = scanner.next();
        System.out.println("请选择密码:");
        String password = scanner.next();
        // 把用户名与密码发送给服务端
        String line = option + " " + userName + " " + password + "\r\n";
        try {
            socketWriter.write(line);
            // 刷新缓冲流
            socketWriter.flush();
            // 读取服务端的反馈信息
            line = socketReader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}