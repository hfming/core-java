package com.hfm.object;

/**
 * 创建一个简单的实体类 Java bean
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Phone {
    // 定义公共属性 | 成员属性
    /**
     * 品牌
     */
    String brand;
    /**
     * 价格
     */
    Double price;
    /**
     * 颜色
     */
    String color;

    /**
     * 公共方法 | 成员方法
     */
    public static void call() {
        System.out.println("call me!");
    }

    /**
     * 私有方法 ,只能在本类中使用
     */
    private static void sendMessage() {
        System.out.println("发短信");
    }
}
