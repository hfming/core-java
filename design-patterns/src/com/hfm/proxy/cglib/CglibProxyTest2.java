package com.hfm.proxy.cglib;

/**
 * @author hfm
 * @version 1.01 2020-04-04 19:13
 * @date 2020/4/4
 */
public class CglibProxyTest2 {
    public static void main(String[] args) {
//        BookFacadeCglib cglib=new BookFacadeCglib();
//        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());
//        bookCglib.addBook();
    }
}

/**
 * 被代理类
 */
class BookFacadeImpl1 {
    public void addBook() {
        System.out.println("增加图书的普通方法...");
    }
}

/**
 * 代理类
 */
//public class BookFacadeCglib implements MethodInterceptor {
//    private Object target;
//
//    /**
//     * 创建代理对象
//     *
//     * @param target
//     * @return
//     */
//    public Object getInstance(Object target) {
//        this.target = target;
//        // 工具类 创建Enhancer实例
//        Enhancer enhancer = new Enhancer();
//        // 方法通过输入参数即父类的字节码，通过扩展父类的class来创建代理对象
//        // 通过 setSuperclass 方法来设置目标类
//        enhancer.setSuperclass(this.target.getClass());
//        // 回调方法
//        // 通过setCallback 方法来设置拦截对象
//        enhancer.setCallback(this);
//        // 创建代理对象
//        // create方法生成Target的代理类，并返回代理类的实例
//        return enhancer.create();
//    }
//
//    /**
//     * 回调方法，这个方法会拦截目标类的所有方法
//     */
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        System.out.println("事物开始");
//        proxy.invokeSuper(obj, args);
//        System.out.println("事物结束");
//        return null;
//        // obj表示目标类的实例，method为目标类方法的反射对象，args为方法的动态入参，proxy为代理类实例。proxy.invokeSuper(obj, args)通过代理类调用父类中的方法。
//    }
//}
