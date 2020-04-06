package com.hfm.keywords.Final;

import java.io.Serializable;

/**
 * final 关键字的使用
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class FinalTest implements Serializable {

    private static String name = "hfm";

    public static void main(String[] args) {
        // 创建一个circle类
        Circle circle = new Circle(1.05);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

        // 创建一个rectange类
        Rectangle rectangle = new Rectangle(5, 7);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        FinalTest t = new FinalTest();
        //System.out.println(t.ID);

        final int I = 10;
        final int J;
        J = 20;
        // 非法
        //J = 30;
    }

    public static int totalNumber = 5;

    //public final int ID;
    public void Test() {
        // 可在构造器中给final修饰的“变量”赋值
        //ID = ++totalNumber;
    }
}
