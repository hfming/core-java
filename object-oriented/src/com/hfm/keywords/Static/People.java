package com.hfm.keywords.Static;

/**
 * 统计一个类创建对象的个数。 静态成员变量的应用场景之一。
 *
 * @author hfm
 */
public class People {
    int id;
    String name;
    /**
     * 定义一个计数器 非静态成员变量。
     */
    static int count = 0;

    /**
     *
     构造代码块
     */ {
        count++;
    }

    public People() {
    }

    /**
     * 构造函数
     */
    public People(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("构造函数调用了....");
    }
}
