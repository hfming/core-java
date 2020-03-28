package com.hfm.pattern.proxy;

/**
 * 代理类
 *
 * @author hfm
 * @version 1.01 2020-03-27 21:20
 * @date 2020/3/27
 */
public class AdminServiceProxy implements AdminService {
    private AdminService adminService;

    public AdminServiceProxy(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void update() {
        System.out.println("判断用户是否有权限进行update操作");
        adminService.update();
        System.out.println("记录用户执行update操作的用户信息、更改内容和时间等");
    }

    @Override
    public Object find() {
        System.out.println("判断用户是否有权限进行find操作");
        System.out.println("记录用户执行find操作的用户信息、查看内容和时间等");
        return adminService.find();
    }
}
