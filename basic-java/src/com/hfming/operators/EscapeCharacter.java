package com.hfming.operators;

/**
 * 转义字符
 * 数字和字符的对照关系表（编码表）：
 * ASCII码表：American Standard Code for Information Interchange，美国信息交换标准代码。
 * Unicode码表：万国码。也是数字和符号的对照关系，开头0-127部分和ASCII完全一样，但是从128开始包含有更多字符。
 *
 * @author hfm
 */
public class EscapeCharacter {
    public static void main(String[] args) {
        System.out.println("\'");
        System.out.println("\b");
        System.out.println("\t");
        System.out.println("\r");
        System.out.println("\n");
        System.out.println("hello\r\nworld");
    }
}
