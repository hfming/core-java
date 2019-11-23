package com.hfming.object;

/**
 * 缓存字符串类
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class StringBufferAndStringBuilderTest {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        // 在缓冲区的尾部添加新的文本对象
        buffer.append("S");
        // 在指定的下标位置添加新的文本对象
        buffer.insert(0, "int");
        // 指定开始于结束的索引值间的字符串缓冲区
        buffer.delete(0, 1);
        // 指定索引值删除字符
        buffer.deleteCharAt(7);

        StringBuffer sb = new StringBuffer("hello java hello java");
        System.out.println("查找指定字符串第一次出现 的索引值：" + sb.indexOf("java"));
        System.out.println("查找指定字符串最后一次出现 的索引值：" + sb.lastIndexOf("java"));
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