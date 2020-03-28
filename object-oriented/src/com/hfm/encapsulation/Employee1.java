package com.hfm.encapsulation;

/**
 * 普通类 没有进行封装
 * @author hfm
 * @version 1.01 2020-03-26 21:03
 * @date 2020/3/26
 */
public class Employee1 {
    /**
     * 没有进行封装
     */
    String name;
    String id;
    String gender;

    /**
     * 公共方法
     */
    public void work() {
        System.out.println(id + ":" + name + ":" + gender + " 努力工作中！！！");
    }

}
