package com.hfm.regular;

import org.junit.jupiter.api.Test;

public class Regular {
    /**
     * 自定义字符串匹配 []
     */
    @Test
    public void regular3() {
        // 范围词，范围词也只能匹配一个字符，需要配合数量词进行匹配
        System.out.println("a".matches("^[a]$")); // ^ 开始 $ 结束
        System.out.println("a".matches("[a]"));
        System.out.println("aa".matches("[a]+"));
        System.out.println("abc".matches("[abc]{3,}"));
        System.out.println("abc".matches("[abc]+"));
        System.out.println("dshfshfu1".matches("[^abc]+"));
        System.out.println("abcdsaA".matches("[a-z]{5,}"));
        System.out.println("abcdsaA12".matches("[a-zA-Z]{5,}"));
        System.out.println("abcdsaA12".matches("[a-zA-Z0-9]{5,}"));
        System.out.println("abdxyz".matches("[a-c[x-z]]+"));
        System.out.println("bcbcbc".matches("[a-z&&[b-c]]{5,}"));
        System.out.println("tretrt".matches("[a-z&&[^b-c]]{5,}"));
    }

    /**
     * 数量词
     */
    @Test
    public void regular2() {
        // 数量字符
        // true,数字只出现一次
        System.out.println("？一次或一次也没有:" + ("1".matches("\\d?")));
        // false,数字出现多次
        System.out.println("？一次或一次也没有:" + ("11".matches("\\d?")));
        // false,数字没有出现
        System.out.println("？一次或一次也没有:" + ("w".matches("\\d?")));
        // true,单词字符只出现一次
        System.out.println("？一次或一次也没有:" + ("w".matches("\\w?")));
        // false.单词字符出现多次
        System.out.println("？一次或一次也没有:" + ("aa".matches("\\w?")));
        // ?
        System.out.println("？一次或一次也没有:" + ("cdcd".matches("^\\w*$")));

        System.out.println("* 零次或多次:" + ("12".matches("[\\d]*")));
        // ?
        System.out.println("* 零次或多次:" + ("1".matches("[\\d]*")));
        // ?
        System.out.println("* 零次或多次:" + ("1".matches("[\\w]*")));

        System.out.println("+ 至少一次:" + ("12".matches("\\d+")));
        System.out.println("+ 至少一次:" + ("a".matches("\\d+")));
        System.out.println("+ 至少一次:" + ("12".matches("\\w+")));
        System.out.println("+ 至少一次:" + ("a".matches("\\w+")));
        System.out.println("+ 至少一次:" + ("^".matches("\\W+")));
        System.out.println("+ 至少一次:" + ("a".matches("\\W+")));

        System.out.println("{n} 恰好n次:" + ("121".matches("\\d{3}")));
        System.out.println("{n,} 至少出现n次:" + ("121".matches("\\d{3,}")));
        System.out.println("{n,m} 至少出现 n~ m次 :" + ("1212111".matches("\\d{3,6}")));
    }

    /**
     * 预定义字符串
     */
    @Test
    public void regular1() {
        // 预定义字符
        // 注意： 一个预定于字符只能匹配一个字符，除非预定义字符串配合了数量词使用。
        // true
        System.out.println(". 表示任何字符：" + ("%".matches(".")));
        // true,+ 号表示多个出现
        System.out.println(". 表示任何字符：" + ("%sdsd".matches(".+")));
        // false,一个 . 表示一个字符，不能匹配多个
        System.out.println(". 表示任何字符：" + ("%sdsd".matches(".")));

        // false,a 不是数字
        System.out.println("\\d 代表了数字：" + ("a".matches("\\d")));
        // true
        System.out.println("\\d 代表了数字：" + ("4".matches("\\d")));
        // false,一个预定于字符只能匹配一个字符
        System.out.println("\\d 代表了数字：" + ("4a".matches("\\d")));
        // true
        System.out.println("\\d 代表了数字：" + ("4a4".matches("\\d.\\d")));

        // true
        System.out.println("\\D 代表了非数字：" + ("@".matches("\\D")));
        // false
        System.out.println("\\D 代表了非数字：" + ("4".matches("\\D")));

        // 空格、制表、换行都是空白字符
        // true
        System.out.println("\\s 代表了空白字符：" + ("\n".matches("\\s")));
        System.out.println("\\s 代表了空白字符：" + ("\t".matches("\\s")));
        System.out.println("\\s 代表了空白字符：" + ("\r".matches("\\s")));
        // false
        System.out.println("\\s 代表了空白字符：" + ("".matches("\\s")));
        // true
        System.out.println("\\s 代表了空白字符：" + (" ".matches("\\s")));
        // false
        System.out.println("\\s 代表了空白字符：" + ("Asds".matches("\\s")));

        // false
        System.out.println("\\S 代表了非空白字符：" + ("a".matches("\\S")));

        // a-z,A-Z,0-9,_
        System.out.println("\\w 代表了单词字符：" + ("_".matches("\\w")));
        // false
        System.out.println("\\W 代表了非单词字符：" + ("中".matches("\\w")));

        // false
        System.out.println("\\W 代表了非单词字符：" + ("a".matches("\\W")));
        // true
        System.out.println("\\W 代表了非单词字符：" + ("中".matches("\\W")));
    }
}