package com.hfm.innerclass;

/**
 * @author hfm
 * @version 1.01 2020-04-04 16:00
 * @date 2020/4/4
 */
public class AnonymousTest2 {
    public static void main(String[] args) {
        new AnonymousTest2().callInner(new A() {
            //接口是不能new但此处比较特殊是子类对象实现接口，只不过没有为对象取名
            @Override
            public void fun1() {
                System.out.println("implement for fun1");
            }
        }); // 两步写成一步了
    }
    public void callInner(A a) {
        a.fun1();
    }
}

interface A {
    public abstract void fun1();
}