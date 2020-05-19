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
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-10 4:32
 */
public class FileUpload {
    /**
     * 服务端 1
     */
    @Test
    public void service() {
        System.out.println("服务器 启动.....  ");
        try (
                // 1. 创建服务端ServerSocket
                ServerSocket serverSocket = new ServerSocket(6666);
                // 2. 建立连接
                Socket accept = serverSocket.accept();
                // 3.1 获取输入流,读取文件数据
                BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                // 3.2 创建输出流,保存到本地 .
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("socket\\Resources\\copy.jpg"));
        ) {
            // 4. 读写数据
            byte[] b = new byte[1024 << 3];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
            System.out.println("文件上传已保存");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void client() {
        try (
                // 1.创建流对象
                // 1.1 创建输入流,读取本地文件
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.jpg"));
                // 1.2 创建输出流,写到服务端
                Socket socket = new Socket("localhost", 6666);
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        ) {
            //2.写出数据.
            byte[] b = new byte[1024 << 3];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
            // 3.释放资源
            System.out.println("文件上传完毕 ");
            System.out.println("文件发送完毕");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 优化服务端
     */
    @Test
    public void service2() {
        System.out.println("服务器 启动.....  ");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        ServerSocket serverSocket = null;
        try {
            // 1. 创建服务端ServerSocket
            serverSocket = new ServerSocket(6666);
            // 2. 循环接收,建立连接
            while (true) {
                Socket accept = serverSocket.accept();
                /**
                 * 3. socket对象交给子线程处理,进行读写操作
                 * Runnable接口中,只有一个run方法,使用lambda表达式简化格式
                 */
                threadPoolExecutor.submit(() -> {
                    try (
                            //3.1 获取输入流对象
                            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                            //3.2 创建输出流对象, 保存到本地。
                            FileOutputStream fis = new FileOutputStream(System.currentTimeMillis() + ".jpg");
                            BufferedOutputStream bos = new BufferedOutputStream(fis)
                    ) {
                        // 3.3 读写数据
                        byte[] b = new byte[1024 * 8];
                        int len;
                        while ((len = bis.read(b)) != -1) {
                            bos.write(b, 0, len);
                        }
                        System.out.println("文件上传已保存");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public static void service3() throws IOException {
        System.out.println("服务器 启动.....  ");
        // 1. 创建服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2. 循环接收,建立连接
        while (true) {
            Socket accept = serverSocket.accept();
           /*
           3. socket对象交给子线程处理,进行读写操作
               Runnable接口中,只有一个run方法,使用lambda表达式简化格式
            */
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
            threadPoolExecutor.submit(() -> {
                try (
                        //3.1 获取输入流对象
                        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                        //3.2 创建输出流对象, 保存到本地 .
                        FileOutputStream fis = new FileOutputStream(System.currentTimeMillis() + ".jpg");
                        BufferedOutputStream bos = new BufferedOutputStream(fis);
                ) {
                    // 3.3 读写数据
                    byte[] b = new byte[1024 << 3];
                    int len;
                    while ((len = bis.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }
                    System.out.println("back ........");
                    OutputStream out = accept.getOutputStream();
                    out.write("上传成功".getBytes());
                    out.close();
                    //5. 关闭 资源
                    bos.close();
                    bis.close();
                    accept.close();
                    System.out.println("文件上传已保存");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Test
    public void client2() {
        try (
                // 1.创建流对象
                // 1.1 创建输入流,读取本地文件
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.jpg"));
                // 1.2 创建输出流,写到服务端
                Socket socket = new Socket("localhost", 6666);
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        ) {
            //2.写出数据
            byte[] b = new byte[1024 * 8];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            // 关闭输出流,通知服务端,写出数据完毕
            socket.shutdownOutput();
            System.out.println("文件发送完毕");
            // 3. =====解析回写============
            InputStream in = socket.getInputStream();
            byte[] back = new byte[20];
            in.read(back);
            System.out.println(new String(back));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
