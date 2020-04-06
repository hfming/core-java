package com.hfm.encapsulation;

/**
 * 封装类
 *
 * @author hfm
 * @version 1.01 2020-03-26 21:05
 * @date 2020/3/26
 */
public class Employee2 {
    /**
     * 使用了private修饰了成员变量
     * private 修饰的成员在自己所在的类中可以使用，在类外边不可以使用。
     */
    private String name;
    private String id;
    private String gender;

    /**
     * 公共方法
     */
    public void work() {
        System.out.println(id + ":" + name + ":" + gender + " 努力工作中！！！");
    }
}
