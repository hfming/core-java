package com.hfm.encapsulation;

/**
 * @author hfm
 * @version 1.01 2020-03-26 21:06
 * @date 2020/3/26
 */
public class Employee2Test {
    public static void main(String[] args) {
        // 创建对象
        Employee2 jack = new Employee2();
        // 编译报错，使用 private 对属性进行封装不能使用 对象.属性 进行访问
        //jack.name = "jack";
        //jack.id = "123456";
        //jack.gender = "男";
        // 编译报错
        //jack.gender = "不是男人";
        jack.work();
    }
}
