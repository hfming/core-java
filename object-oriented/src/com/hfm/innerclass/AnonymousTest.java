package com.hfm.innerclass;

/**
 * @author hfm
 * @version 1.01 2020-04-04 15:58
 * @date 2020/4/4
 */

public class AnonymousTest {
    public void test(Product p) {
        System.out.println("购买了一个" + p.getName() + "，花掉了" + p.getPrice());
    }

    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();
        //调用test方法时，需要传入一个Product参数，
        //此处传入其匿名实现类的实例
        ta.test(new Product() {
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "AGP显卡";
            }
        });
    }
}

interface Product {
    public double getPrice();

    public String getName();
}