package com.hfm.pattern.proxy;

/**
 * 静态代理
 *
 * @author hfm
 * @version 1.01 2020-03-27 21:18
 * @date 2020/3/27
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminServiceProxy proxy = new AdminServiceProxy(adminService);
        proxy.update();
        System.out.println("=============================");
        proxy.find();
    }
}
