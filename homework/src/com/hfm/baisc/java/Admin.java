package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习 编写一个方法接受一个用户名与密码，如果输入的用户名不是admin密码不是888，那么继续提示用户“用户名或者密码错误”，否则提示用户输入正确。
 *
 * @author hfmn
 * @version 1.01 2019-10-15
 */
public class Admin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入密码");
        String scrit = scanner.next();
        if (("admin").equals(name) && ("888").equals(scrit)) {
            System.out.println("登陆成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }
}
