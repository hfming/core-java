package com.hfm.polymorphism;

/**
 * 多态测试
 *
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class ShapeTest {
    public static void main(String[] args) {
        // 多态
        MyShape shape1 = new Circle(4);
        MyShape shape2 = new Rectangle(2, 4);

        // 多态可以接受MyShape及其子类
        System.out.println(getShape(shape1).getClass());
        System.out.println(getShape(shape2).getClass());

        if (shape1 instanceof Circle) {
            // 多态情况下，父类的引用类型变量不能使用子类特有的方法，如果要使用需要进行强制数据类型转换
            ((Circle) shape1).printCircle();
        }
    }

    /**
     * 定义一个方法可以接收MyShape类及其子类，可以返回MyShape及其子类
     *
     * @param shape
     * @return
     */
    public static MyShape getShape(MyShape shape) {
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
        return shape;
    }
}
