package com.hfm.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description JDK5.0 新增加的实现Callable 接口创建自定义线程类
 * @date 2020-05-08 11:49
 */

/**
 * 1.创建实现Callable 接口 的实现类
 */
public class CallableTest implements Callable {
    /**
     * 2. 重写 Callabe 接口的 call() 方法（回调方法）
     * 将此线程需要执行的方法定义在call方法中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        // call 方法可以有返回值
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3. 创建实现 Callable 接口的实现类对象
        CallableTest callableTest = new CallableTest();
        // 4.创建 FutureTask 对象，通过FutureTask 的构造函数将 Callable 实现类对象传入 FutureTask 对象
        FutureTask futureTask = new FutureTask<>(callableTest);

        // FutureTask 类实现了 Runnable 接口
        // 但是其本身不能启动线程，需要将 FutureTask 类对象通过 Thread 类的构造函数传入，创建Thread 类对象，调用 start 方法才能够启动线程
        // 5. 创建 Thread 对象，通过 Thread 的构造函数将 FutureTask 对象传入
        new Thread(futureTask).start();

        // get 方法返回值，即为 FutureTask 构造器参数Callable 实现类对象的call 方法和返回值
        // 6. 调用 FuntureTask 的get() 方法得到返回值，FuntureTask 的 get方法会自动回调 Callable 实现类对象的call方法
        Object o = futureTask.get();
        // 打印输出 FutureTask get() 方法返回的对象
        System.out.println(o);
    }
}
