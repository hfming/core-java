package com.hfm.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hfm
 * @version 1.01 2020-04-04 18:31
 * @date 2020/4/4
 */
public class DynamicProxyTest2 {
    public static void main(String[] args) {
        // 返回一个Proxy的一个实例对象，这里可以debug去追溯追溯
        Hello helloProxy = new DynamicProxy(new HelloImpl()).getProxy();
        // 判断是不是Proxy的一个实例  
        System.out.println(helloProxy instanceof Proxy);
        // 这里可以看出helloProxy的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了Hello接口  

        System.out.println("helloProxy的Class类是：" + helloProxy.getClass().toString());
        System.out.println("\n" + "helloProxy的父类是：" + helloProxy.getClass().getSuperclass());
        System.out.print("\n" + "helloProxy实现的接口是：");
        Class<?>[] interfaces = helloProxy.getClass().getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.print(i.getName() + ", ");
        }
        helloProxy.say("Jack");
        helloProxy.say2("Wade");
    }
}

/**
 * 实体类需要实现的接口
 */
interface Hello {
    void say(String name);

    void say2(String name);
}

/**
 * 实现类 需要被代理的类
 */
class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello!" + name);
    }

    @Override
    public void say2(String name) {
        System.out.println("HEllo!" + name + "用来测试的");
    }
}

/**
 * 代理类
 */
class DynamicProxy implements InvocationHandler {
    private Object target;

    /**
     * 这里就传入了一个动态代理对象
     *
     * @param target
     */
    public DynamicProxy(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before代理");
    }

    private void after() {
        System.out.println("After代理");
    }
}
