package com.hfm.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class MailRegular {
    public static void main(String[] args) {
        String str = " 有事没事联系：1122423@qq.cn 有事没事联系：1122423@qq.com 有事没事联系：1122423@qq.com "
                + "有事没事联系：1122423@qq.com 有事没事联系：1122423@qq.com 有事没事联系：1122423@qq.com 有事没事联系：1122423@qq.com有事没事联系：1122423@qq.com.cn 有事没事联：1122423@qq.com.cn 有事没事联系：1122423@163.com 有事没事联系：1122423@qq.net";
        catchMail(str);
    }

    /**
     * @param str
     * @ [a-zA-Z0-9]{2,} .com .cn .com.cn .net
     * 邮箱号分析：
     * 1.不能以0开头，可以以字母或数字及_(下划线)开头
     * 2.长度2到12
     * 3.以@联接
     */
    public static void catchMail(String str) {
        Pattern p = compile("[a-zA-Z1-9]\\w{1,11}@[a-zA-Z0-9]{2,}(\\.[a-z]{2,3}){1,2}");
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
