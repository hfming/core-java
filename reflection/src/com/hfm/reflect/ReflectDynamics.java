package com.hfm.reflect;

import java.util.Scanner;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-25 12:23
 * @Description 反射的动态性
 * @date 2021/6/25
 */
public class ReflectDynamics {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException  {
        System.out.println("1.Date 2.String 3.Integer");
        System.out.print("请输入数字1-3：");

        String className = null;
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                className = "java.util.Date";
                break;
            case 2:
                className = "java.lang.String";
                break;
            case 3:
                className = "java.number.integer";
                break;
            default:
                System.out.println("输入的数字错误");
                break;
        }
        Class<?> aClass = Class.forName(className);

        Object o = aClass.newInstance();
        System.out.println(o);
    }
}
