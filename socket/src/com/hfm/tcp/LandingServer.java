package com.hfm.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * 服务端
 * 第一个问题： 服务端没有接收到数据
 */
public class LandingServer extends Thread {
    Socket socket;

    public LandingServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                // 1.获取 socket 的输入、输出流对象
                // 将字节流转化为字符缓冲流
                BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStreamWriter socketWriter = new OutputStreamWriter(socket.getOutputStream());
        ) {
            // 2.读取客户端发送的消息。

            String line;
            String[] datas;
            String option;
            String userName;
            String password;
            Properties properties = new Properties();

            // 轮询方式
            while ((line = socketReader.readLine()) != null) {
                // 字符串切割
                datas = line.split(" ");
                // 客户端选择的功能
                option = datas[0];
                // 用户名
                userName = datas[1];
                // 密码
                password = datas[2];

                // 先把配置文件的信息先加载到 properties 文件上。
                properties.load(new FileReader("socket\\Resources\\users"));
                if ("a".equalsIgnoreCase(option)) {
                    // 注册
                    // 把用户名与密码保存到 Properties 中
                    if (!properties.containsKey(userName)) {
                        // 如果该用户名不存在，我就把用户的信息添加上去。
                        properties.setProperty(userName, password);
                        // 把用户的注册信息保存到文件上。
                        properties.store(new FileWriter("socket\\Resources\\users"), "users info");
                        socketWriter.write("恭喜你,注册成功\r\n");
                    } else {
                        // 如果用户名已经存在了，那么提示客户端用户名已经存在，请重新注册
                        socketWriter.write("该用户名已经存在，请重新输入！！\r\n");
                    }
                } else if ("b".equalsIgnoreCase(option)) {
                    // 登录
                    String tempPassword = properties.getProperty(userName);
                    if (tempPassword == null) {
                        socketWriter.write("没有该用户名存在，请重新登录!\r\n");
                    } else {
                        if (tempPassword.equals(password)) {
                            socketWriter.write("欢迎" + userName + "登录成功!\r\n");
                        } else {
                            socketWriter.write("你的密码有误，请重新输入!\r\n");
                        }
                    }
                }
                socketWriter.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try (
                // 建立 tcp 的服务端， 并且要监听一个端口
                ServerSocket serverSocket = new ServerSocket(9090)
        ) {
            // 不断的接受用户的请求连接
            while (true) {
                Socket socket = serverSocket.accept();
                // 每个用户都应该开启一个线程为其服务
                new LandingServer(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}