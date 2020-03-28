package com.hfm.encapsulation;

/**
 * @author hfm
 * @version 1.01 2020-03-26 21:04
 * @date 2020/3/26
 */
public class Employee1Test {
    public static void main(String[] args) {
        // 创建 Employee1 对象，对象.成员的方式进行赋值。最后该对象调用工作方法。
        Employee1 jack = new Employee1();
        // 进制通过类名.成员的形式调用成员。初始化实例变量
        jack.name = "jack";
        jack.id = "123456";
        jack.gender = "男";
        // 调用成员方法
        jack.work();
        System.out.println();
        // 传入非法的参数
        // 如果不使用封装，很容易赋值错误，传入非法参数，并且任何人都可以更改，造成信息的不安全。
        jack.gender = "不是男人";
        jack.work();
    }
}
