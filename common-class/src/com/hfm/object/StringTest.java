package com.hfm.object;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * String 类的使用方法
 *
 * @author hfm
 */
public class StringTest {

    public static void main(String[] args) throws IOException {
        /**
         * 定义字符串
         */
        // 定义字符串方式一：直接赋值
        String str = "Str ing";
        // 定义字符串方式二：new 一个字符串
        String str2 = new String("list");
        /**
         * 获取
         */
        // 获取第N位的字符
        System.out.println(str.charAt(0));
        // 获取第N位的字符的ASCLL码
        System.out.println(str.codePointAt(1));
        // 获取第N-1位的字符的ASCLL码
        System.out.println(str.codePointBefore(1));
        // 获取第a位到第b位字符个数
        System.out.println(str.codePointCount(1, 5));
        // 获取String的hashCode
        System.out.println("String".hashCode());
        // 获取指定字符的第一次出现的字符串中返回索引。
        System.out.println("Stringiii".indexOf('i'));
        // 获取指定字符在该字符串中第N次出现的索引
        System.out.println("StringSS".indexOf('i', 3));
        // 获取指定字符串在该字符串中第一次出现的索引
        System.out.println("String".indexOf("i"));
        // 获取指定字符串在该字符串中第N次出现的索引
        System.out.println("StringSS".indexOf("S", 3));
        // 获取指定字符的最后一次次出现的字符串中返回索引。
        System.out.println("Stringiii".lastIndexOf('i'));
        // 获取指定字符在该字符串中最后一次第N次出现的索引
        System.out.println("StringSS".lastIndexOf('i', 3));
        // 获取指定字符串在该字符串中最后一次出现的索引
        System.out.println("String".lastIndexOf("i"));
        // 获取指定字符串在该字符串中最后一次第N次出现的索引
        System.out.println("StringSS".lastIndexOf("S", 3));
        // 获取字符串长度
        System.out.println("Stirng".length());

        System.out.println("===============================================================");
        /**
         * 判断
         */
        // 判断是否包含指定字符串子串
        System.out.println(str.contains("S"));
        // 判断是否以之是否以指定字符串结束
        System.out.println(str.endsWith("S"));
        // 判断两个字符串是否相同,不忽略大小写
        System.out.println("s".equals(str));
        // 判断两个字符串是否相同,忽略大小写
        System.out.println("S".equalsIgnoreCase(str));
        // 判断是否为空字符串
        System.out.println("".isEmpty());
        // 判断这个字符串是否匹配给定的正则表达式。
        System.out.println("avdf".matches("a-z"));
        // 判断是否以指定字符串开始
        System.out.println("String".startsWith("S"));
        // 从N位起，判断是否以指定字符串开始
        System.out.println("String".startsWith("S", 0));
        // 判断是否相等，将该字符串与指定的字符序列进行比较。(字符串序列化后进行对比)
        System.out.println(str.contentEquals("String"));
        // 判断是否相等，将该字符串与指定的StringBuffer进行比较。
        System.out.println("String".contentEquals(new StringBuffer("String")));
        // 判断两个字符串区域是否相等。
        System.out.println("String".regionMatches(false, 1, "String", 1, 2));
        // 判断两个字符串区域是否相等。
        System.out.println("String".regionMatches(1, "String", 1, 3));
        System.out.println("===============================================================");
        /**
         * 操作方法
         */
        // 字符串拼接
        System.out.println(str.concat("A"));
        // 将字符串中的指定字符进行替换
        System.out.println("String".replace('S', 's'));
        // 将这个字符串的每个子字符串替换为指定的文字替换序列，以匹配文本目标序列。
        System.out.println("String".replace("Str", "s"));
        // 将这个字符串的每个子字符串替换为给定的正则表达式和给定的替换。
        System.out.println("String".replaceAll("Str", "si"));
        // 将这个字符串的第一个子字符串替换为给定的正则表达式和给定的替换。
        System.out.println("String".replaceFirst("Str", "1"));
        // 返回一个新的字符序列，这是序列的子序列
        System.out.println("String".subSequence(0, 5));
        // 返回一个新字符串，该字符串是该字符串的子字符串。从N位起开始截取。
        System.out.println("String".substring(3));
        // 从N位起截取M位，返回一个新字符串，该字符串是该字符串的子字符串
        System.out.println("String".substring(0, 4));
        // 将这个字符串分割为给定正则表达式的匹配项。
        System.out.println(Arrays.toString("String,Stirng".split(",")));
        // 将这个字符串分割N次为给定正则表达式的匹配项。
        System.out.println(Arrays.toString("String|String".split("|", 3)));
        // 将这个字符串转换为一个新的字符数组。
        System.out.println(Arrays.toString("String".toCharArray()));
        // 使用默认语言环境的规则将字符串中的所有字符转换为小写。
        System.out.println("String".toLowerCase());
        // 使用给定地区的规则将字符串中的所有字符转换为小写。
        System.out.println("String".toLowerCase(new Locale("en")));
        // 使用默认语言环境的规则将字符串中的所有字符转换为大写。
        System.out.println("String".toUpperCase());
        // 使用给定地区的规则将字符串中的所有字符转换为大写。
        System.out.println("String".toUpperCase(new Locale("en")));

        char[] cha = new char[6];
        // 将字符串中的字符复制到目标字符数组中。
        "string".getChars(0, 6, cha, 0);
        System.out.println(Arrays.toString(cha));
        System.out.println("===============================================================");
        /**
         * 其他获取方法
         */
        /* 比较两个字符串的字母顺序进行。
         * 这个比较基于字符串中每个字符的Unicode值。
         * 由这个字符串对象所表示的字符序列，将字典上的字符序列与由参数字符串表示的字符序列进行比较。
         * 如果这个字符串对象在字符串中在参数字符串前面出现，那么结果就是一个负整数。
         * 如果这个字符串对象字典式地跟随参数字符串，结果就是一个正整数。
         * 如果弦是相等的，结果是零;当equals(Object)方法返回true时，compareTo返回0。
         * 这是字典顺序的定义。
         * 如果两个字符串是不同的，那么它们在某个索引中有不同的字符，它们是两个字符串的有效索引，或者它们的长度是不同的，或者两者都是。
         * 如果它们在一个或多个索引位置上有不同的字符，那么k是最小的索引;
         * 然后，在位置k中字符的字符串具有较小的值，通过使用小于运算符来确定，它在另一个字符串前面。
         * */
        // 比较两个字符串字典
        System.out.println(str.compareTo("s"));
        // 比较两个字符串字典 ,忽略大小写
        System.out.println(str.compareToIgnoreCase("str"));
        // 返回一个字符串，该字符串表示指定的数组中的字符序列。
        System.out.println(str.copyValueOf(new char[]{'c', 'd'}));
        // 返回一个字符串，该字符串表示指定的数组中的字符序列。
        System.out.println(str.copyValueOf(new char[]{'c', 'd'}, 0, 1));
        // 使用指定的格式字符串和参数返回格式化的字符串。
        System.out.println(str.format("Hi,%s:%s.%s", "王南", "王力", "王张"));
        System.out.println(str.format("Hi,%s", "王力"));
        str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");
        // 使用指定的语言环境、格式字符串和参数返回格式化的字符串。
        System.out.println(str.format("UNIX", "Hi,%s", "王力"));
        // 使用平台的缺省(默认)字符集将此字符串编码为字节序列，将结果存储到一个新的字节数组中
        System.out.println(str.getBytes());
        System.out.println("A".getBytes());
        System.out.println("A".getBytes("UTF-8"));
        // 使用给定的字符集将此字符串编码为字节序列，将结果存储到一个新的字节数组中。
        // 使用命名的charset将这个字符串编码成一个字节序列，将结果存储到一个新的字节数组中。
        System.out.println("String".intern());//返回一个字符串对象的正则表示处理后的字符串。
        // System.out.println("String".offsetByCodePoints(2, 'g'));//返回该字符串中的索引，该索引由codepoin托付设置代码点对给定索引进行偏移。
        System.out.println("String".toString());
        // 字符串首尾去空串
        System.out.println(" String string ".trim());
        // 返回Boolean的字符串形式
        System.out.println(String.valueOf(false));
        // 返回字符的字符串形式
        System.out.println(String.valueOf('A'));
        // 返回字符数组的字符串形式
        System.out.println(String.valueOf(new char[]{'A', 'c'}));
        // 返回字符数组(N位起，M个)的字符串形式
        System.out.println(String.valueOf(new char[]{'A', 'C', 'c'}, 0, 3));
        // 返回double的字符串形式
        System.out.println(String.valueOf(3.25));
        // 返回float的字符串形式
        System.out.println(String.valueOf(3.14F));
        // 返回int的字符串形式
        System.out.println(String.valueOf(3));
        // 返回long的字符串形式
        System.out.println(String.valueOf(34L));
        // 返回Object的字符串形式
        System.out.println(String.valueOf(new Object()));
    }
}
