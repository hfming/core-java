package com.hfm.string;

/**
 * 缓存字符串类
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class StringBufferAndStringBuilderTest {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        // 初始容量
        System.out.println(buffer.capacity());
        // 不能使用 length() 方法，该方法是返回字符冲类中内容的长度
        System.out.println(buffer.length());
        // 在缓冲区的尾部添加新的文本对象
        // 容量不够时，会自动自动增长 1倍 + 2
        buffer.append("SSS777SSSSSSSSSSS");
        System.out.println(buffer.capacity());
        // 在指定的下标位置添加新的文本对象
        buffer.insert(0, "int");
        System.out.println(buffer);
        // 指定开始于结束的索引值间的字符串缓冲区
        buffer.delete(0, 1);
        System.out.println(buffer);
        // 指定索引值删除字符
        buffer.deleteCharAt(7);
        System.out.println(buffer);

        StringBuffer sb = new StringBuffer("hello java hello java");
        System.out.println("查找指定字符串第一次出现的索引值：" + sb.indexOf("java"));
        System.out.println("查找指定字符串最后一次出现的索引值：" + sb.lastIndexOf("java"));
        System.out.println("子串：" + sb.substring(6, 10));
        // 指定开始与结束的索引值，把内容替换成指定的字符串。
        sb.replace(6, 10, "javascript");
        // 指定索引值替换字符
        sb.setCharAt(4, 'l');
        // 返回这个容器的字符串
        String content = sb.toString();
        System.out.println("字符串的内容：" + content);
    }
}