package com.hfm.valuepass;

import java.util.Arrays;

/**
 * @author hfm
 * @version 1.01 2020-04-13 17:30
 * @date 2020/4/13
 */
public class StringExchangeValue2 {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    String[] strs = new String[]{"ggg","sds"};

    public static void main(String[] args) {
        StringExchangeValue2 s2 = new StringExchangeValue2();
        s2.change(s2.str, s2.ch,s2.strs);
        // dood
        System.out.println(s2.str);
        // best
        System.out.println(s2.ch);
        // {"aaa","sds"}
        System.out.println(Arrays.toString(s2.strs));
    }

    public void change(String str, char[] ch,String[] strs) {
        str = "Good";
        ch[0] = 'b';
        strs[0] = "aaa";
    }
}
