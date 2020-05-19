package com.hfm.regular;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 20:20
 */
public class RegularTest {
    /**
     * 只能输入数字
     */
    private static void onlyNumber(String str) {
        boolean flag = str.matches("[0-9]+");
        System.out.println(flag ? "输入正确" : "只能输入数字");
    }

    /**
     * 校验一个QQ号码 1. 首位不能为0； 2. 长度： 4~ 12. 3. 全部是数字组成
     */
    private static void judgeQQ(String qq) {
        // 第一位1到9，之后有3到12位数字
        boolean flag = qq.matches("[1-9]\\d{3,11}");
        System.out.println(flag ? "合法" : "非法");
    }

    /**
     * 根据重叠词进行切割。
     * 后面的一个正则字符要使用到前面正则匹配的内容。 前面正则的内容需要被复用起来。 如果正则的内容需要被复用，那么就需要进行分组。
     * 每一个组都有一个编号，编号从1开始。
     */
    private static void splitByRepetition(String str) {
        String[] arr = str.split("(.)\\1+");
        for (String s : arr) {
            System.out.println(s);
        }
    }

    /**
     * 匹配一个手机号 手机号码的规则： 1. 首位必须是1. 2. 第二位： 3 4 、5 、 7、 8、 3. 长度必须是11位
     */
    public static void matchPhone(String phone) {
        String reg = "1[34578]\\d{9}";
        System.out.println(phone.matches(reg) ? "合法手机号" : "非法手机号");
    }

    /**
     * 匹配一个固定电话 规则： 区号： 1. 长度3~4位. 2. 必须以0开头。 主机号： 1.首位不能是0. 2.长度 是： 7~8位
     */
    public static void matchTel(String tel) {
        String reg = "0\\d{2,3}-[1-9]\\d{6,7}";
        System.out.println(tel.matches(reg) ? "合法固话号" : "非法固话号");
    }

    /**
     * 需求： 根据空格切割。
     */
    public static void splitByNull() {
        String str = "明 天 学 i o";
        String reg = " +";
        String[] datas = str.split(reg);
        System.out.println("数组的元素：" + Arrays.toString(datas));
    }

    /**
     * 需求： 把手机号替换成***。 一3五
     */
    public static void repalcePhone() {
        String str = "如果有需要请联系：13556084321如果有需要请联系：13556084321如果有需要请联系：13556084321如果有需要请联系：13556084321"
                + "如果有需要请联系：13556084321如果有需要请联系：13556084321如果有需要请联系：13556084321如果有需要请联系：13556084321如果有需要请联系：13556084321";
        String reg = "1[34578]\\d{9}";
        str = str.replaceAll(reg, "****");
        System.out.println("帖子的内容：" + str);
    }

    /**
     * 需求： 把重叠词替换成单个字符。
     */
    @Test
    public  void repalce2() {
        String str = "我我我我我要要要成成成成成成为为高富富富富富富帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅帅";
        str = str.replaceAll("(.)\\1+", "$1");
        // 注意引用正则的内容如果不是在一个正则表达式内部，
        // 那么需要使用()进行分组，每一个组都有编号
        // \\1 引用第一组的内容          +表示有多个
        // ： "$组号" 进行引用
        System.out.println(str);
    }

    /**
     * 获取由 3 个字母组成的单词。
     */
    public static void getDemo() {
        String str = "da jia zhu yi le,ming tian bu fang jia,xie xie!";
        // 想要获取由3个字母组成的单词。
        // 刚才的功能返回的都是一个结果，只有split返回的是数组，但是它是把规则作为分隔符，不会获取符合规则的内容。
        // 这时我们要用到一些正则对象。
        String reg = "\\b[a-z]{3}\\b";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.start() + "...." + m.end());
            System.out.println("sub:" + str.substring(m.start(), m.end()));
            System.out.println(m.group());
        }
        //将规则对字符串进行匹配查找。
        System.out.println(m.find());
        //将规则对字符串进行匹配查找。
        System.out.println(m.find());
        //在使用group方法之前，必须要先找，找到了才可以取。
        System.out.println(m.group());
    }

    /**
     * 校验邮件
     */
    public static void checkMail() {
        String mail = "abc123@sina.com.cn";
        //mail = "1@1.1";
        String reg = "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        reg = "\\w+@\\w+(\\.\\w+)+";
        // 简化的规则。笼统的匹配。
        boolean b = mail.matches(reg);
        System.out.println(mail + ":" + b);
    }
}
