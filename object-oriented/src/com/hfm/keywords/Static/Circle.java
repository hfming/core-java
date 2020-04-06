package com.hfm.keywords.Static;

/**
 * @author hfm
 * @version 1.01 2020-04-03 20:37
 * @date 2020/4/3
 */
public class Circle {
    private double radius;
    public static String name = "这是一个圆";
    public static String getName() {
        return name;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double findArea() {
        return Math.PI * radius * radius;
    }
    public void display() {
        System.out.println("name:" + name + "radius:" + radius);
    }
}
