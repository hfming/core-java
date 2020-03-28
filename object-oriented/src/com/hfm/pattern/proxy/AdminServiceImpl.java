package com.hfm.pattern.proxy;

/**
 * 实现类，被代理类
 *
 * @author hfm
 * @version 1.01 2020-03-27 21:20
 * @date 2020/3/27
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public void update() {
        System.out.println("修改管理系统数据");
    }

    @Override
    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}
