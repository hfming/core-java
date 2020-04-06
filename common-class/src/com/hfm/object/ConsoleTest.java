package com.hfm.object;

import java.io.Console;

/**
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class ConsoleTest {
    public static void main(String[] args) {
        // 在System类中
        Console console = System.console();
        //console.flush();
        System.out.println("请输入密码");

        String name = console.readLine("User name: ");
        // console.readPassword() 返回字节数组
        char[] password = console.readPassword("password:");

        System.out.println(new String(password));
    }
}
