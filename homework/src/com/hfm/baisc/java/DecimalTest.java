package com.hfm.baisc.java;

/**
 * 练习: 将以下十进制数转换为十六进制和二进制 123 256 87 62
 * 将以下十六进制数转换为十进制和二进制 0x123 0x25F 0x38 0x62
 *
 * @author hfm
 * @version 1.01 2020-03-18 21:09
 * @date 2020/3/18
 */
public class DecimalTest {
    public static void main(String[] args) {
        // 123 256 87 62 十进制数转换为二进制
        System.out.println(Integer.toBinaryString(123));
        System.out.println(Integer.toBinaryString(256));
        System.out.println(Integer.toBinaryString(87));
        System.out.println(Integer.toBinaryString(62));
        // 123 256 87 62 十进制数转换为十六进制
        System.out.println(Integer.toHexString(123));
        System.out.println(Integer.toHexString(256));
        System.out.println(Integer.toHexString(87));
        System.out.println(Integer.toHexString(62));
        // 0x123 0x25F 0x38 0x62 十六进制数转换为二进制
        System.out.println(Integer.toBinaryString(0x123));
        System.out.println(Integer.toBinaryString(0x25F));
        System.out.println(Integer.toBinaryString(0x38));
        System.out.println(Integer.toBinaryString(0x62));
        // 0x123 0x25F 0x38 0x62 十六进制数转换为十进制
        System.out.println(Integer.toString(0x123, 10));
        System.out.println(Integer.toString(0x25F, 10));
        System.out.println(Integer.toString(0x38, 10));
        System.out.println(Integer.toString(0x62, 10));
    }
}
