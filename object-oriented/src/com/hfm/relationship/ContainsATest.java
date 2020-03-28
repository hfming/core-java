package com.hfm.relationship;

/**
 * 类与类之间的关系
 * 组合 Demo
 *
 * @author hfm
 * @version 1.01 2020-03-26 19:25
 * @date 2020/3/26
 */
public class ContainsATest {
    public static void main(String[] args) {
        Car car = new Car(new Engine());
    }
}

/**
 * 实体类 车类
 */
class Car {
    /**
     * 组合中成员变量 ，一般用构造函数。
     */
    private Engine engine;

    public Car(Engine engine) {
        engine.start();
        System.out.println("可以开车了！");
    }
}

/**
 * 实体类 引擎类
 */
class Engine {
    public void start(){
        System.out.println("引擎启动！");
    }
}