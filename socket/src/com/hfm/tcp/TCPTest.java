package com.hfm.tcp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP Demo
 * tcp的特点：
 * * 1.tcp协议通讯是面向连接的，tcp的客户端一旦建立，马上要与服务端建立连接。在数据传输之前一定要建立连接。
 * * 2.tcp协议在连接中传输大数据量,tcp是基于IO流进行数据传输。(UDP是基于数据包进行数据传输的)
 * * 3.通过三次握手机制连接，可靠协议(保证数据传输的完整性)
 * * 4.因为tcp是面向连接的，所以效率稍低.
 * * 5.tcp协议是分客户端与服务端。
 * 文件传输等,QQ聊天(通过服务器转发消息)
 *
 * @author hfm
 */
public class TCPTest {
    /**
     * 最简单的 服务端，仅仅只能接受客户端请求一次
     */
    @Test
    public void service1() {
        System.out.println("服务端 - 数据开始接收！");
        try (
                // 1.创建服务端对象，监听端口号 9090
                ServerSocket serversocket = new ServerSocket(9090);
                // 2.接受客户端的连接，阻塞型方法，必须有值下面的才会运行
                Socket socket = serversocket.accept();
                // 3.创建输入流对象(ServerSocket并没有输入流对象)，应该接受客户端的连接
                InputStream inputStream = socket.getInputStream()
        ) {
            // 创建字节数组对象存储数据
            byte[] b = new byte[1024];
            int length;
            // 接受客户端传入的数据
            while ((length = inputStream.read(b)) != -1) {
                // 可能会有乱码现象 可以使用 ByteArrayOutputStream 解决乱码问题
                System.out.println(new String(b, 0, length));
            }
            System.out.println("服务端 - 数据接收成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 最简单的客户端，仅仅只能先服务端请求一次
     */
    @Test
    public void client1() {
        System.out.println("客户端 - 数据正在发送！");
        try (
                // 1.创建客户端对象
                Socket socket = new Socket("127.0.0.1", 9090);
                // 2.创建IO流对象(输出流对象)
                OutputStream outputStream = socket.getOutputStream();
        ) {
            String str = "TCP通信协议测试！";
            // 3.将数据写出
            outputStream.write(str.getBytes());

            System.out.println("客户端 - 数据发送成功！");
            // 关闭端口
            // 并没有占据文件资源，占据一个端口，不需要关闭输出流，只需要关闭socket即可
            // socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 可以返回信息给客户端的服务端
     */
    @Test
    public void service2() {
        System.out.println("服务端 - 数据开始接收！");
        try (
                // 1.创建服务端对象，监听端口号 9090
                ServerSocket serversocket = new ServerSocket(9090);
                // 2.接受客户端的连接，阻塞型方法，必须有值下面的才会运行
                Socket socket = serversocket.accept();
                // 3.创建输入流对象(ServerSocket并没有输入流对象)，应该接受客户端的连接
                InputStream inputStream = socket.getInputStream()
        ) {
            // 创建字节数组对象存储数据
            byte[] b = new byte[1024];
            int length;
            // 接受客户端传入的数据
            while ((length = inputStream.read(b)) != -1) {
                // 可能会有乱码现象 可以使用 ByteArrayOutputStream 解决乱码问题
                System.out.println(new String(b, 0, length));
            }
            System.out.println("服务端 - 数据接收成功!");

            // 服务端给客户端发送数据
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("服务端返回信息！".getBytes());
            System.out.println("服务端返回信息！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 可以接收服务端信息的客户端
     */
    @Test
    public void client2() {
        System.out.println("客户端 - 数据正在发送！");
        try (
                // 1.创建客户端对象
                Socket socket = new Socket("127.0.0.1", 9090);
                // 2.创建IO流对象(输出流对象)
                OutputStream outputStream = socket.getOutputStream();
        ) {
            String str = "TCP通信协议测试！";
            // 3.将数据写出
            outputStream.write(str.getBytes());
            System.out.println("客户端 - 数据发送成功！");

            // read方法是阻塞型的，需要给客户端传递一个标志
            // 将客户端输出关闭，表明服务端输入停止，解决read 阻塞问题，之后服务端可以输出数据到客户端，客户端可以接收数据
            socket.shutdownOutput();

            System.out.println("客户端接收消息！");

            // 客户端接收服务端数据
            InputStream inputStream = socket.getInputStream();
            // 创建字节数组对象存储数据
            byte[] b = new byte[1024];
            int length;
            // 接受服务端返回的数据
            while ((length = inputStream.read(b)) != -1) {
                // 可能会有乱码现象 可以使用 ByteArrayOutputStream 解决乱码问题
                System.out.println(new String(b, 0, length));
            }
            System.out.println("客户端接收数据成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 可以返回信息给客户端的服务端
     * 使用 ByteArrayOutputStream 解决可能出现的乱码问题
     */
    @Test
    public void service3() {
        System.out.println("服务端 - 数据开始接收！");
        try (
                // 1.创建服务端对象，监听端口号 9090
                ServerSocket serversocket = new ServerSocket(9090);
                // 2.接受客户端的连接，阻塞型方法，必须有值下面的才会运行
                Socket socket = serversocket.accept();
                // 3.创建输入流对象(ServerSocket并没有输入流对象)，应该接受客户端的连接
                InputStream inputStream = socket.getInputStream();
                // 使用 ByteArrayOutputStream 解决可能出现的乱码问题
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            // 创建字节数组对象存储数据
            byte[] b = new byte[1024];
            int length;
            // 接受客户端传入的数据
            while ((length = inputStream.read(b)) != -1) {
                // 使用 ByteArrayOutputStream 解决乱码问题
                baos.write(b, 0, length);
            }
            System.out.println(baos.toString());
            System.out.println("服务端 - 数据接收成功!");

            // 服务端给客户端发送数据
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("服务端返回信息！".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 可以接收服务端信息的客户端
     * 使用 ByteArrayOutputStream 解决可能出现的乱码问题
     */
    @Test
    public void client3_4() {
        System.out.println("客户端 - 数据正在发送！");
        try (
                // 1.创建客户端对象
                Socket socket = new Socket("127.0.0.1", 9090);
                // 2.创建IO流对象(输出流对象)
                OutputStream outputStream = socket.getOutputStream();
                // 使用 ByteArrayOutputStream 解决可能出现的乱码问题
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            String str = "TCP通信协议测试！";
            // 3.将数据写出
            outputStream.write(str.getBytes());
            System.out.println("客户端 - 数据发送成功！");

            // read方法是阻塞型的，需要给客户端传递一个标志
            // 将客户端输出关闭，表明服务端输入停止，解决read 阻塞问题，之后服务端可以输出数据到客户端，客户端可以接收数据
            socket.shutdownOutput();

            // 客户端接收服务端数据
            InputStream inputStream = socket.getInputStream();
            // 创建字节数组对象存储数据
            byte[] b = new byte[1024];
            int length;
            // 接受服务端返回的数据
            while ((length = inputStream.read(b)) != -1) {
                // 使用 ByteArrayOutputStream 解决乱码问题
                baos.write(b, 0, length);
            }
            System.out.println(baos.toString());

            socket.shutdownInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 服务端不关闭，服务端可以连接多个客户端
     * 可以返回信息给客户端的服务端
     * 使用 ByteArrayOutputStream 解决可能出现的乱码问题
     */
    @Test
    public void service4() {
        System.out.println("服务端 - 数据开始接收！");
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        // 创建字节数组对象存储数据
        byte[] b = new byte[1024];
        int length;
        try (
                // 1.创建服务端对象，监听端口号 9090
                ServerSocket serversocket = new ServerSocket(9090);
                // 使用 ByteArrayOutputStream 解决可能出现的乱码问题
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            while (true) {
                // 2.接受客户端的连接，阻塞型方法，必须有值下面的才会运行
                // 每次获取的都是不同的客户端
                socket = serversocket.accept();
                // 3.创建输入流对象(ServerSocket并没有输入流对象)，应该接受客户端的连接
                inputStream = socket.getInputStream();

                // 接受客户端传入的数据
                while ((length = inputStream.read(b)) != -1) {
                    // 使用 ByteArrayOutputStream 解决乱码问题
                    baos.write(b, 0, length);
                }
                System.out.println(baos.toString());
                System.out.println("服务端 - 数据接收成功!");

                socket.shutdownInput();

                // 服务端给客户端发送数据
                outputStream = socket.getOutputStream();
                outputStream.write("服务端返回信息！".getBytes());

                socket.shutdownOutput();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } finally {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}