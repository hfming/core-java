package com.hfm.enumdemo;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-05 12:12
 * @Description
 * @date 2021/6/5
 */
public class EnumAndInterface {
    public static void main(String[] args) {
        USBEnum1.LOPTOP.getINFO();
        System.out.println(USBEnum1.LOPTOP);
    }
}

interface USB {
    void fun();
}

/**
 * 情况二：创建的是一个抽象枚举类，枚举对象是抽象枚举类的子类对象
 * 枚举类的对象分别实现抽象方法
 */
enum USBEnum1 implements USB {
    /**
     * 3.创建多个枚举类的子类对象，并实现抽象方法，默认修饰符为 public final static
     */
    LOPTOP("笔记本") {
        @Override
        public void fun() {
            System.out.println("笔记本");
            System.out.println(this.getINFO());
            System.out.println(this.toString());
        }
    },
    PHONE("手机") {
        @Override
        public void fun() {
            System.out.println("手机");
            System.out.println(this.getINFO());
            System.out.println(this.toString());
        }
    };

    /**
     * 1.创建私有静态成员变量，默认修饰符为 private final
     */
    private final String INFO;

    /**
     * 2.私有化构造函数，并属性进行初始化， 默认修饰符为 private
     */
    private USBEnum1(String info) {
        this.INFO = info;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("USBEnum{");
        sb.append("INFO='").append(INFO).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getINFO() {
        return INFO;
    }
}

/**
 * 情况一：枚举类实现了接口，在枚举类中实现了抽象方法，枚举对象就是枚举类自身的枚举值对象
 */
enum USBEnum2 implements USB {
    /**
     * 3.创建多个枚举类对象，默认修饰符为 public final static
     */
    LOPTOP("笔记本"),
    PHONE("手机");

    /**
     * 1.创建私有静态成员变量，默认修饰符为 private final
     */
    private final String INFO;

    /**
     * 2.私有化构造函数，并属性进行初始化， 默认修饰符为 private
     */
    private USBEnum2(String info) {
        this.INFO = info;
    }

    @Override
    public void fun() {
        System.out.println(this.getINFO());
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("USBEnum{");
        sb.append("INFO='").append(INFO).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getINFO() {
        return INFO;
    }
}