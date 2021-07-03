package com.hfm.anonymous;

/**
 * 匿名类 demo
 * @author hfm
 * @version 1.01 2020-03-26 20:47
 * @date 2020/3/26
 */
public class AnonymousTest {
    public static void main(String[] args) {
        // 创建的对象没有引用类型变量引用
        // 匿名对象只能使用一次，一般用来调用对象的方法
        //
        new Print().print();
    }
}

/**
 * 实体类
 */
class Print{
    public void print(){
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(i+"*"+j+"="+(i*j)+"    ");
            }
            System.out.println();
        }
    }
}