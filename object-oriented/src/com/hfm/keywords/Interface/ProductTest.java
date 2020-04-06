package com.hfm.keywords.Interface;

/**
 * @author hfm
 * @version 1.01 2020-04-04 16:12
 * @date 2020/4/4
 */
public class ProductTest {
    public static void main(String[] args) {
        ProductTest tp = new ProductTest();
        Product p = tp.getProduct();

        System.out.println(p.getName());
        System.out.println(p.getPrice());
        // ----------------------
        tp.showProduct(p);
        // ------------------------
        // 创建了一个匿名类的对象。
        tp.showProduct(new Product() {
            @Override
            public int getPrice() {
                return 7899;
            }
            @Override
            public String getName() {
                return "iphone5s-土豪金";
            }
        });
    }

    public Product getProduct() {
        // 创建了一个局部内部类的对象
        // class MyProduct implements Product{
        //
        // @Override
        // public int getPrice() {
        // // TODO Auto-generated method stub
        // return 3899;
        // }
        //
        // @Override
        // public String getName() {
        // // TODO Auto-generated method stub
        // return "ipad air";
        // }
        //
        // }
        // return new MyProduct();
        // 创建了一个匿名内部类的对象。
        return new Product() {
            @Override
            public int getPrice() {
                return 7899;
            }
            @Override
            public String getName() {
                return "iphone5s-土豪金";
            }
        };
    }

    public void showProduct(Product p) {
        System.out.println(p.getName());
        System.out.println(p.getPrice());
    }
}

interface Product {
    public abstract int getPrice();

    public abstract String getName();
}
