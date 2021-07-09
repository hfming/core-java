package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 10:47
 * @Description
 * @date 2021/7/7
 */
public class InstanceVariable1 {
    /**
     * 实例变量
     */
    public String HELLOWORLD = "hello world 5";

    /**
     * 构造代码块
     */
    {
        HELLOWORLD = "构造代码块";
    }

    public static void main(String[] args) {
        InstanceVariable1 constClass5 = new InstanceVariable1();
        System.out.println(constClass5.HELLOWORLD);
        // 显示初始化语句与构造代码块的初始化顺序与位置有关，谁在前面的谁先执行
    }
}

