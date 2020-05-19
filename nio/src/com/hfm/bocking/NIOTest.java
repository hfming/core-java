package com.hfm.bocking;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
                FileInputStream fileInputStream = new FileInputStream("D:\\Code\\core-java-simple\\nio\\Resources\\text.txt");
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
                FileChannel fileChannel = FileChannel.open(Paths.get("D:\\Code\\core-java-simple\\nio\\Resources\\copy6.txt"), WRITE, READ, CREATE)
        ) {
            // 2.设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            // 3.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8000));

            // 4.获取选择器对象
            Selector selector = Selector.open();

            // 6. 将接受到的通道注册到选择器上
            // ops: 选择键
            //    public static final int OP_READ = 1; 监听读取事件
            //    public static final int OP_WRITE = 4; 监听写入事件
            //    public static final int OP_CONNECT = 8; 监听连接事件
            //    public static final int OP_ACCEPT = 16; 监听接收事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            // 8.创建缓冲区，用于存储数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            // 7.轮询式获取选择器上已经准备就绪的事件
            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isReadable()) {
                        SocketChannel accept = serverSocketChannel.accept();
                        // 切换成非阻塞模式
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ);
                        while (accept.read(byteBuffer) != -1) {
                            // 设置为读取数据模式
                            byteBuffer.flip();
                            // 将缓冲区的数据传入输出通道
                            fileChannel.write(byteBuffer);
                            byteBuffer.clear();
                        }
                    }
                    if (selectionKey.isConnectable()) {

                    }
                    if (selectionKey.isAcceptable()) {

                    }
                    if (selectionKey.isWritable()) {

                    }
                    if (selectionKey.isValid()) {

                    }
                    // 最后需要注销已经处理的通道
                    iterator.remove();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
