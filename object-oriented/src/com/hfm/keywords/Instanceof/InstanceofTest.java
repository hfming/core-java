package com.hfm.keywords.Instanceof;

/**
 * instanceof关键字的使用
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class InstanceofTest {
    public static void main(String[] args) {
        // 两个类不存在继承或实现的关系而使用instanceof关键字进行判断会出现编译报错
        // System.out.println(mouse instanceof Dog);
        byte[] bs = new byte[]{1, 2, 3};
        int[] is = new int[]{1, 2, 3};
        String[] ss = new String[]{"jack", "lucy", "lili"};
        // true
        System.out.println(bs instanceof byte[]);
        // true
        System.out.println(is instanceof int[]);
        // true
        System.out.println(ss instanceof String[]);
        // 不可转换的类型
        // System.out.println(bs instanceof int[]);

        Rectangle rectangle = new Rectangle(12, 33);
        // true
        System.out.println(rectangle instanceof MyShape);
        Circle circle = new Circle(3);
        // true
        System.out.println(circle instanceof Circle);
    }
}
