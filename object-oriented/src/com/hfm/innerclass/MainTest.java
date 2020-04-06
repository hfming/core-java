package com.hfm.innerclass;

/**
 * 内部类测试
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class MainTest {
    public static void main(String[] args) {
        Human human = new Human("gt", 32);
        // 创建内部类的方式
       Human.heart heart = new Human("gt", 32).new heart();

        new Human("hfm", 33).show();
    }
}
