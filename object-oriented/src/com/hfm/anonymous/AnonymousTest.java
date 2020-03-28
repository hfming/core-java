package com.hfm.anonymous;

/**
 * 匿名类 demo
 * @author hfm
 * @version 1.01 2020-03-26 20:47
 * @date 2020/3/26
 */
public class AnonymousTest {
    public static void main(String[] args) {
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