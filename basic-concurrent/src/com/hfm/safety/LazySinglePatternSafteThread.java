package com.hfm.safety;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-20 20:27
 * @Description 懒汉单例设计模式线程安全问题的解决
 * @date 2021/6/20
 */
public class LazySinglePatternSafteThread {
    /**
     * 2.创建本类私有对象的引用
     */
    private static volatile LazySinglePatternSafteThread lazySinglePatternSafteThread;

    /**
     * 1.私有化构造函数
     */
    private LazySinglePatternSafteThread() {

    }

    /**
     * 3.提供公共静态方法返回本类对象
     * synchronized 同步函数或者同步代码块
     * 锁对象为当前类对象
     *
     * @return
     */
    public static LazySinglePatternSafteThread getLazySinglePatternSafteThread() {
        // 方式一：效率差
//        synchronized (LazySinglePatternSafteThread.class) {
//            if (lazySinglePatternSafteThread == null) {
//                lazySinglePatternSafteThread = new LazySinglePatternSafteThread();
//            }
//            return lazySinglePatternSafteThread;
//        }

        // 方式二： DDL 效率高
        if (lazySinglePatternSafteThread == null) {
            synchronized (LazySinglePatternSafteThread.class) {
                if (lazySinglePatternSafteThread == null) {
                    lazySinglePatternSafteThread = new LazySinglePatternSafteThread();
                }
            }
        }
        return lazySinglePatternSafteThread;
    }
}
