package com.hfming.interfacekeywords;

/**
 * 接口的使用
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class InterfaceTest {
    public static void main(String[] args) {
        Pencil pencil = new Pencil();
        // 使用default方法
        pencil.rewrite();
        // 使用
        pencil.remove();
    }
}
