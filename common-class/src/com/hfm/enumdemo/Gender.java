package com.hfm.enumdemo;

/**
 * 抽象枚举类
 */
enum Gender {
    // 枚举对象，枚举对象与对象之间通过逗号隔开
    MAN("男") {
        @Override
        public void speak() {
            System.out.println("是男人");
        }
    },
    WOMAN("女") {
        @Override
        public void speak() {
            System.out.println("是女人");
        }
    };
    /**
     * 成员变量
     */
    private final String INFO;

    /**
     * 构造函数
     */
    private Gender(String info) {
        this.INFO = info;
    }

    /**
     * 成员方法
     */
    public String getInfo() {
        return INFO;
    }

    public abstract void speak();
}