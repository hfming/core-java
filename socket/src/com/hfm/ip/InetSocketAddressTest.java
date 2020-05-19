package com.hfm.ip;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-10 2:57
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress hfm = new InetSocketAddress("HFM", 8080);

        System.out.println(hfm.getAddress());
        System.out.println(hfm.getHostName());
        System.out.println(hfm.getPort());
        System.out.println(hfm.getHostString());
    }

    @Test
    public void send() {
        try (
                // 1.创建TCP 通道
                DatagramChannel datagramChannel = DatagramChannel.open()
        ) {
            // 2.转化为非阻塞通道
            datagramChannel.configureBlocking(false);
            // 3.创建缓冲区，用于存储数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 存储要发送的数据
            byteBuffer.put("TCP发送数据".getBytes());
            // 设置为读取模式
            byteBuffer.flip();
            // 4.发送数据到特定服务器，特定通道
            datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 8000));
            // 缓冲区恢复原状
            byteBuffer.clear();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void receive() {
        try (
                // 1.创建TCP 通道
                DatagramChannel datagramChannel = DatagramChannel.open();
        ) {
            // 2.转化成非阻塞式
            datagramChannel.configureBlocking(false);
            datagramChannel.bind(new InetSocketAddress(8000));
            // 3.获取selecetor 选择器对象
            Selector selector = Selector.open();
            // 4.注册通道
            datagramChannel.register(selector, SelectionKey.OP_READ);

            // 创建缓冲区用于存储数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 5.采用轮询方式获取选择器中已经准备就绪的通道
            while (selector.select() > 0) {
                // 6.获取已经准备就绪的通道
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 获取迭代器对象
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isReadable()) {
                        datagramChannel.receive(byteBuffer);
                        // 设置成读取模式
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                        byteBuffer.clear();
                    }
                    if (selectionKey.isValid()) {

                    }
                    if (selectionKey.isWritable()) {

                    }
                    if (selectionKey.isAcceptable()) {

                    }
                    if (selectionKey.isConnectable()) {

                    }
                    // 删除已经处理的通道
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
