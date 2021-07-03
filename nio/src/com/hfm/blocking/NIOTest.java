package com.hfm.blocking;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

import static java.nio.file.StandardOpenOption.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 22:14
 */
public class NIOTest {
    /**
     * 客户端
     */
    @Test
    public void client() {
        try (
                // 1.获取通道
                SocketChannel open = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));
                // 建立本地文件的通道，将文件写出
                FileInputStream fileInputStream = new FileInputStream("D:\\Code\\core-java\\nio\\Resources\\text.txt");
                FileChannel fileChannel = fileInputStream.getChannel()
        ) {
            // 切换成非阻塞模式
            open.configureBlocking(false);

            // 2.创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                // 缓冲区设置为读取状态
                byteBuffer.flip();
                // 通过网络 channeL 通道传递数据
                open.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端
     */
    @Test
    public void service() {
        try (
                // 1.创建服务端通道
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                // 创建输出通道
                FileChannel fileChannel = FileChannel.open(Paths.get("D:\\Code\\core-java\\nio\\Resources\\copy6.txt"), WRITE, READ, CREATE)
        ) {
            // 2.设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            // 3.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8000));

            // 4.获取选择器对象
            Selector selector = Selector.open();

            // 6. 将接受到的通道注册到选择器上，指定监听事件
            // ops: 选择键
            //    public static final int OP_READ = 1; 监听读取事件
            //    public static final int OP_WRITE = 4; 监听写入事件
            //    public static final int OP_CONNECT = 8; 监听连接事件
            //    public static final int OP_ACCEPT = 16; 监听接收事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            // 7.轮询式获取选择器上已经准备就绪的事件
            while (selector.select() > 0) {
                // 获取当前选择器中所有注册的选择键
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 获取选择键集合的迭代器并进行迭代
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    // 获取选择键，即准备就绪的事件
                    SelectionKey selectionKey = iterator.next();
                    // 判断选择键的类型，注册的是监听读的选择键，因此需要判断是否是读的选择键
                    // 注册的是什么选择键，就判断是否为该选择键
                    if (selectionKey.isReadable()) {
                        // 获取客户端可读的连接
                        Channel accept = selectionKey.channel();

                        if (accept instanceof SocketChannel) {
                            // 创建缓冲区，用于存储数据
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            while (((SocketChannel) accept).read(byteBuffer) != -1) {
                                // 设置为读取数据模式
                                byteBuffer.flip();
                                // 将缓冲区的数据传入输出通道
                                fileChannel.write(byteBuffer);
                                byteBuffer.clear();
                            }
                        }
                    }
                    // 判断选择键的类型
                    if (selectionKey.isConnectable()) {

                    }
                    // 通道上是否有可接受的连接
                    if (selectionKey.isAcceptable()) {
                        // 获取服务器端可接受的连接
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();

                        // 获取与服务器端连接的客户端
                        SocketChannel accept = server.accept();

                        // 客户端切换成非阻塞模式
                        accept.configureBlocking(false);
                        // 将客户端的通道注册到选择器上，这样客户端通道才会被正常监听
                        accept.register(selector, SelectionKey.OP_READ);
                    }
                    // 判断选择键的类型
                    if (selectionKey.isWritable()) {

                    }
                    // 判断选择键的类型
                    if (selectionKey.isValid()) {

                    }
                    // 最后需要注销已经处理的通道
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
