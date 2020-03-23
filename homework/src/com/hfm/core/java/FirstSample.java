package com.hfm.core.java;

/**
 * 这是Core Java第3章中的第一个示例程序
 * 
 * @version 1.03 2019-09-19
 * @author hfm
 */
public class FirstSample {
    public static void main(String[] args) {
        System.out.println("We will not use 'Hello, World!'");
        
        // Java 10 var 局部变量自动判断参数类型 
        String s1 = "Hello Java!";
        var s2 = "Hello world!";
        System.out.println(s1);
        System.out.println(s2);
    }
}
