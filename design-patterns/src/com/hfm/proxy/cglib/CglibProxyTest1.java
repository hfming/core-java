package com.hfm.proxy.cglib;

/**
 * @author hfm
 * @version 1.01 2020-04-04 19:06
 * @date 2020/4/4
 */
public class CglibProxyTest1 {
    public static void main(String[] args) {
//        AdminCglibService target = new AdminCglibService();
//        AdminServiceCglibProxy proxyFactory = new AdminServiceCglibProxy(target);
//        // 获取代理对象
//        AdminCglibService proxy = (AdminCglibService)proxyFactory.getProxyInstance();
//        System.out.println("代理对象：" + proxy.getClass());
//        Object obj = proxy.find();
//        System.out.println("find 返回对象：" + obj.getClass());
//        System.out.println("----------------------------------");
//        proxy.update();
    }
}

/**
 * 被代理类
 */
class AdminCglibService {
    public void update() {
        System.out.println("修改管理系统数据");
    }

    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}

//
//class AdminServiceCglibProxy implements MethodInterceptor {
//    private Object target;
//
//    public AdminServiceCglibProxy(Object target) {
//        this.target = target;
//    }
//
//    /**
//     * 给目标对象创建一个代理对象
//     */
//    public Object getProxyInstance() {
//        // 工具类
//        Enhancer en = new Enhancer();
//        // 设置父类
//        en.setSuperclass(target.getClass());
//        // 设置回调函数
//        en.setCallback(this);
//        // 创建子类代理对象
//        return en.create();
//    }
//
//    public Object intercept(Object object, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
//        System.out.println("判断用户是否有权限进行操作");
//        Object obj = method.invoke(target);
//        System.out.println("记录用户执行操作的用户信息、更改内容和时间等");
//        return obj;
//    }
//}
