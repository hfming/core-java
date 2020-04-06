package com.hfm.proxy.dynamic;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hfm
 * @version 1.01 2020-04-04 17:44
 * @date 2020/4/4
 */
public class DynamicProxyTest1 {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        // 【原始的类型 class UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstanceLambda();

        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }
}

/**
 * 代理接口
 */
interface IUserDao {
    void save();
}

/**
 * 实现类
 */
class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}

/**
 * 代理类
 */
class ProxyFactory {
    /**
     * 维护一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 这是Java8语法
     *
     * @return
     */
    public Object getProxyInstanceLambda() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开始事务2");
                    //执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务2");
                    return returnValue;
                });
    }

    /**
     * 传统语法
     *
     * @return
     */
//    public Object getProxyInstance() {
//        return Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new InvocationHandler() {
//
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("开始事务2");
//                        //执行目标对象方法
//                        Object returnValue = method.invoke(target, args);
//                        System.out.println("提交事务2");
//                        return returnValue;
//                    }
//                });
//    }
}
