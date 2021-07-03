package com.hfm.ecodinganddecoding;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 20:44
 */
public class CharSetTest {
    public static void main(String[] args) {
        // 获取所有支持的字符集
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        // 获取 entrySet
        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        // 遍历 entry
        for (Map.Entry<String, Charset> entry : entries) {
            System.out.println(entry);
        }

        // 获取 CharSet 集合
        Charset charset = Charset.forName("UTF-8");
//        Charset charset2 = StandardCharsets.UTF_8;

        // 获取编码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
        // 获取解码器
        CharsetDecoder charsetDecoder = charset.newDecoder();

        // 创建字符缓冲区
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("编码");
        // 读取状态
        charBuffer.flip();

        try {
            // 编码,字符转字节
            ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
            for (byte b : byteBuffer.array()) {
                System.out.print(b);
            }
            System.out.println();

            // 解码，字节转字符
            CharBuffer decode = charsetDecoder.decode(byteBuffer);
            decode.flip();
            for (char c : decode.array()) {
                System.out.print(c);
            }
            System.out.println();
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }
}
