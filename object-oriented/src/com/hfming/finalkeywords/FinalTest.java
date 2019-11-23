package com.hfming.finalkeywords;

/**
 * final 关键字的使用
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class FinalTest {
    public static void main(String[] args) {
        // 创建一个circle类
        Circle circle = new Circle(1.05);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

        // 创建一个rectange类
        Rectangle rectangle = new Rectangle(5,7);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
