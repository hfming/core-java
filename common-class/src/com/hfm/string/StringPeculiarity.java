package com.hfm.string;

import com.hfm.entity.Goods;
import org.junit.jupiter.api.Test;

/**
 * String 特性 不可变形
 *
 * @author hfm
 * @version 1.01 2020-04-13 16:34
 * @date 2020/4/13
 */
public class StringPeculiarity {
    public static void main(String[] args) {
        // 字面量创建 String 对象
        String str1 = "abc";
        String str2 = "abc";
        // 内存地址相同
        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);

        str1 = "bcd";
        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);

        str1 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str2 == str3);
        System.out.println(str2 == str4);
        System.out.println(str3 == str4);

        System.out.println("==================");
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println(str2.equals(str3));
        System.out.println(str2.equals(str4));
        System.out.println(str3.equals(str4));

        String str5 = str4.replace("a", "f");
        // 调用 String 方法改变字符串时也会重写在字符串常量池中创建新的字符串
        // str4 没有发生变化
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str4 == str5);

        System.out.println("==================");
        Goods good1 = new Goods("矿泉水", 12);
        Goods good2 = new Goods("矿泉水", 4);
        // 都是字符串常量池中的
        System.out.println(good1.getName() == good2.getName());

        // 面试体：String s = new String("abc"); 在内存中创建了几个对象
        // 2个，一个是在堆内存中的String 对象，另外一个是 字符串常量池中的 字节/字符数组
    }

    @Test
    public void test() {
        String str1 = "abc";
        String str2 = "ABC";

        String str3 = "abcABC";
        String str4 = "abc" + "ABC";
        String str5 = str1 + "ABC";
        String str6 = "abc" + str2;
        String str7 = str1 + str2;

        // 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。只要其中有一个是变量，结果就在堆中。
        // true
        System.out.println(str3 == str4);
        // false
        System.out.println(str3 == str5);
        // false
        System.out.println(str3 == str6);
        // false
        System.out.println(str3 == str7);
        // false
        System.out.println(str4 == str5);
        // false
        System.out.println(str4 == str6);
        // false
        System.out.println(str4 == str7);
        // false
        System.out.println(str5 == str6);
        // false
        System.out.println(str5 == str7);
        // false
        System.out.println(str6 == str7);

        // 如果拼接的结果调用intern()方法，返回值就在常量池中。
        String str8 = str5.intern();
        System.out.println(str5 == str8);
    }
}
