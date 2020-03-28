package com.hfm.initialize;

/**
 * 继承情况下初始化语句的执行顺序
 * 测试类
 *
 * @author hfm
 * @version 1.01 2020-03-24 20:35
 * @date 2020/3/24
 */
public class InitlizeTest {
    public static void main(String[] args) {
        // 创建2个对象
        InitlizeChild2 initlizeChild2 = new InitlizeChild2();
        InitlizeChild2 initlizeChild = new InitlizeChild2();

        Initialze initial = new Initialze();
        Initialze initial1 = new Initialze();
    }
}
