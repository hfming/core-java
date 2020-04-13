package com.hfm.annotation;

/**
 * @author hfm
 * @version 1.01 2020-04-08 20:23
 * @date 2020/4/8
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int a = 10;
    }

    @Deprecated
    public void print() {
        System.out.println("过时的方法");
    }

    @Override
    public String toString() {
        return "重写的toString方法()";
    }
}
