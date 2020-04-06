package com.hfm.object;

import java.io.UnsupportedEncodingException;

/**
 * String 构造函数
 * @author hfm
 * @version 1.01 2020-03-29 15:13
 * @date 2020/3/29
 */
public class StringConstructTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 直接赋值创建字符串
        String str1 = "直接赋值法";
        // 输出内容
        System.out.println(str1);

        // 通过创建对象创建字符串
        String str2 = new String("通过创建对象创建字符串");
        // 输出内容
        System.out.println(str2);

        // 通过字节数组创建字符串
        byte[] bytes = new byte[]{23,32,23,23,73,89,54,67};
        String str3 = new String(bytes);
        System.out.println(str3);

        // 设定字符编码
        String str4 = new String(bytes,"GBK");
        System.out.println(str4);

        // 通过字符数组创建字符串
        char[] chars = new char[]{'A', 'b', 'c'};
        String str5 = new String(chars);
        System.out.println(str5);
    }
}
