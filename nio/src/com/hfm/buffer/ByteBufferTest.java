package com.hfm.buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 16:34
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        System.out.println("=========allocate========");
        // 分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        // 当前缓冲区容量
        System.out.println(byteBuffer.capacity());

        // 当前缓冲区限制，默认缓冲区限制为缓冲区大小
        System.out.println(byteBuffer.limit());
        // 设置当前缓冲区限制
        byteBuffer.limit(10);
        // 缓冲区限制发生变化
        System.out.println(byteBuffer.limit());
        // 但是缓冲区容量大小不会发生改变
        System.out.println(byteBuffer.capacity());

        // 当前缓冲区的位置，默认缓冲区位置起始为0
        System.out.println(byteBuffer.position());
        // 设置缓冲区位置，超出缓冲区限制报错
        // byteBuffer.position(12);

        // 缓冲区存储数据的核心方法

        /// put() 存入数据到缓冲区中
        System.out.println("=========put========");
        byte b1 = 98;
        // 存储一个 byte 数据，默认存入第一个即position =0，存入后 position =1，再次存储数据默认从 position =1
        byteBuffer.put(b1);
        System.out.println(Arrays.toString(byteBuffer.array()));

        // 在指定位置加入一个 byte 类型数据 position =5
        byteBuffer.put(5, b1);
        System.out.println(Arrays.toString(byteBuffer.array()));

        byte[] bs = "ABCDEFG".getBytes();
        // 存储一个字节数组，position =1,对 byteBuffer.put(5, b1);存入的数据进行了覆盖
        byteBuffer.put(bs);
        System.out.println(Arrays.toString(byteBuffer.array()));

        // 存储字节数组部分，存储位置从 position =9
        byteBuffer.put(bs, 0, 2);
        System.out.println(Arrays.toString(byteBuffer.array()));

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        /// 切换到读取数据模式，position 指针复位，limit = position;
        byteBuffer.flip();
        // buffer 长度不变
        System.out.println(byteBuffer.capacity());
        // limit 变为存储数据的最后一个元素
        System.out.println(byteBuffer.limit());
        // position =0
        System.out.println(byteBuffer.position());

        System.out.println(Arrays.toString(byteBuffer.array()));
        // 再次存入从头开始存
//        byteBuffer.put((byte) 1);
//        System.out.println(Arrays.toString(byteBuffer.array()));

        /// get() 获取数据到缓冲区中,默认获取第一个，并且一个接一个
        System.out.println("=========get========");
        System.out.println(byteBuffer.position());
        // 98
        System.out.println(byteBuffer.get());
        // buffer 长度不变
        System.out.println(byteBuffer.capacity());
        // limit 不变
        System.out.println(byteBuffer.limit());
        // position = 1
        System.out.println(byteBuffer.position());
        // 65
        System.out.println(byteBuffer.get());
        // position = 2
        System.out.println(byteBuffer.position());

        System.out.println("=================");
        // 再切换到读取数据模式
        byteBuffer.flip();
        System.out.println(byteBuffer.capacity());
        // limit = postion
        System.out.println(byteBuffer.limit());
        // position 重新复位
        System.out.println(byteBuffer.position());
        System.out.println("=================");

        // rewind方法 倒带此缓冲区。将位置设为 0， 取消设置的 mark
        // 使缓冲区准备好重新读取它已包含的数据：它保持不变限制并将位置设置为零。
        // 可重复读数据,postion =0 ,limit = capacity
        System.out.println("=========rewind========");
        byteBuffer.rewind();
        // buffer 长度不变
        System.out.println(byteBuffer.capacity());
        // limit 不变
        System.out.println(byteBuffer.limit());
        // position = 0
        System.out.println(byteBuffer.position());

        System.out.println(byteBuffer.get());
        byteBuffer.flip();
        System.out.println(byteBuffer.capacity());
        // limit =1
        System.out.println(byteBuffer.limit());
        // position = 1
        System.out.println(byteBuffer.position());
        // System.out.println(byteBuffer.get(3));
        System.out.println(Arrays.toString(byteBuffer.array()));

        /// clear(),缓冲区中的数据还在，并没有被清空，里面的数据处于被遗忘的状态
        System.out.println("=========clear========");
        byteBuffer.clear();
        System.out.println(byteBuffer.capacity());
        // limit =20
        System.out.println(byteBuffer.limit());
        // position =0
        System.out.println(byteBuffer.position());
        System.out.println(Arrays.toString(byteBuffer.array()));
        // 还是可以获取
        System.out.println(byteBuffer.get());

        /// mark 标记position位置，reset 恢复position 位置
        // position = 1 标记 position 的位置
        System.out.println(byteBuffer.position());
        byteBuffer.mark();
        System.out.println(byteBuffer.get());
        // position =2
        System.out.println(byteBuffer.position());
        // 回复 mark 标记的 position 位置
        byteBuffer.reset();
        // position =1
        System.out.println(byteBuffer.position());

        // position 后面是否有元素
        byteBuffer.hasRemaining();
        // position 到 limit 之间可用元素的个数 limit - position
        System.out.println(byteBuffer.remaining());
    }
}
