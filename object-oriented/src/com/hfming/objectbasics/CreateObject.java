package com.hfming.objectbasics;

/**
 * 创建对象练习
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class CreateObject {
    public static void main(String[] args) {
        // 创建一个对象
        Phone phone = new Phone();
        // 对象属性进行赋值
        phone.brand ="苹果";
        phone.color ="黑色";
        phone.price = 5000.0;

        System.out.println(phone.brand);
        System.out.println(phone.color);
        System.out.println(phone.price);
        // 公有方法可以被调用
        phone.call();
        // 私有方法不能在本类之外被调用
        //phone.sendMessage();
    }
}
