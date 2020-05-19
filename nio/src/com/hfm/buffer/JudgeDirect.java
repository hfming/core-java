package com.hfm.buffer;

        import java.nio.ByteBuffer;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 18:23
 */
public class JudgeDirect {
    public static void main(String[] args) {
        // 创建间接缓冲区对象
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        // 判断是否是直接缓冲区 false 间接缓冲区
        System.out.println(byteBuffer.isDirect());

        // 创建直接缓冲区对象
        System.out.println(ByteBuffer.allocateDirect(1).isDirect());
    }
}
